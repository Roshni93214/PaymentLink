package Razorpay.paymentlink.Entity.Payments;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transfer {

    @Id
    private String transferId;

    // Payment Link se manually link karne ke liye
    private String paymentLinkId;

    // Transfer Details
    private String account;
    private Integer amount;
    private String currency;
}