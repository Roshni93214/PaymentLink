package Razorpay.paymentlink.Repository;

import Razorpay.paymentlink.Entity.Payments.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, String> {
}