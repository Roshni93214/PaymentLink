package Razorpay.paymentlink.DTOs;


import Razorpay.paymentlink.Entity.Payments.*;

import java.util.ArrayList;
import java.util.List;

public class PaymentLinkFetchItemDto {

    // Variables strictly following camelCase conventions
    private String id;
    private String userId;
    private String orderId;
    private String referenceId;
    private String status;
    private String currency;
    private String description;
    private String shortUrl;
    private long amount;
    private long amountPaid;
    private boolean acceptPartial;
    private boolean upiLink;
    private long createdAt;
    private long updatedAt;
    private long expireBy;
    private long expiredAt;
    private long cancelledAt;
    private long firstMinPartialAmount;
    private boolean reminderEnable;

    // Default structural collections to prevent null properties in Postman
    private List<Object> customer = new ArrayList<>();
    private Object notes; 
    private List<Object> reminders = new ArrayList<>();
    private List<Object> payments = new ArrayList<>();

    // Simple entity-mapping constructor mapping fields cleanly
    public PaymentLinkFetchItemDto(PaymentLink entity){
       
        this.id = entity.getPlinkId(); // Converts database 'plinkId' column value to public 'id'
        this.userId = entity.getUserId();
        this.orderId = entity.getOrderId();
        
        this.referenceId = entity.getReferenceId();
        this.status = entity.getStatus();
        this.currency = entity.getCurrency() != null ? entity.getCurrency() : "INR";
        this.description = entity.getDescription();
        this.shortUrl = entity.getShortUrl();
        
        // Handles fallback values cleanly for long types
        this.amount = entity.getAmount() != null ? entity.getAmount() : 0L;
        this.amountPaid = entity.getAmountPaid() != null ? entity.getAmountPaid() : 0L;
        this.acceptPartial = entity.isAcceptPartial();
        this.upiLink = entity.isUpiLink();
        this.createdAt = entity.getCreatedAt() != null ? entity.getCreatedAt() : 0L;
        this.updatedAt = entity.getUpdatedAt() != null ? entity.getUpdatedAt() : 0L;
        this.expireBy = entity.getExpireBy() != null ? entity.getExpireBy() : 0L;
        this.expiredAt = entity.getExpiredAt() != null ? entity.getExpiredAt() : 0L;
        this.cancelledAt = entity.getCancelledAt() != null ? entity.getCancelledAt() : 0L;
        this.firstMinPartialAmount = entity.getFirstMinPartialAmount() != null ? entity.getFirstMinPartialAmount() : 0L;
        this.reminderEnable = entity.isReminderEnable();

        // Safely map notes layout structure or render [] empty brackets if blank
        if (entity.getNotes() != null && !entity.getNotes().isEmpty()) {
            this.notes = entity.getNotes();
        } else {
            this.notes = null; // Changes map property fallback output rule configuration
        }
    }

    // --- Clean Standard Getters for Automatic camelCase Conversion ---
    public String getId() { return id; }
    public String getUserId() { return userId; }
    public String getOrderId() { return orderId; }
    public String getReferenceId() { return referenceId; }
    public String getStatus() { return status; }
    public String getCurrency() { return currency; }
    public String getDescription() { return description; }
    public String getShortUrl() { return shortUrl; }
    public long getAmount() { return amount; }
    public long getAmountPaid() { return amountPaid; }
    public boolean isAcceptPartial() { return acceptPartial; }
    public boolean isUpiLink() { return upiLink; }
    public long getCreatedAt() { return createdAt; }
    public long getUpdatedAt() { return updatedAt; }
    public long getExpireBy() { return expireBy; }
    public long getExpiredAt() { return expiredAt; }
    public long getCancelledAt() { return cancelledAt; }
    public long getFirstMinPartialAmount() { return firstMinPartialAmount; }
    public boolean isReminderEnable() { return reminderEnable; }
    public List<Object> getCustomer() { return customer; }
    public Object getNotes() { return notes; }
    public List<Object> getReminders() { return reminders; }
    public List<Object> getPayments() { return payments; }
}