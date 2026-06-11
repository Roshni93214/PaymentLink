package Razorpay.paymentlink.DTO.PaymentLinks.Requests;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class  UpdateUpiPaymentLinkRequestDTO {
   Boolean acceptPartial;
   String referenceId;
   Integer expireBy;
   //Notes object
}