package Razorpay.paymentlink.Entity.Payments;

import jakarta.persistence.*;
import java.util.Map;

@Entity
@Table(name = "payment_links")
public class PaymentLinkk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long databaseId; // Internal primary key for MySQL auto-increment

    private String plinkId; // Public Razorpay string ID (e.g., plink_92379640693747)
    private String userId;
    private String orderId;
    private String referenceId;
    private String status;
    private String currency;
    private String description;
    private String shortUrl;
    
    private Long amount;
    private Long amountPaid;
    private boolean acceptPartial;
    private boolean upiLink;
    
    private Long createdAt;
    private Long updatedAt;
    private Long expireBy;
    private Long expiredAt;
    private Long cancelledAt;
    private Long firstMinPartialAmount;
    private boolean reminderEnable;

    // Stores key-value pairs for the notes field dynamically in the DB
    @ElementCollection
    @CollectionTable(name = "payment_link_notes", joinColumns = @JoinColumn(name = "payment_link_id"))
    @MapKeyColumn(name = "note_key")
    @Column(name = "note_value")
    private Map<String, String> notes;

    // --- Constructor ---
    public PaymentLinkk() {}

    // --- Standard Getters and Setters ---
    public Long getDatabaseId() { return databaseId; }
    public void setDatabaseId(Long databaseId) { this.databaseId = databaseId; }

    public String getPlinkId() { return plinkId; }
    public void setPlinkId(String plinkId) { this.plinkId = plinkId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getReferenceId() { return referenceId; }
    public void setReferenceId(String referenceId) { this.referenceId = referenceId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getShortUrl() { return shortUrl; }
    public void setShortUrl(String shortUrl) { this.shortUrl = shortUrl; }

    public Long getAmount() { return amount; }
    public void setAmount(Long amount) { this.amount = amount; }

    public Long getAmountPaid() { return amountPaid; }
    public void setAmountPaid(Long amountPaid) { this.amountPaid = amountPaid; }

    public boolean isAcceptPartial() { return acceptPartial; }
    public void setAcceptPartial(boolean acceptPartial) { this.acceptPartial = acceptPartial; }

    public boolean isUpiLink() { return upiLink; }
    public void setUpiLink(boolean upiLink) { this.upiLink = upiLink; }

    public Long getCreatedAt() { return createdAt; }
    public void setCreatedAt(Long createdAt) { this.createdAt = createdAt; }

    public Long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Long updatedAt) { this.updatedAt = updatedAt; }

    public Long getExpireBy() { return expireBy; }
    public void setExpireBy(Long expireBy) { this.expireBy = expireBy; }

    public Long getExpiredAt() { return expiredAt; }
    public void setExpiredAt(Long expiredAt) { this.expiredAt = expiredAt; }

    public Long getCancelledAt() { return cancelledAt; }
    public void setCancelledAt(Long cancelledAt) { this.cancelledAt = cancelledAt; }

    public Long getFirstMinPartialAmount() { return firstMinPartialAmount; }
    public void setFirstMinPartialAmount(Long firstMinPartialAmount) { this.firstMinPartialAmount = firstMinPartialAmount; }

    public boolean isReminderEnable() { return reminderEnable; }
    public void setReminderEnable(boolean reminderEnable) { this.reminderEnable = reminderEnable; }

    public Map<String, String> getNotes() { return notes; }
    public void setNotes(Map<String, String> notes) { this.notes = notes; }
}