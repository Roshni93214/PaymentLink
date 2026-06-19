package Razorpay.paymentlink.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Razorpay.paymentlink.Entity.Payments.Customer;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    // Crucial for manual lookup since we aren't using traditional Hibernate mapping
   Optional<Customer> findByPaymentLinkId(String paymentLinkId);
}