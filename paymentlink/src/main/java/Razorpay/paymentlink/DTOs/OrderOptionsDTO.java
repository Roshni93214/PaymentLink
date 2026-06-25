package Razorpay.paymentlink.DTOs;

import lombok.Data;

@Data
public class OrderOptionsDTO {

    private String method;

    private BankAccountDTO bankAccount;

}