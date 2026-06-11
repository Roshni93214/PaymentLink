package Razorpay.paymentlink.Entity.Payments;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
@Table(name = "notes")
public class Notes {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noteId;


    

    @Column(name = "note_key", nullable = false, length = 100)
    private String noteKey;

    @Size(max = 256, message = "Note value must not exceed 256 characters")
    @Column(name = "note_value", length = 256)
    private String noteValue;
}
