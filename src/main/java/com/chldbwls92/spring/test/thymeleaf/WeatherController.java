package com.chldbwls92.spring.test.thymeleaf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/info")
	public String input(Model model) {

		model.addAttribute("weatherList", weatherService.getWeather());
		
		return "thymeleaf/test04";
	}

}
