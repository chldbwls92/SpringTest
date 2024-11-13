package com.chldbwls92.spring.test.thymeleaf;

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
	

}
