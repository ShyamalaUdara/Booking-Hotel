package org.teca.hotel.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teca.hotel.entity.UserInformation;
import org.teca.hotel.repository.UserRepository;

@Component
public class UserDaoImp implements UserDao{

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserInformation userRegistration(UserInformation userInformation) {
		UserInformation information=userRepository.save(userInformation);
		return information;
	}

	@Override
	public UserInformation userLogin(String emailid, String password) {
		return userRepository.findByEmailidAndPassword(emailid, password);
	}

}
