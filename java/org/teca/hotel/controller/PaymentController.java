package org.teca.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.teca.hotel.dao.BookingDao;
import org.teca.hotel.dao.PaymentDao;
import org.teca.hotel.entity.BookingInformation;
import org.teca.hotel.entity.Payment;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {
	@Autowired
	private PaymentDao payDao;
	@Autowired
	private BookingDao bookDao;

	@RequestMapping("/payment")
	@ResponseBody
	public String paymentDetails(Payment payment, HttpServletRequest request) {
		if (payment != null) {
			HttpSession session = request.getSession();
			BookingInformation info = (BookingInformation) session.getAttribute("bookinfo");
			BookingInformation information = bookDao.getBookingInfo(info);
            //session.setAttribute("paymentlist", payDao.getPaymentList());
			Payment paymentde = payDao.getPayment(payment);
			System.out.println(information);
			System.out.println(paymentde);
			return "payment successfull";
		} else {
			return "payment not done";
		}

	}

}
