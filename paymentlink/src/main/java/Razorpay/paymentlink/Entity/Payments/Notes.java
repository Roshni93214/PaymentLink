package Razorpay.paymentlink.Entity.Payments;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "notes")
public class Notes {

    @Id
    @Column(name = "note_id")
    private String noteId;

    @Column(name = "payment_link_id")
    private String paymentLinkId;

    @Column(name = "note_key")
    private String noteKey;

    @Column(name = "note_value")
    private String noteValue;
}