package com.chldbwls92.spring.test.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/favorite")
public class FavoriteController {


	@GetMapping("/input")
	public String favoriteInput() {
		return "thymeleaf/ajax/favoriteInput";
	}

}



