package com.RestFul.capgemini.demo.Service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.RestFul.capgemini.demo.Entity.Price;

@Repository
public interface Service {
	
	List<Price>  getAllPrices();
	
	Price getPrice(int priceId);
	
	int addPrice(Price i);
	
	void deletePrice(int id);
}
