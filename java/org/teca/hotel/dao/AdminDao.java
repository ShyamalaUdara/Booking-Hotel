package org.teca.hotel.dao;

import org.teca.hotel.entity.Admin;

import java.util.List;

import org.teca.hotel.entity.*;
public interface AdminDao {
	Admin adminLogin(String emaildid,String password);
	List<UserInformation> getAllUser();
	List<HotelInformation> getAllHotelList();
	List<Payment> getPaymentList();
	UserInformation getUserById(int id);
	UserInformation updateUserDetails(UserInformation information);
	void deleteUserInformation(int id);
}
