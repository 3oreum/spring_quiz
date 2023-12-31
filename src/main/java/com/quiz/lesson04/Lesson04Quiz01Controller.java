package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;

	// 판매자 추가 화면
	// 입력 form URL : http://localhost:8080/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// 입력 후 '입력 성공' 페이지로 이동
	// http://localhost/lesson04/quiz01/add-seller
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value="profileImageUrl", required=false) String profileImageUrl,
			@RequestParam(value="temperature", required=false) Double temperature) {
		
		// DB insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "lesson04/afterAddSeller";
	}
	
	// 가장 최근에 추가된 seller의 정보 가져오는 페이지
	// http://localhost:8080/lesson04/quiz01/seller-info
	// http://localhost:8080/lesson04/quiz01/seller_info?id=1
	@GetMapping("/seller-info")
	public String sellerInfo(
			Model model,
			@RequestParam(value="id", required=false) Integer id) {
		
		Seller seller = null;
		if (id == null) {
			seller = sellerBO.getLatestSeller();
		} else {
			seller = sellerBO.getSellerById(id);
		}
		
		model.addAttribute("result", seller);
		model.addAttribute("title", "판매자 정보");
		
		return "lesson04/sellerInfo";
	}
	

}
