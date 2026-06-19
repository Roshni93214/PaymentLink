package Razorpay.paymentlink.DTO.PaymentLinks.Response;

import java.util.Map;

import Razorpay.paymentlink.DTOs.CustomerDTO;
import Razorpay.paymentlink.DTOs.NotifyDTO;
//import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class  FetchAllStandardPaymentLinkResponseDTO {
   Boolean acceptPartial;
   Integer amount;
   Integer amountPaid;
   String callbackUrl;
   String callbackMethod;
   Integer createdAt;
   Integer cancelledAt;
   String currency;
//Customer 
   String description;
   Integer expireBy;
   Integer expiredAt;
   Integer firstMinPartialAmount;
   String id;
   Boolean upiLink;
//Notes notify
private CustomerDTO customer; // Optional nested object
    private NotifyDTO notify; // Optional nested object
    private Map<String, String> notes;

   //Payments
   String referenceId;
   String shorturl;
   String status;
   Integer updatedAt;
   Boolean reminderEnable;
  String userID;
  
}