package Razorpay.paymentlink.Controller;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Razorpay.paymentlink.DTO.PaymentLinks.Requests.CreateStandardPaymentLinkRequestDTO;
import Razorpay.paymentlink.DTO.PaymentLinks.Response.CreateStandardPaymentLinkResponseDTO;
import Razorpay.paymentlink.Entity.Payments.PaymentLink;
import Razorpay.paymentlink.Service.PaymentLinkService;

@RestController

@RequestMapping("/v1/PaymentLink")

public class PaymentController {
    private PaymentLinkService paymentLinkService;

    @Autowired
    public PaymentController(PaymentLinkService paymentLinkService){
        this.paymentLinkService=paymentLinkService;

    }

   @PostMapping("/createPaymentLink")
public ResponseEntity<CreateStandardPaymentLinkResponseDTO> createPaymentLink(
        @RequestBody CreateStandardPaymentLinkRequestDTO createStandardPaymentLinkRequestDTO) {

    return new ResponseEntity<>(
            paymentLinkService.createPaymentLink(createStandardPaymentLinkRequestDTO),
            HttpStatus.CREATED);
}
}
