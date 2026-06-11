package Razorpay.paymentlink.DTO.PaymentLinks.Response;

import java.beans.Customizer;
import java.util.UUID;

import Razorpay.paymentlink.Entity.Payments.Customer;
import Razorpay.paymentlink.Entity.Payments.Notes;
import Razorpay.paymentlink.Entity.Payments.Notify;
import Razorpay.paymentlink.Entity.Payments.Payment;
import Razorpay.paymentlink.Entity.Payments.Reminders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class  CancelStandardPaymentLinkResponseDTO {
    Boolean acceptPartial;
   Integer amount;
   Integer amountPaid;
   String callbackUrl;
   String callbackMethod;
   Integer createdAt;
   Integer cancelledAt;
   String currency;
//Customer 
Customer customer;
   String description;
   Integer expireBy;
   Integer expiredAt;
   Integer firstMinPartialAmount;
   String id;
   Boolean upiLink;
//Notes notify
   //Payments
   Notify notify;
   Notes notes;
   Payment payment;
   String referenceId;
   String shorturl;
   String status;
   Integer updatedAt;
   Boolean reminderEnable;
  String userID;
//Reminders object
Reminders reminders;


}
