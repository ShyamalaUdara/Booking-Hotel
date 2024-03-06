package org.teca.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teca.hotel.entity.BookingInformation;
import org.teca.hotel.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	

}
