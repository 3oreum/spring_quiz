package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {

	public RealEstate selectRealEstateById(int id);
	
	public List<RealEstate> selectRealEstateListByRentPrice(
			@Param("rentPrice") int rentPrice);
	
	public List<RealEstate> selectRealEstateListByAreaPrice(
			// @Param => 하나의 map이 된다.(파라미터가 2개 이상일 때 @Param을 붙인다)
			@Param("area") int area, 
			@Param("price") int price);
	
	// mybatis가 성공된 행의 개수를 채워서 리턴해줌
	public int insertRealEstate(RealEstate realEstate);
	
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId,
			@Param("address") String address, 
			@Param("area") int area, 
			@Param("type") String type, 
			@Param("price") int price, 
			@Param("rentPrice") Integer rentPrice);

	public int updateRealEstateById(
			@Param("id") int id, 
			@Param("type") String type, 
			@Param("price") int price);

	public int deleteRealEstateById(int id);
}

