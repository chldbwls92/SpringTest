package com.chldbwls92.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chldbwls92.spring.test.database.domain.Store;
import com.chldbwls92.spring.test.database.repository.StoreRepository;

@Service	// 컨트롤러에서 쓰기 위해 만드는 곳
public class StoreService {
	
	@Autowired // 객체생성 자동으로 해주는 것
	private StoreRepository storeRepository;
	
	// 가게 리스트 얻어오기
	public List<Store> getStoreList() {
		
		
		// store 테이블의 모든 행 조회
		// 쿼리를 수행한다 => (service)의 역할 x
		// 레파지토리 생성
		
		// 데이터베이스 안에 있는 메소드 가져오는 메소드
		// 순수한 자바문법임. 그저 기능 쓰는 것
		List<Store> storeList = storeRepository.selectStoreList();
		
		return storeList;
	}
}
