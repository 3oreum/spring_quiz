package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.CompanyEntity;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer>{
	// JpaRepository : Spring Data JPA
	
	// save(엔티티객체) -> 인서트도 해주고 업데이트도 해 줌 => 아이디가 있으면 업데이트, 없으면 인서트
	// findById -> 조회
	// delete(엔티티객체)   ->  삭제
}
