package com.chldbwls92.spring.test.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chldbwls92.spring.test.database.domain.Store;

@Mapper
public interface StoreRepository {

	// store 테이블 전체 행 조회
	// 마이마티스 이용(설정 : 빌드그래들 & 리소스 나뭇잎 모양)
	
	// 기본적으로 return type = list
	// 한 행을 저장할 class 하나 만들어서 거기에 저장!
	// -> 해당하는 컬럼이름과 동일한 멤버변수 만들어서!
	// => ntt, domain class
	//		내가 만든 걸로 정확하게 import 해주기
	public List<Store> selectStoreList();
	// xml로 연결(mapper로 끝나는 걸로 연결하겠다는 설정 마이마티스 설정에서 해놓음)
	
	
	
	
	
	
}
