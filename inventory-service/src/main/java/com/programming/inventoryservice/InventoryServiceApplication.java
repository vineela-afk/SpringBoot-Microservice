package com.programming.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.programming.inventoryservice.model.Inventory;
import com.programming.inventoryservice.repository.InventoryRepository;
import com.programming.productservice.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRespository) {
		return args ->{
			Inventory inventory= new Inventory();
			inventory.setSkuCode("iphone_13");
			inventory.setQuantity(100);
			
			
			Inventory inventory1= new Inventory();
			inventory1.setSkuCode("iphone_13_red");
			inventory1.setQuantity(100);
			
			inventoryRespository.save(inventory);
			inventoryRespository.save(inventory1);
		};
	}

}
