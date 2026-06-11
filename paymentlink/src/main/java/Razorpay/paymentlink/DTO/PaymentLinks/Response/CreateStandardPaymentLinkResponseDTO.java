package Razorpay.paymentlink.DTO.PaymentLinks.Response;

import java.util.UUID;

import Razorpay.paymentlink.Entity.Payments.Notes;
import Razorpay.paymentlink.Entity.Payments.Notify;
import Razorpay.paymentlink.Entity.Payments.Reminders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class  CreateStandardPaymentLinkResponseDTO {
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
   //Payments
   String referenceId;
   String shorturl;
   String status;
   Integer updatedAt;
   Boolean reminderEnable;
  String userID;
  //reminders object
  String options;
  public void setName(Object name) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setName'");
  }
  public void setEmail(Object email) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setEmail'");
  }
  public void setContact(Object contact) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setContact'");
  }
  public void setNotes(Notes savedNotes) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setNotes'");
  }
  public void setReminders(Reminders savedReminders) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setReminders'");
  }
  public void setNotify(Notify savedNotify) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setNotify'");
  }
  public void setPlinkId(Object plinkId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setPlinkId'");
  }
  public void setMethod(Object method) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setMethod'");
  }
  public void setPaymentId(Object paymentId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setPaymentId'");
  }
}