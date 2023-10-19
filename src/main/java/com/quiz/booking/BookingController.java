package com.quiz.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;

	// 예약 화면 보기
	@GetMapping("/booking-list-view")
	public String reservationListView(Model model) {
		List<Booking> bookingList = bookingBO.getBooking();
		model.addAttribute("bookingList", bookingList);
		
		return "booking/bookingList";
	}
	
	// 예약하기 화면
	@GetMapping("/add-booking-view")
	public String addBookingView() {
		return "booking/addBooking";
	}
	
	// 예약 확인 화면
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}
}
