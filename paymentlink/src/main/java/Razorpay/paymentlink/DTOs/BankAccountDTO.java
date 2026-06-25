package Razorpay.paymentlink.DTOs;

import lombok.Data;

@Data
public class BankAccountDTO {

    private String accountNumber;
    private String name;
    private String ifsc;

}