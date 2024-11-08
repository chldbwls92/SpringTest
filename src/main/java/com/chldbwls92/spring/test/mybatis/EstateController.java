package com.chldbwls92.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chldbwls92.spring.test.mybatis.domain.Estate;
import com.chldbwls92.spring.test.mybatis.service.EstateService;

@Controller
@RequestMapping("/mybatis/realestate/select")
public class EstateController {
	
	@Autowired
	private EstateService estateService;
	
	
	// 요청, 응답 처리하는 부분
	@ResponseBody
	@RequestMapping("/1")
	public Estate estate(@RequestParam("id") int id) {
		
		// parameter로 받아서 같은 id json 출력
		// id = 16인 부동산 정보 얻어오기
		Estate estate = estateService.getEstate(id);
		
		return estate;
	}
	
	@ResponseBody
	@RequestMapping("/2")
	public List<Estate> estateByRentPrice(@RequestParam("rent") int rentPrice) {
		
		// parameter로 받은 월세 금액보다 더 낮은 매물 정보 얻어오기
		List<Estate> estateList = estateService.getEstateByRentPrice(rentPrice);
		
		return estateList;
	}
	
	@ResponseBody
	@RequestMapping("/3")
	public List<Estate> estateByAreaAndPrice(
			@RequestParam("area") int area
			, @RequestParam("price") int price) {
		
		// parameter로 전달받은 넓이보다 크고, 가격보다 작은 매물 얻어오기
		List<Estate> estateList = estateService.getEstateByEreaAndPrice(area, price);
		return estateList;
	}
	
	

}
