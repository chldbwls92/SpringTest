package com.chldbwls92.spring.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chldbwls92.spring.test.database.domain.Store;
import com.chldbwls92.spring.test.database.service.StoreService;

//request, response
@Controller
public class StoreController {
			// 얘는 서비스밖에 몰라!!! "서비스"에서 가져와야돼!!!
	
	// 특정 클래스 메소드 가져오기 위해서는 객체 생성하여 가져와야댐(spring)사용법
	@Autowired
	private StoreService storeService;
	
	
	@ResponseBody
	@RequestMapping("/db/store/list")
	//json 구조와 유사하게 자바 코드로 만들어주면 알아서 json코드로 만들어줘
	public List<Store> storeList() {
		
		// 가게 정보 리스트 얻어오기
		List<Store> storeList =  storeService.getStoreList();
		
		return storeList;
	}
	
	
}
