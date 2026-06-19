package Razorpay.paymentlink.DTOs;

import lombok.Data;

@Data
public class PaymentAttemptDTO {
      private String paymentId; // Unique transaction identifier
    private String plinkId; // Backlink identifier
    private Integer amount;
    private String status; // e.g., "captured"
    private String method; // "netbanking", "card", "wallet", "upi", "emi", "bank_transfer"
    private Long createdAt; // UNIX timestamp
    private Long updatedAt; // UNIX timestamp
}
