package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@Controller
public class Lesson06Controller {
	
	@Autowired
	private BookmarkBO bookmarkBO;
	
	
	// ------ quiz01 ------
	
	// 즐겨찾기 추가 화면
	@GetMapping("/lesson06/quiz01/add-bookmark-view")
	public String addBookmarkView() {
		
		return "lesson06/addBookmark";
	}
	
	// 즐겨찾기 추가 기능 - AJAX가 하는 요청
	@PostMapping("/lesson06/quiz01/add-bookmark")
	@ResponseBody
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// db insert
		bookmarkBO.addBookmark(name, url);
		
		// 응답값: JSON String
//		{
//			"code":200, - 성공일 때
//			"result":"success"
//		}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");
		return result; // JSON String
	}

	
	// 즐겨찾기 목록 화면
	@GetMapping("/lesson06/quiz01/bookmark-list-view")
	public String bookmarkListView(Model model) {
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		model.addAttribute("bookmarkList", bookmarkList);
		
		return "lesson06/bookmarkList";
	}
	
	// ------ quiz01 끝 ------
	
	// ------ quiz02 ------
	
	// url 중복 확인
	@ResponseBody
	@RequestMapping("/lesson06/quiz02/is-duplication")
	public Map<String, Object> isDuplication(
			@RequestParam("url") String url){
		
		// DB 조회
		boolean isDuplication = bookmarkBO.existUserByUrl(url);
		
		// 응답값
		// {"code":200, "is_duplication":true}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplication", isDuplication);
		return result;
	}
	
}
