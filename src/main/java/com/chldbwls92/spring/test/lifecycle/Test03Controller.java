package com.chldbwls92.spring.test.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 무적권 컨트롤러 거쳐서
@RequestMapping("/lifecycle/test03")
public class Test03Controller {
	
	@RequestMapping("/1")
	public String thymleafTest() {
		return "lifecycle/Test03";
	}
	
}
