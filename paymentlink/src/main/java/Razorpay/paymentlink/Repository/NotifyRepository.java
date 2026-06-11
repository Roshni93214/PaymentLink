package Razorpay.paymentlink.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Razorpay.paymentlink.Entity.Payments.Notify;
import Razorpay.paymentlink.Entity.Payments.PaymentLink;

public interface NotifyRepository  extends JpaRepository<PaymentLink,UUID>{

    Notify save(Notify notify);
    
}
