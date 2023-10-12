package com.quiz.lesson05.weather_history.mapper;

import org.springframework.stereotype.Repository;

import com.quiz.lesson05.weather_history.domain.WeatherHistory;

@Repository
public interface WeatherHistoryMapper {

	public WeatherHistory selectWeatherHistory();
}
