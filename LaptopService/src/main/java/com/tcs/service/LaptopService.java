package com.tcs.service;

import java.util.List;

import com.tcs.entity.Laptop;
import com.tcs.exeption.LaptopNotFoundException;

public interface LaptopService {
	public Laptop addLaptop(Laptop laptop);
	public List<Laptop> getAllLaptop();
	public Laptop getLaptopById(Long id) throws LaptopNotFoundException;
}
