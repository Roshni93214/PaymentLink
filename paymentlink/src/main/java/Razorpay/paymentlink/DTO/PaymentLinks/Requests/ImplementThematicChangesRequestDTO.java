package Razorpay.paymentlink.DTO.PaymentLinks.Requests;

//import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;








@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImplementThematicChangesRequestDTO{
Integer amount;
String currency;
Boolean acceptPartial;
Integer firstMinPartialAmount;
String description;
Boolean upiLink;
String referenceId;
//Customer 
Integer expireBy;
//Notify notes
String callbackUrl;
   String callbackMethod;
Boolean reminderEnable;
String options;
}

