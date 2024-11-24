package com.chldbwls92.spring.test.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chldbwls92.spring.test.jpa.domain.Recruit;
import com.chldbwls92.spring.test.jpa.repository.RecruitRepository;

@RequestMapping("/recruit")
@Controller
public class RecruitController {
	
	
	@Autowired
	private RecruitRepository recruitRepository;
	
	@ResponseBody
	@GetMapping("/findId")
	public Recruit findId() {
		
		Recruit recruit = recruitRepository.findById(8);
		return recruit;
	}
	
	
	
	
	
	@ResponseBody
	@GetMapping("/parameter")
	public Recruit findParameter(@RequestParam("id") int id) {
		
		Recruit recruit = recruitRepository.findById(id);
		
		return recruit;
		
	}
	
	
	@ResponseBody
	@GetMapping("/manycondition")
	public List<Recruit> problem() {
		List<Recruit> recruitList = null;
		
		// 3번 문제
//		recruitList = recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		
		// 4번 문제
//		recruitList = recruitRepository.findByTypeOrSalaryAfter("정규직", 9000);
				
		
		//5번 문제
//		recruitList = recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
		
		// 6번 문제
//		recruitList = recruitRepository. findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
		
		// 7번 문제
		recruitList = recruitRepository.selectByRegion("2026-04-10", 8100, "정규직");
		return recruitList;
	}
	

}
