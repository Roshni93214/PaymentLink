package Razorpay.paymentlink.Entity.Payments;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "payment_links")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentLink {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "plink_id", nullable = false)
    private String plinkId;

    @Column(name = "accept_partial")
    private Boolean acceptPartial;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "amount_paid")
    private Integer amountPaid;

    @Column(name = "callback_url")
    private String callbackUrl;

    @Column(name = "callback_method")
    private String callbackMethod;

    @Column(name = "cancelled_at")
    private Integer cancelledAt;

    @Column(name = "created_at")
    private Integer createdAt;

    @Column(name = "updated_at")
    private Integer updatedAt;

    @Column(name = "currency", length = 10)
    private String currency;

    @Column(name = "description")
    private String description;

    @Column(name = "expire_by")
    private Integer expireBy;

    @Column(name = "expired_at")
    private Integer expiredAt;

    @Column(name = "first_min_partial_amount")
    private Integer firstMinPartialAmount;

    @Column(name = "upi_link")
    private Boolean upiLink;

    @Column(name = "reference_id", length = 40)
    private String referenceId;

    @Column(name = "short_url")
    private String shortUrl;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "reminder_enable")
    private Boolean reminderEnable;

    @Column(name = "user_id")
    private String userId;
}