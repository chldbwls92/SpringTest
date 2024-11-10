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
@RequestMapping("/mybatis/realestate")
public class EstateController {
	
	@Autowired
	private EstateService estateService;
	
	
	// 요청, 응답 처리하는 부분
	@ResponseBody
	@RequestMapping("/select/1")
	public Estate estate(@RequestParam("id") int id) {
		
		// parameter로 받아서 같은 id json 출력
		// id = 16인 부동산 정보 얻어오기
		Estate estate = estateService.getEstate(id);
		
		return estate;
	}
	
	@ResponseBody
	@RequestMapping("/select/2")
	public List<Estate> estateByRentPrice(@RequestParam("rent") int rentPrice) {
		
		// parameter로 받은 월세 금액보다 더 낮은 매물 정보 얻어오기
		List<Estate> estateList = estateService.getEstateByRentPrice(rentPrice);
		
		return estateList;
	}
	
	@ResponseBody
	@RequestMapping("/select/3")
	public List<Estate> estateByAreaAndPrice(
			@RequestParam("area") int area
			, @RequestParam("price") int price) {
		
		// parameter로 전달받은 넓이보다 크고, 가격보다 작은 매물 얻어오기
		List<Estate> estateList = estateService.getEstateByEreaAndPrice(area, price);
		return estateList;
	}
	
	@ResponseBody
	@RequestMapping("/insert/1")
	public String createEstateByObject() {
		
		Estate estate = new Estate();
		estate.setRealtorId(3);
		estate.setAddress("푸르지용 리버 303동 1104호");
		estate.setArea(89);
		estate.setType("매매");
		estate.setPrice(100000);
		
		int count = estateService.addEstateByObject(estate);
		
		return "입력성공 : " + count;
	}
	
	
	@RequestMapping("/insert/2")
	@ResponseBody
	public String createEstate(@RequestParam("realtorId") int realtorId) {
		
		// 각각의 값 따로 전달하는
		int count = estateService.addEstate(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 1000000, 120);
		
		return "입력 성공 : " + count;
	}
	
	
	@RequestMapping("/update")
	@ResponseBody  // 문자열 그대로 보여주고 싶으니까
	public String updateEstate() {
		// id가 22인 행의 type을 전세로 바꾸고 price를 70000으로 변경하세요
		int count = estateService.updateEstate(22, "전세", 70000);
		
		return "수정 성공 : " + count;
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteEstate(@RequestParam("id") int id) {
		int count = estateService.deleteEstate(id);
		return "삭제 성공 : " + count;
	}
	

}
