package Razorpay.paymentlink.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Razorpay.paymentlink.Entity.Payments.Notes;
import Razorpay.paymentlink.Entity.Payments.PaymentLink;

public interface NotesRepository extends JpaRepository<PaymentLink, UUID> {

    Notes save(Notes notes);
    
}
