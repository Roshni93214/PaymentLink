package Razorpay.paymentlink.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Razorpay.paymentlink.Entity.Payments.PaymentLink;

public interface PaymentRepository extends JpaRepository<PaymentLink,UUID> {
    
}
