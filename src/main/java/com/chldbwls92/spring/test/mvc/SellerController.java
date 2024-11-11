package com.chldbwls92.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chldbwls92.spring.test.mvc.service.SellerService;

@Controller
@RequestMapping("/mvc/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	
	@ResponseBody
	@PostMapping("/create")
	public String createSeller(
					@RequestParam("nickname") String nickname
					, @RequestParam("profileImage") String profileImae
					, @RequestParam("temperature") double temperature) {
		
		int count = sellerService.addSeller(nickname, profileImae, temperature);
		return "입력 성공 : " + count;
	}
	
	@GetMapping("/input")
	public String sellerInput() {
		return "mvc/sellerInput";
	}
	
	@GetMapping("/info")
	public String sellerInfo() {
		return "mvc/sellerInfo";
	}

}
