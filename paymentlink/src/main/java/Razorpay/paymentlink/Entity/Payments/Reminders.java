package Razorpay.paymentlink.Entity.Payments;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "reminders")
public class Reminders {

    @Id
    @Column(name = "reminder_id")
    private String reminderId;

    @Column(name = "payment_link_id")
    private String paymentLinkId; // Manual string link back to PaymentLink

    @Column(name = "status")
    private String status; // This catches "failed", "pending", etc.
}