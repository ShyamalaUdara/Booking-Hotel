package org.teca.hotel.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.teca.hotel.dao.BookingDao;
import org.teca.hotel.entity.BookingInformation;
import org.teca.hotel.entity.HotelInformation;
import org.teca.hotel.entity.UserInformation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BookingController {

	@Autowired
	private BookingDao bookDao;
	@RequestMapping("/bookinginfo")
	public String getBookingInformation(BookingInformation bookInformation,Model model,HttpServletRequest request)
	{	
		if(bookInformation.getBookingdate().isAfter(LocalDate.now()) || bookInformation.getBookingdate().isEqual(LocalDate.now()))
		{
			
			/*BookingInformation information=bookDao.getBookingInfo(bookInformation);*/	
			HttpSession session=request.getSession();
			session.setAttribute("bookinfo", bookInformation);
			model.addAttribute("price", bookInformation.getPrice());
			return "AfterHotelPayment";
		}
		else
		{
			
			//System.out.println("invalid");
			UserInformation information2=(UserInformation)request.getSession().getAttribute("user");
			model.addAttribute("user",information2);
			HotelInformation information3=(HotelInformation)request.getSession().getAttribute("shhotel");
			model.addAttribute("hotelname",information3.getHotelname());
			model.addAttribute("price",information3.getPrice());
			model.addAttribute("msg1","invalid date");
			return "BookHotel";
		}
	}
}
