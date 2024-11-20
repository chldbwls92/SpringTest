package com.chldbwls92.spring.test.ajax.booking;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookingRepository {
	
	// 전체 list return 해주는 repository
	public List<Booking> selectBookingList();
	
	// 이름과 번호 입력하면 그에 해당되는 예약정보 return 해주는 repository
	public int selectBooking(
			@Param("name") String name
			, @Param("phoneNumber") String phoneNumber);
}
