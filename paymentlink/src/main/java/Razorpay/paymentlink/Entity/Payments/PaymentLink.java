package Razorpay.paymentlink.Entity.Payments;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
@Table(name = "payment_links")
@Access(AccessType.FIELD) // <-- FORCE HIBERNATE TO ONLY SCAN FIELDS, IGNORING CUSTOM GETTERS
public class PaymentLink {

    @Id
    @Column(name = "plink_id", nullable = false, length = 50) 
    private String plinkId; 

    @Column(name = "id_pk", insertable = false, updatable = false)
    private Long databaseId; 

    @Column
    private Boolean acceptPartial;

    @Column
    private Integer amount;

    @Column
    private Integer amountPaid;

    @Column
    private String callbackMethod;

    @Column(length = 500)
    private String callbackUrl;

    @Column
    private Long cancelledAt;

    @Column
    private Long createdAt;

    @Column(length = 10)
    private String currency;

    @Column(length = 500)
    private String description;

    @Column
    private Long expireBy;

    @Column
    private Long expiredAt;

    @Column
    private Integer firstMinPartialAmount;

    @Column
    private String referenceId;

    @Column
    private Boolean reminderEnable;

    @Column
    private String shortUrl;

    @Column(length = 30)
    private String status;

    @Column
    private Long updatedAt;

    @Column
    private String userId;

    @Column
    private String orderId;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "payment_link_notes", joinColumns = @JoinColumn(name = "payment_link_id"))
    @MapKeyColumn(name = "note_key")
    @Column(name = "note_value", length = 256)
    private Map<String, String> notes = new HashMap<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "payment_link_payments", joinColumns = @JoinColumn(name = "payment_link_id"))
    @Column(name = "payment_id")
    private List<String> payments = new ArrayList<>();

    @Column
    private boolean upiLink;

    // -----------------------------------------------------------------
    // Existing Custom Methods (Safe from Hibernate processing now)
    // -----------------------------------------------------------------
    public String getPlinkId() { return this.plinkId; }
    public void setPlinkId(String plinkId) { this.plinkId = plinkId; }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public Boolean isAcceptPartial() { return acceptPartial != null ? acceptPartial : false; }
    public void setAcceptPartial(Boolean acceptPartial) { this.acceptPartial = acceptPartial; }

    public boolean isUpiLink() { return upiLink; }
    public void setUpiLink(boolean upiLink) { this.upiLink = upiLink; }

    public Boolean isReminderEnable() { return reminderEnable != null ? reminderEnable : false; }
    public void setReminderEnable(Boolean reminderEnable) { this.reminderEnable = reminderEnable; }
}