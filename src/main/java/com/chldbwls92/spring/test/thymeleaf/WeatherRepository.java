package com.chldbwls92.spring.test.thymeleaf;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WeatherRepository {
	
	public List<Weather> selectWeather();
	
	
	public int insertWeather(
			@Param("date") LocalDate date
			, @Param("weather")  String weather
			, @Param("temperatures") double temperatures
			, @Param("precipitation")  double precipitation
			, @Param("dmicroDustate") String microDust
			, @Param("windSpeed") double windSpeed);
}
