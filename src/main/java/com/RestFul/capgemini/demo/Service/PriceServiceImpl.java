package com.RestFul.capgemini.demo.Service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.RestFul.capgemini.demo.Entity.Item;
import com.RestFul.capgemini.demo.Entity.Price;
import com.RestFul.capgemini.demo.Repository.PriceRepository;
import com.RestFul.capgemini.demo.feign.FeignClientInterface;


@Component
public class PriceServiceImpl implements Service{

	@Autowired
	private PriceRepository priceRepo;
	
	private RestTemplate restTemplate;

	private FeignClientInterface feign;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(PriceServiceImpl.class);
	public String ServiceLog() {
		LOGGER.info("This is a Emplpyee service Layer ");
		return "ServiceLog";
	}
	@Override
	public List<Price> getAllPrices() {
		LOGGER.info("inside class !!! ItemService, method!!!: getAllItems");
		
		List<Price> allEmployees = priceRepo.getAllPrices();
		
		return allEmployees;
	}
	@Override
	public Price getPrice(int priceId) {
		
		return priceRepo.getPrice(priceId);	
	}
	@Override
	public int addPrice(Price i) {
		
		return priceRepo.addPrice(i);
	}
	@Override
	public void deletePrice(int id) {
		priceRepo.deletePrice(id);
		
	}
	public List<Item> getAllItems() {
		      HttpHeaders headers = new HttpHeaders();
		      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      HttpEntity <String> entity = new HttpEntity<String>(headers);
		      
		      return restTemplate.exchange("http://localhost:8080/getAllItems", HttpMethod.GET, entity, List.class).getBody();
	}
	public Item getItem(int id) {
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8080/getItem/"+id, HttpMethod.GET, entity, Item.class).getBody();
	}
	public String addItem(Item id) {
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8080/items", HttpMethod.POST, entity, String.class).getBody();
	}
	public String deleteItem(int id) {
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8080/deleteItem/"+id, HttpMethod.DELETE, entity, String.class).getBody();
		
	}
	public List<Item> getAllItemsFeign() {	
		return feign.getAllItems();
	}
	
	

}
