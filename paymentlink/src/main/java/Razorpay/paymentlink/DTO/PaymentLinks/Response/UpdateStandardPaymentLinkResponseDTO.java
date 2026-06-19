package Razorpay.paymentlink.DTO.PaymentLinks.Response;

import java.util.HashMap;
import java.util.Map;

import Razorpay.paymentlink.DTO.PaymentLinks.Requests.CustomerDTO;
import Razorpay.paymentlink.DTO.PaymentLinks.Requests.NotifyDTO;
import Razorpay.paymentlink.DTO.PaymentLinks.Requests.RemindersDTO;
//import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class  UpdateStandardPaymentLinkResponseDTO {
   Boolean acceptPartial;
   Integer amount;
   Integer amountPaid;
   String callbackUrl;
   String callbackMethod;
   Integer createdAt;
   Integer cancelledAt;
   String currency;
//Customer 
CustomerDTO customer;
   String description;
   Integer expireBy;
   Integer expiredAt;
   Integer firstMinPartialAmount;
   String id;
   Boolean upiLink;
//Notes notify
   //Payments
   Map<String,String> notes= new HashMap<>();
   NotifyDTO notify;
   String referenceId;
   String shorturl;
   String status;
   Integer updatedAt;
   Boolean reminderEnable;
  String userID;
  RemindersDTO reminders;
  //Reminders object
}