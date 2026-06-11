package Razorpay.paymentlink.Entity.Payments;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID pid;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "created_at")
    private Integer createdAt;

    @Column(name = "updated_at")
    private Integer updatedAt;

    @Column(name = "method", length = 20)
    private String method;

    @Column(name = "payment_id")
    private String paymentId;

    @Column(name = "pstatus", length = 20)
    private String pstatus;

    @Column(name = "plink_id")
    private String plinkId;

    // Getters and Setters

    public UUID getPid() {
        return pid;
    }

    public void setPid(UUID pid) {
        this.pid = pid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPStatus() {
        return pstatus;
    }

    public void setPStatus(String pstatus) {
        this.pstatus = pstatus;
    }

    public String getPlinkId() {
        return plinkId;
    }

    public void setPlinkId(String plinkId) {
        this.plinkId = plinkId;
    }

    public Payment save(Payment payment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    public String getStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStatus'");
    }
}