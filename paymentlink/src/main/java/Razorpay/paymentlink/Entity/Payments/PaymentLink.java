package Razorpay.paymentlink.Entity.Payments;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Getter
@Setter
@Table(name = "payment_links")
public class PaymentLink {

    @Id
    @Column(name = "plink_id", nullable = false, length = 50) 
    private String id; // Matches "plink_ExjpAUN3gVHrPJ"

    @Column(name = "id_pk", insertable = false, updatable = false)
    private Long databaseId; 

    @Column(name = "accept_partial", nullable = false)
    private boolean acceptPartial = false;

    @Column(name = "amount")
    private Integer amount;
 
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

    @Column(name = "currency", length = 10)
    private String currency;

    @Column(name = "description", length = 500)
    private String description;
 
    @Column(name = "expire_by")
    private Long expireBy;

    @Column(name = "expired_at")
    private Long expiredAt;

    @Column(name = "first_min_partial_amount")
    private Integer firstMinPartialAmount;

   // @Column(name = "reference_id")
    //private String referenceId;

    // Inside your PaymentLinkRequest class

@JsonProperty("reference_id") // Tells Jackson to catch the snake_case payload input
private String referenceId;

// Ensure your getter/setter matches it perfectly:
public String getReferenceId() { return referenceId; }
public void setReferenceId(String referenceId) { this.referenceId = referenceId; }

    @Column(name = "reminder_enable", nullable = false)
    private boolean reminderEnable = false;

    @Column(name = "short_url")
    private String shortUrl;

    @Column(name = "status", length = 30)
    private String status;
 
    @Column(name = "updated_at")
    private Long updatedAt;

    @Column(name = "user_id")
    private String userId;
    @Column(name = "business_name")
    private String businessName;
    @Column(name = "theme_color")
    private String themeColor;
    @Column(name = "enable_netbanking")
    private Boolean enableNetbanking = true;

    @Column(name = "enable_card")
    private Boolean enableCard = true;

    @Column(name = "enable_upi")
    private Boolean enableUpi = true;

    @Column(name = "enable_wallet")
    private Boolean enableWallet = true;
    @Column(name = "checkout_config", columnDefinition = "TEXT")
    private String checkoutConfig;
    @Column(name = "order_method")
    private String orderMethod;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Column(name = "bank_account_name")
    private String bankAccountName;

    @Column(name = "bank_account_ifsc")
    private String bankAccountIfsc;
    @Column(name = "min_amount_label")
    private String minAmountLabel;

    @Column(name = "partial_amount_label")
    private String partialAmountLabel;

    @Column(name = "partial_amount_description", columnDefinition = "TEXT")
    private String partialAmountDescription;

    @Column(name = "full_amount_label")
    private String fullAmountLabel;
    @Column(name = "receipt_label")
    private String receiptLabel;

    @Column(name = "description_label")
    private String descriptionLabel;

    @Column(name = "amount_payable_label")
    private String amountPayableLabel;

    @Column(name = "amount_paid_label")
    private String amountPaidLabel;

    @Column(name = "partial_amount_due_label")
    private String partialAmountDueLabel;

    @Column(name = "partial_amount_paid_label")
    private String partialAmountPaidLabel;

    @Column(name = "expire_by_label")
    private String expireByLabel;

    @Column(name = "expired_on_label", columnDefinition = "TEXT")
    private String expiredOnLabel;

    @Column(name = "amount_due_label")
    private String amountDueLabel;

    @Column(name = "show_issued_to")
    private Boolean showIssuedTo = true;
    @Column(name = "offer_id")
    private String offerId;

    @Column(name = "offer_apply")
    private Boolean offerApply = false;


// Add this field inside your existing PaymentLink model class implrment
@Column(name = "hide_topbar")
private boolean hideTopbar = false;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "payment_link_notes", joinColumns = @JoinColumn(name = "payment_link_id"))
    @MapKeyColumn(name = "note_key")
    @Column(name = "note_value", length = 256)
    private Map<String, String> notes = new HashMap<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "payment_link_payments", joinColumns = @JoinColumn(name = "payment_link_id"))
    @Column(name = "payment_id")
    private List<String> payments = new ArrayList<>();

    @Column(name = "upiLink", nullable = false) // Match the camelCase column name exactly
