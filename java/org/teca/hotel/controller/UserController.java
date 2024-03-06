package org.teca.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.teca.hotel.dao.HotelDao;
import org.teca.hotel.dao.UserDao;
import org.teca.hotel.entity.HotelInformation;
import org.teca.hotel.entity.UserInformation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;
	@Autowired
	private HotelDao hotelDao;

	@RequestMapping("/registration")
	public String userRegistration(Model model) {
		UserInformation information = new UserInformation();
		model.addAttribute("userinformation", information);
		return "AddUsers";
	}

	@RequestMapping("/userdetails")
	// @ResponseBody
	public String userDetails(UserInformation userInformation, Model model) {
		UserInformation registration = userDao.userRegistration(userInformation);
		if (registration != null) {
			// System.out.println(userInformation);
			return "Login";
		} else {
			model.addAttribute("msg", "invalid details");
			return "AddUsers";
		}
	}

	@RequestMapping("/loginpage")
	public String loginPage() {
		return "Login";
	}

	@RequestMapping("/userlogin")
	public String userLoginDetails(String emailid, String password, Model model, HttpServletRequest request) {
		// System.out.println(emailid);
		// System.out.println(password);
		UserInformation information = userDao.userLogin(emailid, password);
		HttpSession session = request.getSession();
		session.setAttribute("user", information);
		if (information != null) {
			// System.out.println("login successfull");
			List<HotelInformation> allHotelDetails = hotelDao.getAllHotelDetails();
			// System.out.println(allHotelDetails);
			model.addAttribute("HotelDetails", allHotelDetails);
			session.setAttribute("hotellist", allHotelDetails);
			return "HotelList";
		} else {
			// System.out.println("invalid login details");
			model.addAttribute("msg", "Invalid Details");
			return "Login";
		}
	}

	@RequestMapping("/searchByCity")
	public String getCity(String city, Model model) {
		// System.out.println(city);
		List<HotelInformation> byCity = hotelDao.getHotelDetailsByCity(city);
		// System.out.println(byCity);
		model.addAttribute("HotelDetails", byCity);
		return "HotelList";
	}
}
