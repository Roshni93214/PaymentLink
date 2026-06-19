package Razorpay.paymentlink.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Razorpay.paymentlink.Entity.Payments.Notify;
import java.util.Optional;

@Repository
public interface NotifyRepository extends JpaRepository<Notify, String> {
   Optional<Notify> findByPaymentLinkId(String paymentLinkId);
}