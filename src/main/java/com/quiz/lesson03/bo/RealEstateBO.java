package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateMapper realEstateMapper;
	
	// input: id(정수)
	// output: RealEstate
	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstateById(id);
	}
	
	// input: rantPrice
	// output: List<RealEstate>
	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
		return realEstateMapper.selectRealEstateListByRentPrice(rentPrice);
	}
	
	public List<RealEstate> getRealEstateListByAreaPrice(int area, int price){
		return realEstateMapper.selectRealEstateListByAreaPrice(area, price);
	}
	
	// input: RealEstate
	// output: 성공된 행의 개수 
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
	public int addRealEstateAsField(int realtorId, String address, int area, String type, int price, Integer rentPrice) {
		return realEstateMapper.insertRealEstateAsField(realtorId, address, area, type, price, rentPrice);
	}
	
	// input: id, type, price
	// output: int(성공된 행의 개수)
	public int updateRealEstateById(int id, String type, int price) {
		return realEstateMapper.updateRealEstateById(id, type, price);
	}
	
	// input: id
	// output: int(성공된 행의 개수)
	public int deleteRealEstateById(int id) {
		return realEstateMapper.deleteRealEstateById(id);
	}
}
