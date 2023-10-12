package com.quiz.lesson05.weather_history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.quiz.lesson05.weather_history.bo.WeatherHistoryBO;
import com.quiz.lesson05.weather_history.domain.WeatherHistory;

@Controller
public class WeatherHistoryController {

	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	@GetMapping("/lesson05/quiz05")
	public String quiz05(Model model) {
		WeatherHistory weatherHistory = new WeatherHistory();
		
		model.addAttribute("weatherHistory", weatherHistory);
		
		return "weather_history/quiz05";
	}
}
