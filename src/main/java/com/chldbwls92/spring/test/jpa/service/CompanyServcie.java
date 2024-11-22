package com.chldbwls92.spring.test.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chldbwls92.spring.test.jpa.domain.Company;
import com.chldbwls92.spring.test.jpa.repository.CompanyRepository;

@Service
public class CompanyServcie {
	
	// 자동 객체 생성
	@Autowired
	private CompanyRepository companyRepository;
	
	// create
	public Company addCompany(String name, String business, String scale, int headcount) {
		
		//ntt 객체 통해서 전달
		Company company = Company.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build();
		
		// 그대로 테이블에 저장해서 return
		Company result = companyRepository.save(company);
		
		return result;
				
	}
	
	
	//update
	public Company updateCompany(int id, String scale, int headcount) {
		
		Optional<Company> optionalCompany = companyRepository.findById(id);
		
		if(optionalCompany.isPresent()) {
			// optional 객체에 데이터 객체가 null이 아닌경우
			Company company = optionalCompany.get();
			
			company = company.toBuilder()
					.scale(scale)
					.headcount(headcount)
					.build();
			
			Company result = companyRepository.save(company);
			
			return result;
		}
		
		return null;
		
	}
	
	
	
	
	
	// delete
	public void deleteCompany(int id) {
		
		// null이 올 수 있으니까 optional
		Optional<Company> optionalCompany = companyRepository.findById(id);
//		if(optionalCompany.isPresent()) {
//			companyRepository.delete(optionalCompany.get());
//		}
		
		// 람다식 표현!!!!!!!!!!!!!!!!!!!!!!
		// null 이 아닐 때 수행될 기능 등록
		optionalCompany.ifPresent(company -> companyRepository.delete(company));
		
	}
	
	
}
