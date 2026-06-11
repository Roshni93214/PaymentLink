package Razorpay.paymentlink.DTO.PaymentLinks.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManageRemiderRequestDTO{
    
Boolean acceptPartial;
   Integer amount;
Integer firstMinPartialAmount;
String currency;
//Customer 
   String description;
Boolean reminderEnable;
//Notify
}
