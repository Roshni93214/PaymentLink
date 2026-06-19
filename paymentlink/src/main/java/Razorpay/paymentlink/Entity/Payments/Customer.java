package Razorpay.paymentlink.Entity.Payments;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "customer_id")
    private String customerId; // Your application's internal generator or manual ID

    @Column(name = "payment_link_id")
    private String paymentLinkId; // Manual string link back to PaymentLink

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "contact", length = 20)
    private String contact;
}