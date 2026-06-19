package Razorpay.paymentlink.Entity.Payments;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "payment_attempts")
public class PaymentAttempt {

    @Id
    @Column(name = "attempt_id")
    private String attemptId; // Internal record identifier or Razorpay transaction string

    @Column(name = "payment_link_id")
    private String paymentLinkId; // Manual string key tracing back to the PaymentLink ID

    @Column(name = "razorpay_payment_id")
    private String razorpayPaymentId; // Captures individual Razorpay payment ID (e.g., pay_xxxxx)

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "status")
    private String status; // Tracks transaction states like "captured", "failed"
}