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
	

}
