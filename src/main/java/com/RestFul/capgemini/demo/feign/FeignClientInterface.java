package com.RestFul.capgemini.demo.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.RestFul.capgemini.demo.Entity.Item;

@FeignClient(name = "feign-client", url = "http://localhost:8080")
public interface FeignClientInterface {
	@GetMapping("/getAllItems")
	 List<Item> getAllItems();
}
