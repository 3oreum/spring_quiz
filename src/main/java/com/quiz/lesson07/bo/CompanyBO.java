package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {
	
	@Autowired
	private CompanyRepository companyRepository; // JPA

	// input: 4개 파라미터    output: 방금 인서트된 엔티티
	public CompanyEntity addCompany(String name, String business, String scale, int headcount) {
		
//		CompanyEntity company = CompanyEntity.builder()
//				.name(name)
//				.business(business)
//				.scale(scale)
//				.headcount(headcount)
//				.build();
//		
//		return companyRepository.save(company);
		
		return companyRepository.save(
					CompanyEntity.builder()
					.name(name)
					.business(business)
					.scale(scale)
					.headcount(headcount)
					.build());
	}
	
	// input: 3개 파라미터(id, scale, headcount)   output:CompanyEntity
	public CompanyEntity updateCompanyScaleHeadcountById(int id, String scale, int headcount) {
		CompanyEntity company = companyRepository.findById(id).orElse(null); // orElse(null) => 아무것도 없으면 null
		if (company != null) {
			company = company.toBuilder()
					.scale(scale)
					.headcount(headcount)
					.build();
			
			// update
			company = companyRepository.save(company);
		}
		return company;
	}
	
	// input: id     output:x
	public void deleteCompanyById(int id) {
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		companyOptional.ifPresent(c -> companyRepository.delete(c));
	}
}
