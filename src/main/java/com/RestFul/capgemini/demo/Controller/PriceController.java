package com.RestFul.capgemini.demo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestFul.capgemini.demo.Entity.Item;
import com.RestFul.capgemini.demo.Entity.Price;
import com.RestFul.capgemini.demo.Service.PriceServiceImpl;
import com.RestFul.capgemini.demo.feign.FeignClientInterface;



@RestController
@RequestMapping("/price")
public class PriceController {
	
	@Autowired
    private PriceServiceImpl service;
	
	private FeignClientInterface feign;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(PriceController.class);

    @RequestMapping("/getAllPrice")
    public List<Price> getAllPrices(){
    	LOGGER.info("inside class !!! PriceController, method!!!: getAllItems");
        return service.getAllPrices();
    }

    @GetMapping("/getPrice/{id}")
    
    public Price getPrice(@PathVariable int id){
    	LOGGER.info("inside class !!! PriceController, method!!!: getItem");
        return service.getPrice(id);
    }

    @PostMapping("/addPrice")
    public String addPrice( @RequestBody Price body) {
    	LOGGER.info("inside class !!! PriceController, method!!!: addItem");
    	return service.addPrice(body)+"New Details added successfully";
    }
    
    @DeleteMapping("/deletePrice/{id}")
    public void deletePrice(@PathVariable int id){
    	LOGGER.info("inside class !!! PriceController, method!!!: deleteItem");
    		service.deletePrice(id);
        
    }
    @GetMapping("/Health")
    public String HealthCheck() {
    	LOGGER.info("Health check");
    	return "Status : up ";
    }

    @RequestMapping("/getAllItems")
    public List<Item> getAllItems(){
    	LOGGER.info("inside class !!! PriceController, method!!!: getAllItems");
        return service.getAllItems();
    }
    
    @GetMapping("/getItem/{id}")
    public Item getItem(@PathVariable int id){
    	LOGGER.info("inside class !!! PriceController, method!!!: getItem");
        return service.getItem(id);
    }

    @PostMapping("/items")
    public String addItem( @RequestBody Item id) {
    	LOGGER.info("inside class !!! PriceController, method!!!: addItem");
    	return service.addItem(id)+"New Details added successfully";
    }
    
    @DeleteMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable int id){
    	LOGGER.info("inside class !!! PriceController, method!!!: deleteItem");
    	return service.deleteItem(id);
        
    }
    
    @RequestMapping("/getAllItemsFeign")
    public List<Item> getAllItemsFeign(){
    	LOGGER.info("inside class !!! PriceController, method!!!: getAllItems");
        return service.getAllItemsFeign();
    }
    
}
