package com.chldbwls92.spring.test.ajax.booking;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {
	
	@GetMapping("/main")
	public String bookingMain() {
		return "ajax/booking/main";
	}
	
	
	// 언제, 어디서, 무엇을, 어떻게, 왜
	// 언제 : 사용자가 예약정보를 입력하고 저장을 수행하고자 할 때
	// 어디서 : 서버
	// input(request) : 예약에 필요한 예약자 정보
	// 기능 : 예약 정보를 저장한다(무엇을)
	// 어떻게 : 예약 정보를 booking 테이블에 insert 한다.
	// 왜 : 테이블에 저장해야 나중에 예약 목록을 얻어 올 수 있으니까
	// output(response) : 
	@GetMapping("/create")
	public Map<String, String> createBooking(
			@RequestParam("name") String name
			, @RequestParam("date") LocalDate date
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, RequestParam("phoneNumber") String phoneNumber) {
		
		int count;
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return reusultMap;
	}
	

}
