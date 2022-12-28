package com.RestFul.capgemini.demo.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataBaseInitialiser {
	
	@Autowired JdbcTemplate jdbcTemplate;
	
	@Bean
    CommandLineRunner loadDatabase() {
        return new CommandLineRunner() {
             
            @Override
            public void run(String... args) throws Exception {
            
                
                jdbcTemplate.execute("create table price (PriceId int primary key, Price int )");
                 
                jdbcTemplate.execute("INSERT INTO `price` (`PriceId`, `Price`) VALUES (1, 50000);");
                 
                jdbcTemplate.execute("INSERT INTO `price` (`PriceId`, `Price`) VALUES (2, 35000);");
                 
                jdbcTemplate.execute("INSERT INTO `price` (`PriceId`, `Price`) VALUES (3, 65000);");
                
                jdbcTemplate.execute("INSERT INTO `price` (`PriceId`, `Price`) VALUES (4, 80000);");
            }
        };
    }


}
