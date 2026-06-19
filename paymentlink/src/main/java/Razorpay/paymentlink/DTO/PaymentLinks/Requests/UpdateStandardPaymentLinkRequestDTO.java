package Razorpay.paymentlink.DTO.PaymentLinks.Requests;

import java.util.HashMap;
import java.util.Map;

//import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class  UpdateStandardPaymentLinkRequestDTO {
   Boolean acceptPartial;
   String referenceId;
   Integer expireBy;
   //Notes object
    Map<String,String> notes= new HashMap<>();
}