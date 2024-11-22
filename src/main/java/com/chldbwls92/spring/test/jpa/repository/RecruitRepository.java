package com.chldbwls92.spring.test.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls92.spring.test.jpa.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Integer>{

	//id로 조회
	// WHERE `id` = #{id}
	public Recruit findById(int id);
	
	//3
	// position이 웹 back-end 개발자, type 이 정규직
	// WHERE position = 웹 백엔드 AND type = 정규직
	public List<Recruit> findByPositionAndType(String position, String type);
	
	//4
	// type이 정규직 "이거나" salary가 9000이상
	// WHERE type = "정규직" OR salary >= 9000
	public List<Recruit> findByTypeOrSalaryAfter(String type, int start);
	
	
	//5
	// type = "계약직" AND salary DESC Limit 3
	
}
