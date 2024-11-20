package com.chldbwls92.spring.test.ajax.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	public int getBooking(String name, String phoneNumber) {
		// select쿼리 수행해야 돼서 repository
		int count = bookingRepository.selectBooking(name, phoneNumber);
		return count;
	}

}
