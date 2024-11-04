package com.chldbwls92.spring.test.mybatis.service;

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
	public Estate getEstate(int id) {
		Estate estate = estateRepository.selectEstate(id);
		return estate;
	}

}
