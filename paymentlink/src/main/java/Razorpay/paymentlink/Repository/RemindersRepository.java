package Razorpay.paymentlink.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Razorpay.paymentlink.Entity.Payments.PaymentLink;
import Razorpay.paymentlink.Entity.Payments.Reminders;

public interface RemindersRepository extends JpaRepository<PaymentLink, UUID> {

    Reminders save(Reminders reminders);
    
}
