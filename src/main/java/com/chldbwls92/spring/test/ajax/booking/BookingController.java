package com.chldbwls92.spring.test.ajax.booking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	// 변수 생성
	@Autowired
	private BookingService bookingService;
	
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
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		int count = bookingService.getBooking(name, phoneNumber);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	// 언제 : 사용자가 이름과 전화번호를 입력하고 조회를 요청했을때
	// 어디서 : 서버에서
	// input : 예약자 이름, 전화번호
	// 기능 :
	// 무엇을 : 이름과 전화번호가 일치하는 사용자 정보 조회
	// 어떻게 : booking 테이블에 이름과 전화번호를 조건으로 일치하는 행 select
	// 왜 : 예약자의 모든 정보가 필요하니까
	// output: 예약자 정보
//	@ResponseBody
//	@GetMapping("/info")
//	public Map<String,Object> bookingInfo(
//			@RequestParam("name") String name
//			,@RequestParam("phoneNumber") String phoneNumber) {
//		Booking booking = bookingService.getBooking(name, phoneNumber);
//		
//		// {"name":"김인규", "day":1, "headcount":2, .......}
//		
//		Map<String, Object> resultMap = new HashMap<>();
//		// 조회 성공 : {"result":"success"}
//		// 조회 실패 : {"result":"fail"}
//		if(booking != null) {
//			resultMap.put("result", "success");
//			resultMap.put("item", booking);
//		} else {
//			resultMap.put("result", "fail");
//		}
//		
//		return resultMap;
//	}
//	
//	

}