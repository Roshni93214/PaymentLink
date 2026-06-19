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
public class PaymentLinkkk

   @Id
   @Column(name = "plink_id", nullable = false, length = 50) 
   private String id;// Matches "plink_ExjpAUN3gVHrPJ"

   @Column(name = "id_pk", insertable = false, updatable = false)
   private Long databaseId; // Named databaseId to avoid clashing with your String id

  //@Column(name = "accept_partial")
    private Boolean acceptPartial;

    @Column(name = "amount")
    private Integer amount;
/* 
    @Column(name = "amount_paid")
    private Integer amountPaid;

    @Column(name = "callback_method")
    private String callbackMethod;

    @Column(name = "callback_url", length = 500)
    private String callbackUrl;

    @Column(name = "cancelled_at")
    private Long cancelledAt;

    @Column(name = "created_at")
    private Long createdAt;
*/
    @Column(name = "currency", length = 10)
    private String currency;

    @Column(name = "description", length = 500)
    private String description;
/* 
    @Column(name = "expire_by")
    private Long expireBy;

    @Column(name = "expired_at")
    private Long expiredAt;

    @Column(name = "first_min_partial_amount")
    private Integer firstMinPartialAmount;

    @Column(name = "reference_id")
    private String referenceId;

    @Column(name = "reminder_enable")
    private Boolean reminderEnable;

    @Column(name = "short_url")
    private String shortUrl;
*/
    @Column(name = "status", length = 30)
    private String status;
/* 
    @Column(name = "updated_at")
    private Long updatedAt;

    @Column(name = "user_id")
    private String userId;
*/
      

/// 1. Comment out or remove the explicit naming parameters from these 3 fields:
    
private String orderId;
    // @Column(name = "amount_paid")
    @Column
    private Integer amountPaid;

    // @Column(name = "callback_method")
    @Column
    private String callbackMethod;

    // @Column(name = "callback_url", length = 500)
    @Column(length = 500)
    private String callbackUrl;

    // @Column(name = "cancelled_at")
    @Column
    private Long cancelledAt;

    // @Column(name = "created_at")
    @Column
    private Long createdAt;

    // @Column(name = "expire_by")
    @Column
    private Long expireBy;

    // @Column(name = "expired_at")
    @Column
    private Long expiredAt;

    // @Column(name = "first_min_partial_amount")
    @Column
    private Integer firstMinPartialAmount;

    // @Column(name = "reference_id")
    @Column
    private String referenceId;

    // @Column(name = "reminder_enable")
    @Column
    private Boolean reminderEnable;

    // @Column(name = "short_url")
    @Column
    private String shortUrl;

    // @Column(name = "updated_at")
    @Column
    private Long updatedAt;

    // @Column(name = "user_id")
    @Column
    private String userId;
    // -----------------------------------------------------------------
    // NOTES: Handled via ElementCollection map (No separate entity relationship)
    // -----------------------------------------------------------------
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "payment_link_notes", joinColumns = @JoinColumn(name = "payment_link_id"))
    @MapKeyColumn(name = "note_key")
    @Column(name = "note_value", length = 256)
    private Map<String, String> notes = new HashMap<>();

    // -----------------------------------------------------------------
    // PAYMENTS: Raw array of transaction tracking IDs from Razorpay
    // -----------------------------------------------------------------
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "payment_link_payments", joinColumns = @JoinColumn(name = "payment_link_id"))
    @Column(name = "payment_id")
    private List<String> payments = new ArrayList<>();

    private boolean upiLink;

    // Remove any conflicting manual getters/setters and replace with these:
/* 
public String getPlinkId() { 
    return this.id; 
}

public void setPlinkId(String plinkId) { 
    this.id = plinkId; 
}

// Changed return types to Boolean to prevent NullPointerExceptions on uninitialized rows
public Boolean isAcceptPartial() { 
    return acceptPartial != null ? acceptPartial : false; 
}

public void setAcceptPartial(Boolean acceptPartial) { 
    this.acceptPartial = acceptPartial; 
}

public Boolean isReminderEnable() { 
    return reminderEnable != null ? reminderEnable : false; 
}

public void setReminderEnable(Boolean reminderEnable) { 
    this.reminderEnable = reminderEnable; 
}

public boolean isUpiLink() { 
    return upiLink; 
}

public void setUpiLink(boolean upiLink) { 
    this.upiLink = upiLink; 
}*/


// -----------------------------------------------------------------
    // Clean, standard manual getters that won't conflict with Hibernate
    // -----------------------------------------------------------------
    

    public String getOrderId() { 
        return orderId; 
    }
    
    public void setOrderId(String orderId) { 
        this.orderId = orderId; 
    }

    public Boolean isAcceptPartial() { 
        return acceptPartial != null ? acceptPartial : false; 
    }

    public void setAcceptPartial(Boolean acceptPartial) { 
        this.acceptPartial = acceptPartial; 
    }

    public boolean isUpiLink() { 
        return upiLink; 
    }

    public void setUpiLink(boolean upiLink) { 
        this.upiLink = upiLink; 
    }

    public Boolean isReminderEnable() { 
        return reminderEnable != null ? reminderEnable : false; 
    }

    public void setReminderEnable(Boolean reminderEnable) { 
        this.reminderEnable = reminderEnable; 
    }
}

