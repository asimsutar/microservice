package com.tcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.entity.Laptop;
import com.tcs.exeption.LaptopNotFoundException;
import com.tcs.service.LaptopService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/laptops")
public class LaptopController {
	
	@Autowired
	LaptopService service;
	
	@PostMapping
	public ResponseEntity<Laptop> addLaptop(@RequestBody Laptop laptop) {
		
		
		return new ResponseEntity<Laptop>(service.addLaptop(laptop), HttpStatus.CREATED);
	}
		
	@GetMapping("/all")
	public ResponseEntity<List<Laptop>> getallLaptop() {
		return ResponseEntity.ok(service.getAllLaptop());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Laptop> getLaptopById(@PathVariable Long id) throws LaptopNotFoundException{
		return ResponseEntity.ok(service.getLaptopById(id));
	}
	
	
}
