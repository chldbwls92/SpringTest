package com.chldbwls92.spring.test.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	// 계약직 목록을 연봉 기준으로 내림차순 정렬하여 3개만 조회
	// type = "계약직" ORDER BY salary DESC Limit 3
	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);
	
	//6
	// region이 "성남시 분당구" AND salary가 7000 <= x <= 8500
	public List<Recruit> findByRegionAndSalaryBetween(String region, int strart, int end);
	
	// 7
	// deadline이 2026-04-10 이후 AND salary가 8100이상 AND Type="정규직" ORDER BY Salary DESC;
	// native query
	// 특정 컬럼만 가져오거나, 여러 테이블 조인할 때 사용
	@Query(value="SELECT * FROM `recruit` WHERE `region` = :region AND `salary` = :salary ORDER BY `salary` DESC" , nativeQuery=true)
	public List<Request> selectByRegion(@Param("region")String region
										, @Param("salary") int salary);
	
}