package com.quiz.lesson05.weather_history.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson05.weather_history.domain.WeatherHistory;
import com.quiz.lesson05.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {

	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	public WeatherHistory getWeatherHistory() {
		return weatherHistoryMapper.selectWeatherHistory();
	}
}
