package org.teca.hotel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teca.hotel.entity.BookingInformation;
import org.teca.hotel.repository.BookingRepository;
@Component
public class BookingDaoImpl implements BookingDao{

	@Autowired
	private BookingRepository repositorybook;
	@Override
	public BookingInformation getBookingInfo(BookingInformation bookingInformation) {
		
		BookingInformation information=repositorybook.save(bookingInformation);
		return information;
	}

}
