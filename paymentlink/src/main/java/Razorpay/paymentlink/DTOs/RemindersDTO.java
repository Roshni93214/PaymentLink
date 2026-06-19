package Razorpay.paymentlink.DTOs;

import lombok.Data;

@Data

public class RemindersDTO {
    private String status; // "pending", "in_progress", "failed"
}
