package com.chldbwls92.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chldbwls92.spring.test.mvc.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	// 그저 자바 문법
	// 레파지토리에서 가져오는 것
	public int addSeller(
			String nickname
			, String profileImage
			, double temperature) {
		
		// 제대로 수행됐는지 확인하기 위해 count return
		int count = sellerRepository.insertSeller(nickname, profileImage, temperature);
		return count;
	}
}
