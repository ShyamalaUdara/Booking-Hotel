package org.teca.hotel.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teca.hotel.entity.HotelInformation;
import org.teca.hotel.repository.HotelRepository;

@Component
public class HotelDaoImp implements HotelDao{

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public HotelInformation hotelRegistration(HotelInformation hotelInformation) {
		HotelInformation informationh=hotelRepository.save(hotelInformation);
		return informationh;
	}

	@Override
	public List<HotelInformation> getAllHotelDetails() {
		return hotelRepository.findAll();
		
	}

	@Override
	public List<HotelInformation> getHotelDetailsByCity(String city) {
		return hotelRepository.findByCity(city);
	}

	@Override
	public HotelInformation getHotelById(int hotelid) {
		HotelInformation infs=hotelRepository.findById(hotelid).orElse(new HotelInformation());
		 return infs;
	}
	
}
