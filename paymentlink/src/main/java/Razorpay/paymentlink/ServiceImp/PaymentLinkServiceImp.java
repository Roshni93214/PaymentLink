package Razorpay.paymentlink.ServiceImp;

import org.springframework.stereotype.Service;

import Razorpay.paymentlink.DTO.PaymentLinks.Requests.CreateStandardPaymentLinkRequestDTO;
import Razorpay.paymentlink.DTO.PaymentLinks.Response.CreateStandardPaymentLinkResponseDTO;
import Razorpay.paymentlink.Entity.Payments.Customer;
import Razorpay.paymentlink.Entity.Payments.Notes;
import Razorpay.paymentlink.Entity.Payments.Notify;
import Razorpay.paymentlink.Entity.Payments.Payment;
import Razorpay.paymentlink.Entity.Payments.PaymentLink;
import Razorpay.paymentlink.Entity.Payments.Reminders;
import Razorpay.paymentlink.Repository.CustomerRepository;
import Razorpay.paymentlink.Repository.NotesRepository;
import Razorpay.paymentlink.Repository.NotifyRepository;
import Razorpay.paymentlink.Repository.PaymentLinkRepository;
import Razorpay.paymentlink.Repository.PaymentRepository;
import Razorpay.paymentlink.Repository.RemindersRepository;
import Razorpay.paymentlink.Service.PaymentLinkService;

@Service

public class PaymentLinkServiceImp  implements PaymentLinkService
{
 
    private CustomerRepository customerRepository;
    private NotesRepository notesRepository;
    private NotifyRepository notifyRepository;
    private PaymentLinkRepository paymentLinkRepository;
    private RemindersRepository remindersRepository;
    private PaymentRepository paymentRepository;

    public PaymentLinkServiceImp(CustomerRepository customerRepository, NotesRepository notesRepository,NotifyRepository notifyRepository,PaymentLinkRepository paymentLinkRepository,RemindersRepository remindersRepository,PaymentRepository paymentRepository)
    {
        this.customerRepository = customerRepository;
        this.notesRepository=notesRepository;
        this.notifyRepository=notifyRepository;
        this.paymentLinkRepository=paymentLinkRepository;
        this.paymentRepository=paymentRepository;
        this.remindersRepository=remindersRepository;
    }


