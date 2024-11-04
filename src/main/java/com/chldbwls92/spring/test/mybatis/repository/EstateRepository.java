package com.chldbwls92.spring.test.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.chldbwls92.spring.test.mybatis.domain.Estate;

@Mapper
public interface EstateRepository {
	
	// estate domain class에서 id를 가져옴
	public Estate selectEsate(@Param("id") int id);

}
