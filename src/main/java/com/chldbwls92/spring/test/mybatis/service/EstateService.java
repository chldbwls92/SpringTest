package com.chldbwls92.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chldbwls92.spring.test.mybatis.domain.Estate;
import com.chldbwls92.spring.test.mybatis.repository.EstateRepository;

@Service
public class EstateService {
	
	// 객체 자동생성
	@Autowired
	private EstateRepository estateRepository;
	
	// repository 연결
	// 전달받은 id와 일치하는 부동산 매물 정보 얻어오기
	public Estate getEstate(int id) {
		// id가 16인 real_estate 행 조회
		Estate estate = estateRepository.selectEstate(id);
		return estate;
	}
	
	// 전달받은 월세보다 낮은 매물 정보 조회 얻어오기
	public List<Estate> getEstateByRentPrice(int rentPrice) {
		
		// 전달받은 월세보다 낮은 행을 real_estate에서 조회
		List<Estate> estateList = estateRepository.selectEstateByRentPrice(rentPrice);
		
		return estateList;
		
	}
	
	public List<Estate> getEstateByEreaAndPrice(int area, int price) {
		
		List<Estate> estateList = estateRepository.selectEstateByAreaAndPrice(area, price);
		return estateList;
	}
	
	// 객체 형태로 저장해서 insert
	public int addEstateByObject(Estate estate) {
		int count = estateRepository.insertEstateByObject(estate);
		return count;
	}
	
	// 따로 하나하나 전달해주는
	public int addEstate(
			int realtorId
			, String address
			, int area
			, String type
			, int price
			, int rentPrice) {
		
		int count = estateRepository.insertEstate(realtorId, address, area, type, price, rentPrice);
		return count;
	}
	
	
	public int updateEstate(
			int id
			, String type
			, int price) {
		
		// 업데이트 쿼리를 수행시켜야됨
		int count = estateRepository.updateEstate(id, type, price);
		
		return count;
	}

	
	public int deleteEstate(int id) {
		// delete 쿼리 실행
		int count = estateRepository.deleteEstate(id);
		
		return count;
	}
	
}
