package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {

	@Autowired
	private RealtorBO realtorBO;
	
	// 입력 form URL : http://localhost:8080/lesson04/quiz02/add-realtor-view
	@GetMapping("/add-realtor-view")
	public String addRealtorView() {
	
		return "lesson04/addRealtor";
	}
	
	// http://localhost/lesson04/quiz02/add-realtor
	@PostMapping("/add-realtor")
	public String addRealtor(
			Model model,
			@ModelAttribute Realtor realtor) {
		
		// DB insert
		realtorBO.addRealtor(realtor);
		
		// 받아온 id로 select => Model에 담아서
		Realtor latestRealtor = realtorBO.getRealtorById(realtor.getId());
		model.addAttribute("realtor", latestRealtor);
		
		// Response => jsp
		return "lesson04/afterAddRealtor";
	}
}
