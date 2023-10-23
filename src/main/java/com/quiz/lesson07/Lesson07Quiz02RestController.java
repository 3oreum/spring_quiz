package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {

	@Autowired
	private RecruitRepository recruitRepository;
	
	@GetMapping("/1")
	public RecruitEntity getRecruit() {
		// id:8
		return recruitRepository.findById(8);
	}
	
	@GetMapping("/2")
	public List<RecruitEntity> getRecruit2(
			@RequestParam("companyId") int companyId){
		return recruitRepository.findByCompanyId(companyId);
	}
	
	@GetMapping("/3")
	public List<RecruitEntity> getRecruit3(){
		//웹 back-end 개발자 이고 정규직인 공고를 조회하고 아래와 같이 출력하세요.
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	@GetMapping("/4")
	public List<RecruitEntity> getRecruit4(){
		// 정규직이거나 연봉이 9000 이상인 공고를 조회하고 아래와 같이 출력하세요.
		return recruitRepository.findByTypeOrSalaryGreaterThan("정규직", 9000);
	}
	
	@GetMapping("/5")
	public List<RecruitEntity> getRecruit5(){
		// 계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회하세요.
		return recruitRepository.findByTypeAndTop3ByOrderBySalaryDesc("계약직");
	}
}
