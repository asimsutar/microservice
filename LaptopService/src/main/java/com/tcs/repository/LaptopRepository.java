package com.tcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.entity.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {

}
