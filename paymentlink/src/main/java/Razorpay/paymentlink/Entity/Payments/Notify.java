package Razorpay.paymentlink.Entity.Payments;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "notify")
public class Notify {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID nfid;

    @Column(name = "sms")
    private Boolean sms;

    @Column(name = "email")
    private Boolean email;

    public UUID getNfid() {
        return nfid;
    }

    public void setNfid(UUID nfid) {
        this.nfid = nfid;
    }

    public Boolean getSms() {
        return sms;
    }

    public void setSms(Boolean sms) {
        this.sms = sms;
    }

    public Boolean getEmail() {
        return email;
    }

    public void setEmail(Boolean email) {
        this.email = email;
    }
}