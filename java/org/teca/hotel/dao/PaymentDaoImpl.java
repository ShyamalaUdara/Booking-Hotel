package org.teca.hotel.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teca.hotel.entity.BookingInformation;
import org.teca.hotel.entity.Payment;
import org.teca.hotel.repository.PaymentRepository;

@Component
public class PaymentDaoImpl implements PaymentDao{

	@Autowired
	private PaymentRepository payrep;
	@Override
	public Payment getPayment(Payment payment) {
		Payment paymentdetails=payrep.save(payment);
		return paymentdetails;
	}
	

}
