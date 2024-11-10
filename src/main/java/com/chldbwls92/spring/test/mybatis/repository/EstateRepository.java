package com.chldbwls92.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.chldbwls92.spring.test.mybatis.domain.Estate;

@Mapper
public interface EstateRepository {
	
	
	// estate domain class에서 id를 가져옴
	// 전달받은 id와 일치하는 real_estate 행 조회
									// 연결점을 만들어주는 것
	public Estate selectEstate(@Param("id") int id);
	// 연결된 xml을 통해
	
	
	// 전달받은 월세보다 낮은 행 조회
	// 여러행이면 무조건 리스트
	// 쿼리수행
	public List<Estate> selectEstateByRentPrice(@Param("rentPrice") int rentPrice);
	
	public List<Estate> selectEstateByAreaAndPrice(
			@Param("area") int area
			, @Param("price") int price);
	
	
	public int insertEstateByObject(Estate estate);
	// insert는 type은 int로 고정
	public int insertEstate(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice);
	
	
	public int updateEstate(
			@Param("id") int id
			, @Param("type") String type
			, @Param("price") int price);
	
	
	// 특정 아이디 내용 없애는
	public int deleteEstate(@Param("id") int id);
}
