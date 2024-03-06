package org.teca.hotel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teca.hotel.entity.Admin;
import org.teca.hotel.repository.AdminRepository;
import org.teca.hotel.repository.HotelRepository;
import org.teca.hotel.repository.PaymentRepository;
import org.teca.hotel.repository.UserRepository;
import org.teca.hotel.entity.*;
import java.util.*;
@Component
public class AdminDaoImpl implements AdminDao{

	@Autowired
	AdminRepository adminRep;
	@Autowired
	private UserRepository userepo;
	
	@Autowired
	private HotelRepository hotelrepo;
	
	@Autowired
	private PaymentRepository paymentrepo;

	@Override
	public Admin adminLogin(String emaildid, String password) {
		// TODO Auto-generated method stub
		return adminRep.findByAdminemailidAndAdminpassword(emaildid, password);
	}
	
	@Override
	public List<UserInformation> getAllUser() {
		return userepo.findAll();
		
	}

	@Override
	public List<HotelInformation> getAllHotelList() {
		
		return hotelrepo.findAll();
	}

	@Override
	public List<Payment> getPaymentList() {
		
		return paymentrepo.findAll() ;
	}

	@Override
	public UserInformation getUserById(int id) {
		return userepo.findById(id).orElse(new UserInformation());
	}
	@Override
	public UserInformation updateUserDetails(UserInformation information) {
		return userepo.save(information);
	}
	@Override
	public void deleteUserInformation(int id) {
		userepo.deleteById(id);
	}

	
}
