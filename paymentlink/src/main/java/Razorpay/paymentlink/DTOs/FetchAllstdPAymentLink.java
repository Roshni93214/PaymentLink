package Razorpay.paymentlink.DTOs;



import java.util.ArrayList;

import java.util.List;

//import Razorpay.paymentlink.Entity.Payments.PaymentLink;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FetchAllstdPAymentLink {
    private Boolean acceptPartial;
    private Integer amount;
    private Integer amountPaid;
    private String callbackUrl;
    private String callbackMethod;
    private Long createdAt;      // Changed to Long to safely capture Unix timestamps
    private Long cancelledAt;    // Changed to Long to safely capture Unix timestamps
    private String currency;
    private Object customer;     // Using Object allows returning a clean array [] if empty
    private String description;
    private Long expireBy;       // Changed to Long to safely capture Unix timestamps
    private Long expiredAt;      // Changed to Long to safely capture Unix timestamps
    private Integer firstMinPartialAmount;
    private String id;
    private Boolean upiLink;
    private NotifyDTO notify;
    private Object notes;        // Using Object allows returning a clean array [] if empty
    private List<Object> payments = new ArrayList<>(); // Always defaults to empty array []
    private List<Object> reminders = new ArrayList<>(); // Always defaults to empty array []
    private String referenceId;
    private String shortUrl;     // Fixed: Changed from shorturl to camelCase shortUrl
    private String status;
    private Long updatedAt;      // Changed to Long to safely capture Unix timestamps
    private Boolean reminderEnable;
    private String userId;  
     }     // Fixed: Changed from userID to camelCase userId
/* 
    // Constructor to cleanly map from the Entity to this camelCase DTO
    public FetchAllstdPAymentLink(PaymentLink entity) {
        this.id = entity.getId(); 
        this.userId = entity.getUserId();
        this.referenceId = entity.getReferenceId();
        this.status = entity.getStatus();
        this.currency = entity.getCurrency() != null ? entity.getCurrency() : "INR";
        this.description = entity.getDescription();
        this.shortUrl = entity.getShortUrl();
        this.callbackUrl = entity.getCallbackUrl();
        this.callbackMethod = entity.getCallbackMethod();
        
        // Map numbers safely, fallback to 0 instead of null
        this.amount = entity.getAmount() != null ? entity.getAmount() : 0;
        this.amountPaid = entity.getAmountPaid() != null ? entity.getAmountPaid() : 0;
        this.firstMinPartialAmount = entity.getFirstMinPartialAmount() != null ? entity.getFirstMinPartialAmount() : 0;
        
        // Map timestamps safely
        this.createdAt = entity.getCreatedAt() != null ? entity.getCreatedAt() : 0L;
        this.updatedAt = entity.getUpdatedAt() != null ? entity.getUpdatedAt() : 0L;
        this.expireBy = entity.getExpireBy() != null ? entity.getExpireBy() : 0L;
        this.expiredAt = entity.getExpiredAt() != null ? entity.getExpiredAt() : 0L;
        this.cancelledAt = entity.getCancelledAt() != null ? entity.getCancelledAt() : 0L;

        // Map primitive booleans safely
        this.acceptPartial = entity.getAcceptPartial() != null ? entity.getAcceptPartial() : false;
        this.reminderEnable = entity.getReminderEnable() != null ? entity.getReminderEnable() : false;
        this.upiLink = false; // Default tracking flag

        // Handle Customer wrapper safely
        this.customer = new ArrayList<>(); // Defaults to empty array [] as per Razorpay spec if empty

        // Handle Notify configuration safely
        this.notify = new NotifyDTO(); // Default standard notification setup

        // Handle Notes map mapping fallback rules safely
        if (entity.getNotes() != null && !entity.getNotes().isEmpty()) {
            this.notes = entity.getNotes();
        } else {
            this.notes = new ArrayList<>(); // Return empty array [] if there are no notes
        }
    }
}*/