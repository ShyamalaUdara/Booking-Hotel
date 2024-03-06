package org.teca.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.teca.hotel.dao.HotelDao;
import org.teca.hotel.entity.HotelInformation;
import org.teca.hotel.entity.UserInformation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HotelController {
	
	@Autowired
	private HotelDao hotelDao;
	@RequestMapping("/hotelregistration")
	public String hotelRegistration()
	{
		return "AddHotel";
	}
	
	@RequestMapping("/hoteldetails")
	@ResponseBody
	public String hotelDetails(HotelInformation hotelInformation)
	{
		HotelInformation registrationh=hotelDao.hotelRegistration(hotelInformation);
		if(registrationh !=null)
		{
			return "hotel added successfully";
		}
		else
		{
			return "Invalid hotel information";
		}
	}
	
	@RequestMapping("/gethotelbyid")
	public String getHotelId(int hotelid,HttpServletRequest request,Model model)
	{
		HotelInformation inf=hotelDao.getHotelById(hotelid);
		System.out.println(inf);
		HttpSession session=request.getSession();
		UserInformation information2=(UserInformation)session.getAttribute("user");
		model.addAttribute("user", information2);
	     session.setAttribute("shhotel",inf);
		model.addAttribute("hotelname",inf.getHotelname());
		model.addAttribute("price",inf.getPrice());
		System.out.println(information2);
		return "BookHotel";
	}

}
