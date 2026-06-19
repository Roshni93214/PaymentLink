package Razorpay.paymentlink.DTO.PaymentLinks.Requests;

import lombok.Data;

@Data
public class NotifyDTO {
    Boolean sms;
    Boolean email;
}