    @Override
    public CreateStandardPaymentLinkResponseDTO createPaymentLink(
            CreateStandardPaymentLinkRequestDTO createStandardPaymentLinkRequestDTO)
 {
       Customer customer=new Customer();
       Notes notes= new Notes();
       Notify notify = new Notify();
       PaymentLink paymentLink=new PaymentLink();
       Payment payment= new Payment();
       Reminders reminders=new Reminders();

       CreateStandardPaymentLinkResponseDTO createStandardPaymentLinkResponseDTO= new CreateStandardPaymentLinkResponseDTO();


paymentLink.setAcceptPartial(createStandardPaymentLinkRequestDTO.getAcceptPartial());
paymentLink.setAmount(createStandardPaymentLinkRequestDTO.getAmount());
paymentLink.setCurrency(createStandardPaymentLinkRequestDTO.getCurrency());
paymentLink.setFirstMinPartialAmount(createStandardPaymentLinkRequestDTO.getFirstMinPartialAmount());
paymentLink.setCallbackUrl(createStandardPaymentLinkRequestDTO.getCallbackUrl());
paymentLink.setCallbackMethod(createStandardPaymentLinkRequestDTO.getCallbackMethod());
paymentLink.setUpiLink(createStandardPaymentLinkRequestDTO.getUpiLink());
paymentLink.setDescription(createStandardPaymentLinkRequestDTO.getDescription());
paymentLink.setReferenceId(createStandardPaymentLinkRequestDTO.getReference_id());
paymentLink.setExpireBy(createStandardPaymentLinkRequestDTO.getExpireBy());
paymentLink.setReminderEnable(createStandardPaymentLinkRequestDTO.getReminderEnable());

        customer.setName (createStandardPaymentLinkRequestDTO.getName());
        customer.setEmail(createStandardPaymentLinkRequestDTO.getEmail());
        customer.setContact(createStandardPaymentLinkRequestDTO.getContact());

        notes.setNoteKey(createStandardPaymentLinkRequestDTO.getNotes().getNoteKey());



        notify.setSms(createStandardPaymentLinkRequestDTO.getNotify().getSms());
        notify.setEmail(createStandardPaymentLinkRequestDTO.getNotify().getEmail());

        reminders.setStatus(createStandardPaymentLinkRequestDTO.getReminders().getStatus());

        payment.setAmount(createStandardPaymentLinkRequestDTO.getAmount());
payment.setCreatedAt(createStandardPaymentLinkRequestDTO.getCreatedAt());
payment.setUpdatedAt(createStandardPaymentLinkRequestDTO.getUpdateAt());
payment.setMethod(createStandardPaymentLinkRequestDTO.getMethod());
payment.setPaymentId(createStandardPaymentLinkRequestDTO.getPaymentId());
payment.setPStatus(createStandardPaymentLinkRequestDTO.getPStatus());
payment.setPlinkId(createStandardPaymentLinkRequestDTO.getPlinkId());

        Customer savedCustomer=customerRepository.save(customer);
        Notes savedNotes= notesRepository.save(notes);
        Notify savedNotify=notifyRepository.save(notify);
        PaymentLink savedPaymentLink=paymentLinkRepository.save(paymentLink);
        Reminders savedReminders=remindersRepository.save(reminders);
        Payment savedPayment=payment.save(payment);


        createStandardPaymentLinkResponseDTO.setName(savedCustomer.getName());
        createStandardPaymentLinkResponseDTO.setEmail(savedCustomer.getEmail());
        createStandardPaymentLinkResponseDTO.setContact(savedCustomer.getContact());

        createStandardPaymentLinkResponseDTO.setReminders(savedReminders);
        createStandardPaymentLinkResponseDTO.setNotify(savedNotify);
        createStandardPaymentLinkResponseDTO.setNotes(savedNotes);

        createStandardPaymentLinkResponseDTO.setAmount(savedPayment.getAmount());
        createStandardPaymentLinkResponseDTO.setCreatedAt(savedPayment.getCreatedAt());
        createStandardPaymentLinkResponseDTO.setUpdatedAt(savedPayment.getUpdatedAt());
        createStandardPaymentLinkResponseDTO.setMethod(savedPayment.getMethod());
        createStandardPaymentLinkResponseDTO.setPlinkId(savedPayment.getPlinkId());
        createStandardPaymentLinkResponseDTO.setPaymentId(savedPayment.getPaymentId());
        createStandardPaymentLinkResponseDTO.setStatus(savedPayment.getStatus());

        createStandardPaymentLinkResponseDTO.setAcceptPartial(savedPaymentLink.getAcceptPartial());
createStandardPaymentLinkResponseDTO.setAmount(savedPaymentLink.getAmount());
createStandardPaymentLinkResponseDTO.setCurrency(savedPaymentLink.getCurrency());
createStandardPaymentLinkResponseDTO.setFirstMinPartialAmount(savedPaymentLink.getFirstMinPartialAmount());
createStandardPaymentLinkResponseDTO.setCallbackUrl(savedPaymentLink.getCallbackUrl());
createStandardPaymentLinkResponseDTO.setCallbackMethod(savedPaymentLink.getCallbackMethod());
createStandardPaymentLinkResponseDTO.setUpiLink(savedPaymentLink.getUpiLink());
createStandardPaymentLinkResponseDTO.setDescription(savedPaymentLink.getDescription());
createStandardPaymentLinkResponseDTO.setReferenceId(savedPaymentLink.getReferenceId());
createStandardPaymentLinkResponseDTO.setExpireBy(savedPaymentLink.getExpireBy());
createStandardPaymentLinkResponseDTO.setReminderEnable(savedPaymentLink.getReminderEnable());
       return createStandardPaymentLinkResponseDTO;

   }
   
   }

