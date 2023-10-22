package com.quiz.booking.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {

	@Autowired
	private BookingMapper bookingMapper;
	
	public List<Booking> getBookingList(){
		return bookingMapper.selectBookingList();
	}
	
	// input:id     output:int
	public void deleteBookingById(int id) {
		bookingMapper.deleteBookingById(id);
	}
	
	public void addBooking(String name, String date, int day, int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	// input: name, phoneNumber     output:Booking(null or Booking)
	public Booking getBookingBynamePhoneNumber(String name, String phoneNumber) {
		List<Booking> bookingList = bookingMapper.selectBookingBynamePhoneNumber(name, phoneNumber);
		// 0 1(최신)  마지막 인덱스를 리턴하도록
		// 리스트가 비어있으면 null이 아닌 []로 되어 있음
		if (bookingList.isEmpty()) {
			return null; // null로 리턴 
		}
		
		// 리스트가 비어있지 않으면 마지막 객체 리턴
		return bookingList.get(bookingList.size() - 1); // booking을 리턴
	}
}
