package com.chldbwls92.spring.test.thymeleaf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@GetMapping("/create")
	public String createWeather(
//			@DateTimeFormat(pattern="yyyy년 M월 dd일")
//			@RequestParam("date") LocalDate date
//			, @RequestParam("weather") String weather
//			, @RequestParam("temperatures")double temperatures
//			, @RequestParam("pricipitation") double precipitation
//			, @RequestParam("microDust") String microDust
//			, @RequestParam("windSpeed") double windSpeed) {
			@ModelAttribute Weather weather) {
		// 클래스를 타입으로 하는 걸 가져오면 저렇게 해서 가져올 수 있음
		
//		int count = weatherService.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		int count = weatherService.addWeather(
				weather.getDate()
				, weather.getWeather()
				, weather.getTemperatures()
				, weather.getPrecipitation()
				, weather.getMicroDust()
				, weather.getWindSpeed());
		return "redirect:/thymeleaf/weather/test04";
	}
	
	
	
	@GetMapping("/input")
	public String input() {
		
		return "thymeleaf/weatherInput";
	}
	

}
