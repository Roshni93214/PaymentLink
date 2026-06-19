package Razorpay.paymentlink.DTO.PaymentLinks.Requests;

import java.util.HashMap;
import java.util.Map;

//import Razorpay.paymentlink.DTO.PaymentLinks.Response.CreateStandardPaymentLinkResponseDTO;
//import Razorpay.paymentlink.Entity.Payments.Customer;
//import Razorpay.paymentlink.Entity.Payments.Notes;
//import Razorpay.paymentlink.Entity.Payments.Notify;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStandardPaymentLinkRequestDTO {
   String currency;
   Integer amount;
   Boolean acceptPartial;
   Integer FirstMinPartialAmount;
   Boolean upiLink;
   String description;
   String reference_id;
   //Customer json object
   Integer expireBy;
   //Customer customer;
   //Customer customer;
   CustomerDTO customer;
//Notify array,  notes json object
  NotifyDTO notify;
  Map<String,String> notes= new HashMap<>();
   String callbackUrl;
   String callbackMethod;
   Boolean reminderEnable;
   
}