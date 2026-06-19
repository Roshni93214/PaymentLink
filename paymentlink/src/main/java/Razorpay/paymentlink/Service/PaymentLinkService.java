package Razorpay.paymentlink.Service;

import java.util.List;

import Razorpay.paymentlink.DTOs.PaymentLinkFetchItemDto;
import Razorpay.paymentlink.DTOs.PaymentLinkRequest;
import Razorpay.paymentlink.DTOs.PaymentLinkResponse;
import Razorpay.paymentlink.Entity.Payments.PaymentLink;
//import Razorpay.paymentlink.Entity.Payments.PaymentLinkk;

public interface PaymentLinkService {
       PaymentLinkResponse createStandardPaymentLink(PaymentLinkRequest request);

List<PaymentLink> getAllPaymentLinks(String referenceId);
List<PaymentLink> fetchAllPaymentLinks(String referenceId);
      
    //paymentlink
PaymentLink getPaymentLinkById(String plinkId);
}
