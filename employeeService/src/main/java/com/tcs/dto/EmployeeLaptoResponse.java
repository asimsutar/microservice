package com.tcs.dto;

import lombok.Data;

@Data
public class EmployeeLaptoResponse {
	private Long id;
	private String name;
	private String email;
	private LaptopDTO laptop;
}
