package Razorpay.paymentlink.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Razorpay.paymentlink.Entity.Payments.Reminders;
import java.util.Optional;

@Repository
public interface RemindersRepository extends JpaRepository<Reminders, String> {
    Optional<Reminders> findByPaymentLinkId(String paymentLinkId);
}