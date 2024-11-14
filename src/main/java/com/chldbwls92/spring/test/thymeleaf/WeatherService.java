package com.chldbwls92.spring.test.thymeleaf;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
	
	// 자동 변수 생성
	@Autowired
	private WeatherRepository weatherRepository;
	
	
	//repository 연결하여 정보 가져오기
	public List<Weather> getWeather() {
		
		List<Weather> weather = weatherRepository.selectWeather();
		
		return weather;
	}
	
	
	// create 정보 저장할 곳
	public int addWeather(
			LocalDate date
			, String weather
			, double temperatures
			, double precipitation
			, String microDust
			, double windSpeed) {
		
		int count = weatherRepository.insertWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		return count ;
		
	}

}
