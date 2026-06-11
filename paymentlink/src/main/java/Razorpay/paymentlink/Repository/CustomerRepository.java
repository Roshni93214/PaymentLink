package Razorpay.paymentlink.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Razorpay.paymentlink.Entity.Payments.Customer;
import Razorpay.paymentlink.Entity.Payments.PaymentLink;

public interface CustomerRepository extends JpaRepository<PaymentLink, UUID> {

    Customer save(Customer customer);
    
}
