package Razorpay.paymentlink.Entity.Payments;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "reminders")
public class Reminders {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID rid;

    @Column(name = "status", length = 20)
    private String status;

    public UUID getRid() {
        return rid;
    }

    public void setRid(UUID rid) {
        this.rid = rid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}