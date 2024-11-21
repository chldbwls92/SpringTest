package com.chldbwls92.spring.test.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chldbwls92.spring.test.jpa.domain.Company;
import com.chldbwls92.spring.test.jpa.service.CompanyServcie;


@RequestMapping("/jpa/company")
@Controller
public class CompanyController {
	
	@Autowired
	private CompanyServcie companyService;
	
	
	
	
	//create
	@ResponseBody
	@GetMapping("/create")
	public Company createCompany() {
		Company company = companyService.addCompany("넥손", "컨텐츠 게임", "대기업", 3585);
		
		company = companyService.addCompany("버블팡", "여신 금융업", "대기업", 6834);
		return company;
	}
	
	
	//update
	@ResponseBody
	@GetMapping("/update")
	public Company updateCompany() {
		// id로 업데이트(id=15)
		Company company = companyService.updateCompany(15, "중소기업", 34);
		
		return company;
	}
	
	
	// delete
	@ResponseBody
	@GetMapping("/delete")
	public String deleteCompany() {
		
		// id 8인 버블팡 회사 삭제
		companyService.deleteCompany(15);
		return "수행 완료";
	}
	

}
