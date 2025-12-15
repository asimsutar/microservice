package com.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entity.Laptop;
import com.tcs.exeption.LaptopNotFoundException;
import com.tcs.repository.LaptopRepository;
@Service
public class LaptopServiceImplement implements LaptopService {
	
	@Autowired
	LaptopRepository laptopRepository;
	@Override
	public Laptop addLaptop(Laptop laptop) {
		
		return laptopRepository.save(laptop);
	}

	@Override
	public List<Laptop> getAllLaptop() {
		
		return laptopRepository.findAll();
	}

	@Override
	public Laptop getLaptopById(Long id) throws LaptopNotFoundException {
		
		return laptopRepository.
				findById(id).
					orElseThrow(()-> 
						new LaptopNotFoundException("Laptop Not Found with Id "+id));
	}

}
