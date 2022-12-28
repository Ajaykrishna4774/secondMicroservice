package com.RestFul.capgemini.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Price {
	
	@Id
	private Integer PriceId;
	
	private Integer Price;

	public Price(Integer priceId, Integer price) {
		super();
		PriceId = priceId;
		Price = price;
	}

	public Price() {
		super();
		
	}

	public Integer getPriceId() {
		return PriceId;
	}

	public void setPriceId(Integer priceId) {
		PriceId = priceId;
	}

	public Integer getPrice() {
		return Price;
	}

	public void setPrice(Integer price) {
		Price = price;
	}
	
	

}
