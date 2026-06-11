package Razorpay.paymentlink.DTO.PaymentLinks.Requests;

import Razorpay.paymentlink.DTO.PaymentLinks.Response.CreateStandardPaymentLinkResponseDTO;
import Razorpay.paymentlink.Entity.Payments.Customer;
import Razorpay.paymentlink.Entity.Payments.Notes;
import Razorpay.paymentlink.Entity.Payments.Notify;
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
   Customer customer;
//Notify array,  notes json object
  Notify notify;
Notes notes;
   String callbackUrl;
   String callbackMethod;
   Boolean reminderEnable;
   public String getName() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getName'");
   }
   public String getEmail() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
   }
   public String getContact() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getContact'");
   }
   public Integer getCreatedAt() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCreatedAt'");
   }
   public Integer getUpdateAt() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getUpdateAt'");
   }
   public String getMethod() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getMethod'");
   }
   public String getPaymentId() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getPaymentId'");
   }
   public String getPStatus() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getPStatus'");
   }
   public String getPlinkId() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getPlinkId'");
   }
   public CreateStandardPaymentLinkResponseDTO getReminders() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getReminders'");
   }


}
