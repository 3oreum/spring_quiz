package com.quiz.lesson02.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Store {

	private int id;
	private String name;
	private String phoneNumber;
	private String address;
	private String businessNumber;
	private String introduce;
	private Date createdAt;
	private Date updatedAt;
	
	
}
