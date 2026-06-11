package Razorpay.paymentlink.Service;

import Razorpay.paymentlink.DTO.PaymentLinks.Requests.CreateStandardPaymentLinkRequestDTO;
import Razorpay.paymentlink.DTO.PaymentLinks.Response.CreateStandardPaymentLinkResponseDTO;

public interface PaymentLinkService {
    CreateStandardPaymentLinkResponseDTO createPaymentLink(CreateStandardPaymentLinkRequestDTO createStandardPaymentLinkRequestDTO);
    
}
