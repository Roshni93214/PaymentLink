package Razorpay.paymentlink.ServiceImp;

import Razorpay.paymentlink.DTOs.*;
import Razorpay.paymentlink.Entity.Payments.*;
import Razorpay.paymentlink.Repository.*;
import Razorpay.paymentlink.Service.PaymentLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentLinkServiceImpl implements PaymentLinkService {

    // Injecting all 5 independent repositories
    private final PaymentLinkRepository paymentLinkRepository;
    private final CustomerRepository customerRepository;
    private final NotifyRepository notifyRepository;
    private final RemindersRepository remindersRepository;
    private final NotesRepository notesRepository;

    @Override
    @Transactional // Ensures database consistency across all 5 independent saves
    public PaymentLinkResponse createStandardPaymentLink(PaymentLinkRequest request) {
        
        // 1. Generate a mock Razorpay style unique Link ID
        String standardLinkId = "plink_" + UUID.randomUUID().toString().replace("-", "").substring(0, 14);
        long currentTimeMillis = System.currentTimeMillis() / 1000; // UNIX Timestamp format

        // 2. Map and Save the core PaymentLink entity
        PaymentLink paymentLink = new PaymentLink();
        paymentLink.setId(standardLinkId);
        paymentLink.setAmount(request.getAmount());
        paymentLink.setAmountPaid(0); // Brand new link, no amount paid yet
        paymentLink.setCurrency(request.getCurrency() != null ? request.getCurrency() : "INR");
        paymentLink.setAcceptPartial(request.getAcceptPartial());
        paymentLink.setFirstMinPartialAmount(request.getFirstMinPartialAmount());
        paymentLink.setDescription(request.getDescription());
        paymentLink.setReferenceId(request.getReferenceId());
        paymentLink.setReminderEnable(request.getReminderEnable());
        paymentLink.setCallbackUrl(request.getCallbackUrl());
        paymentLink.setCallbackMethod(request.getCallbackMethod());
        paymentLink.setStatus("created"); // Default status as per documentation
        paymentLink.setCreatedAt(currentTimeMillis);
        paymentLink.setUpdatedAt(currentTimeMillis);
        paymentLink.setExpireBy(request.getExpireBy());
        paymentLink.setShortUrl("https://rzp.io/i/" + UUID.randomUUID().toString().substring(0, 7));
        paymentLink.setUserId("usr_mockAdmin123");
        
        // Handling ElementCollection map mapping inside PaymentLink entity
        if (request.getNotes() != null) {
            paymentLink.setNotes(request.getNotes());
        }

        paymentLinkRepository.save(paymentLink);

        // 3. Extract and save Customer into its independent table
        CustomerDTO customerDTO = null;
        if (request.getCustomer() != null) {
            Customer customer = new Customer();
            customer.setCustomerId("cust_" + UUID.randomUUID().toString().replace("-", "").substring(0, 10));
            customer.setPaymentLinkId(standardLinkId); // Linked manually via string!
            customer.setName(request.getCustomer().getName());
            customer.setEmail(request.getCustomer().getEmail());
            customer.setContact(request.getCustomer().getContact());
            customerRepository.save(customer);

            // Populate response sub-object
            customerDTO = new CustomerDTO();
            customerDTO.setName(customer.getName());
            customerDTO.setEmail(customer.getEmail());
            customerDTO.setContact(customer.getContact());
        }

        // 4. Extract and save Notification Settings into its independent table
        NotifyDTO notifyDTO = null;
        if (request.getNotify() != null) {
            Notify notify = new Notify();
            notify.setNotifyId("notif_" + UUID.randomUUID().toString().replace("-", "").substring(0, 10));
            notify.setPaymentLinkId(standardLinkId); // Linked manually via string!
            notify.setEmail(request.getNotify().getEmail());
            notify.setSms(request.getNotify().getSms());
            notifyRepository.save(notify);

            // Populate response sub-object
            notifyDTO = new NotifyDTO();
            notifyDTO.setEmail(notify.getEmail());
            notifyDTO.setSms(notify.getSms());
        }

        // 5. Initialize and save Reminders state into its independent table
        Reminders reminders = new Reminders();
        reminders.setReminderId("rem_" + UUID.randomUUID().toString().replace("-", "").substring(0, 10));
        reminders.setPaymentLinkId(standardLinkId); // Linked manually via string!
        reminders.setStatus("pending"); // Default state for a newly generated link
        remindersRepository.save(reminders);

        RemindersDTO remindersDTO = new RemindersDTO();
        remindersDTO.setStatus(reminders.getStatus());

        // 6. Loop and save audit rows into the independent Notes entity table
        if (request.getNotes() != null) {
            request.getNotes().forEach((key, value) -> {
                Notes noteEntity = new Notes();
                noteEntity.setNoteId("note_" + UUID.randomUUID().toString().replace("-", "").substring(0, 10));
                noteEntity.setPaymentLinkId(standardLinkId); // Linked manually via string!
                noteEntity.setNoteKey(key);
                noteEntity.setNoteValue(value);
                notesRepository.save(noteEntity);
            });
        }

        // 7. Assemble the final Razorpay compliance nested Response DTO
        PaymentLinkResponse response = new PaymentLinkResponse();
        response.setId(paymentLink.getId());
        response.setAmount(paymentLink.getAmount());
        response.setAmountPaid(paymentLink.getAmountPaid());
        response.setCurrency(paymentLink.getCurrency());
        response.setAcceptPartial(paymentLink.getAcceptPartial());
        response.setFirstMinPartialAmount(paymentLink.getFirstMinPartialAmount());
        response.setDescription(paymentLink.getDescription());
        response.setReferenceId(paymentLink.getReferenceId());
        response.setShortUrl(paymentLink.getShortUrl());
        response.setStatus(paymentLink.getStatus());
        response.setReminderEnable(paymentLink.getReminderEnable());
        response.setCallbackUrl(paymentLink.getCallbackUrl());
        response.setCallbackMethod(paymentLink.getCallbackMethod());
        response.setCreatedAt(paymentLink.getCreatedAt());
        response.setUpdatedAt(paymentLink.getUpdatedAt());
        response.setExpireBy(paymentLink.getExpireBy());
        response.setExpiredAt(0L);
        response.setCancelledAt(0L);
        response.setUserId(paymentLink.getUserId());
        response.setWhatsappLink(false);

        // Bind the child responses
        response.setCustomer(customerDTO);
        response.setNotify(notifyDTO);
        response.setReminders(remindersDTO);
        response.setNotes(request.getNotes());
        response.setPayments(new ArrayList<>()); // Empty list array as per creation spec docs

        return response;
    }



 @Override
    public List<PaymentLink> getAllPaymentLinks(String referenceId) {
        // If reference_id is provided via query params, filter by it. Otherwise, return everything.
        if (referenceId != null && !referenceId.trim().isEmpty()) {
            if (referenceId.length() > 40) {
                throw new IllegalArgumentException("The receipt may not be greater than 40 characters.");
            }
            return paymentLinkRepository.findByReferenceId(referenceId);
        }
        return paymentLinkRepository.findAll();
    }
    

     @Override
public PaymentLink getPaymentLinkById(String plinkId) {
    // 1. Precise validation mirroring Razorpay's format rules
    if (plinkId == null || !plinkId.startsWith("plink_") || plinkId.length() != 20) {
        String strippedId = (plinkId != null && plinkId.length() > 6) ? plinkId.substring(6) : plinkId;
        throw new IllegalArgumentException("invalid input [strippedId] = [" + strippedId + "]");
    }

    // 2. Database lookup
    PaymentLink entity = paymentLinkRepository.findByPlinkId(plinkId);
    
    // 3. Fallback check if ID doesn't exist in MySQL
    if (entity == null) {
        throw new IllegalArgumentException("The id provided does not exist");
    }

    return entity;
}


     @Override
     public List<PaymentLink> fetchAllPaymentLinks(String referenceId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fetchAllPaymentLinks'");
     }
    

}