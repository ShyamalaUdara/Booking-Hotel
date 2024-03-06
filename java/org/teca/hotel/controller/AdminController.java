package org.teca.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.teca.hotel.dao.AdminDao;
import org.teca.hotel.entity.Admin;
import org.teca.hotel.controller.*;
import org.teca.hotel.entity.*;
import java.util.*;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
	@Autowired
	AdminDao adminDao;
	@RequestMapping("/admin")
	public String getAdmin(Admin admin,Model model)
	{
		return "AdminLogin";
	}
	@RequestMapping("/admindetails")
	public String getadmindetails(String emailid,@RequestParam("adminpassword") String password,Model model)
	{
		Admin login=adminDao.adminLogin(emailid, password);
		if(login!=null)
		{
			
			//System.out.println("login successfull");
			return "AllList";
		}
		else
		{
			//System.out.println("invalid details");
			model.addAttribute("msg", "Invalid details");
			return "AdminLogin";
		}
	}
	 @RequestMapping("/showalluser")
     public String allUserDetails(Model model)
     {
    	 List<UserInformation>alluser=adminDao.getAllUser();
    	// System.out.println(alluser);
    	 model.addAttribute("UserDetails", alluser);
    	 
    	 return "UsersList";
     }
     @RequestMapping("/showhotellist")
     public String allHotelDetails(Model model)
     {
    	 List<HotelInformation>allHotel=adminDao.getAllHotelList();
    	 model.addAttribute("HotelDetails", allHotel);
    	 System.out.println(allHotel);
    	 return "HotelList";
     }
     
     @RequestMapping("/showpaymentlist")
     public String allPaymentDetails(Model model)
     {
    	 List<Payment>allPayment=adminDao.getPaymentList();
    	 model.addAttribute("paymentDetails", allPayment);
    	 System.out.println(allPayment);
    	 return "PaymentList";
     }
     @RequestMapping("/getupdateid")
     public String getupdateid(int id,Model model)
     {
    	 System.out.println(id);
    	UserInformation userInformation=adminDao.getUserById(id);
    	model.addAttribute("user", userInformation);
    	System.out.println(userInformation);
    	
    	return "UpdateList";
     }
     
     @RequestMapping("/getupdateddetails")
     public String getUpdatedDetails(UserInformation information,Model model) {
 		//System.out.println(userInformation);
 		UserInformation userInformation=adminDao.updateUserDetails(information);
 		List<UserInformation> allUser=adminDao.getAllUser();
 		model.addAttribute("UserDetails",allUser);
 		return "UsersList";
 	}
 	@RequestMapping("/deleteuser")
 	public String deleteUser(int userid,Model model) {
 		//System.out.println(userid);
 		adminDao.deleteUserInformation(userid);
 		//System.out.println("user information deleted");
 		List<UserInformation> allUser=adminDao.getAllUser();
 		model.addAttribute("UserDetails",allUser);
 		return "UsersList";
 	}
}