private boolean upiLink = false;
  // -----------------------------------------------------------------
    // CUSTOM ALIAS METHODS
    // -----------------------------------------------------------------
    public String getPlinkId() { 
        return this.id; 
    }

    public void setPlinkId(String plinkId) { 
        return; // Fixed structural tracking override
    }
    
    public void updatePlinkIdDirectly(String plinkId) {
        this.id = plinkId;
    }
    public String getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }
    public String getCheckoutConfig() {
        return checkoutConfig;
    }

    public void setCheckoutConfig(String checkoutConfig) {
        this.checkoutConfig = checkoutConfig;
    }
    public String getMinAmountLabel() {
        return minAmountLabel;
    }

    public void setMinAmountLabel(String minAmountLabel) {
        this.minAmountLabel = minAmountLabel;
    }

    public String getPartialAmountLabel() {
        return partialAmountLabel;
    }

    public void setPartialAmountLabel(String partialAmountLabel) {
        this.partialAmountLabel = partialAmountLabel;
    }

    public String getPartialAmountDescription() {
        return partialAmountDescription;
    }

    public void setPartialAmountDescription(String partialAmountDescription) {
        this.partialAmountDescription = partialAmountDescription;
    }

    public String getFullAmountLabel() {
        return fullAmountLabel;
    }

    public void setFullAmountLabel(String fullAmountLabel) {
        this.fullAmountLabel = fullAmountLabel;
    }
    public String getReceiptLabel() {
        return receiptLabel;
    }

    public void setReceiptLabel(String receiptLabel) {
        this.receiptLabel = receiptLabel;
    }

    public String getDescriptionLabel() {
        return descriptionLabel;
    }

    public void setDescriptionLabel(String descriptionLabel) {
        this.descriptionLabel = descriptionLabel;
    }

    public String getAmountPayableLabel() {
        return amountPayableLabel;
    }

    public void setAmountPayableLabel(String amountPayableLabel) {
        this.amountPayableLabel = amountPayableLabel;
    }

    public String getAmountPaidLabel() {
        return amountPaidLabel;
    }

    public void setAmountPaidLabel(String amountPaidLabel) {
        this.amountPaidLabel = amountPaidLabel;
    }

    public String getPartialAmountDueLabel() {
        return partialAmountDueLabel;
    }

    public void setPartialAmountDueLabel(String partialAmountDueLabel) {
        this.partialAmountDueLabel = partialAmountDueLabel;
    }

    public String getPartialAmountPaidLabel() {
        return partialAmountPaidLabel;
    }

    public void setPartialAmountPaidLabel(String partialAmountPaidLabel) {
        this.partialAmountPaidLabel = partialAmountPaidLabel;
    }

    public String getExpireByLabel() {
        return expireByLabel;
    }

    public void setExpireByLabel(String expireByLabel) {
        this.expireByLabel = expireByLabel;
    }

    public String getExpiredOnLabel() {
        return expiredOnLabel;
    }

    public void setExpiredOnLabel(String expiredOnLabel) {
        this.expiredOnLabel = expiredOnLabel;
    }

    public String getAmountDueLabel() {
        return amountDueLabel;
    }

    public void setAmountDueLabel(String amountDueLabel) {
        this.amountDueLabel = amountDueLabel;
    }

    public Boolean getShowIssuedTo() {
        return showIssuedTo;
    }

    public void setShowIssuedTo(Boolean showIssuedTo) {
        this.showIssuedTo = showIssuedTo;
    }
    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public Boolean getOfferApply() {
        return offerApply;
    }

    public void setOfferApply(Boolean offerApply) {
        this.offerApply = offerApply;
    }
    
}   