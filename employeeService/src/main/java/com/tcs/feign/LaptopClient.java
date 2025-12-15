package com.tcs.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcs.dto.LaptopDTO;

@FeignClient(name = "laptopservice",url = "http://localhost:9023")
public interface LaptopClient {
	@GetMapping("/laptops/{id}")
	LaptopDTO getlaptop(@PathVariable Long id);
}
