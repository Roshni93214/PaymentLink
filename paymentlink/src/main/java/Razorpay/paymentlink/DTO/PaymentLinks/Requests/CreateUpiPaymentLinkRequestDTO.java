package Razorpay.paymentlink.DTO.PaymentLinks.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpiPaymentLinkRequestDTO {
    String currency;
   Integer amount;
   Boolean acceptPartial;
   Integer FirstMinPartialAmount;
   Boolean upiLink;
   String description;
   String reference_id;
   //Customer json object
   Integer expireBy;
//Notify array,  notes json object
   String callbackUrl;
   String callbackMethod;
   Boolean reminderEnable;


}