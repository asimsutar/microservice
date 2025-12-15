package com.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.dto.EmployeeLaptoResponse;
import com.tcs.entity.Employee;
import com.tcs.exception.EmployeeNotFoundException;
import com.tcs.exception.LaptopAlreadyAssignedException;
import com.tcs.exception.LaptopNotFoundException;
import com.tcs.feign.LaptopClient;
import com.tcs.repository.EmployeeRepository;

import feign.FeignException;

@Service
public class EmployeeServiceImplements implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	LaptopClient laptopClient;
	
	@Override
	public Employee addEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee assignLaptop(Long id, Long laptopId) throws EmployeeNotFoundException, LaptopNotFoundException, LaptopAlreadyAssignedException {
		//getting Employee
		Employee employee = employeeRepository.
					findById(id).
						orElseThrow(()->
							new EmployeeNotFoundException("Employee Not Found With Id "+id));
		
		try {
			//getLaptop
			laptopClient.getlaptop(laptopId);
		} catch (FeignException.NotFound e) {
			
			throw new LaptopNotFoundException("Laptop Not found With Id "+laptopId);
		}
		
		//check laptop already Assigned
		boolean laptopAlreadyAssigned = employeeRepository.existsByLaptopId(laptopId);
		if(laptopAlreadyAssigned) {
			throw new LaptopAlreadyAssignedException("Laptop Already Assigned with id "+laptopId);
		}
		employee.setLaptopId(laptopId);
		
		return employeeRepository.save(employee);
	}

	@Override
	public EmployeeLaptoResponse getEmployeewithId(Long id) throws EmployeeNotFoundException {
			
		//getting Employee
		Employee employee = employeeRepository.
				findById(id).
						orElseThrow(()->
								new EmployeeNotFoundException("Employee Not Found With Id "+id));
		
		EmployeeLaptoResponse employeeLaptoResponse = new EmployeeLaptoResponse();
		employeeLaptoResponse.setId(employee.getId());
		employeeLaptoResponse.setName(employee.getName());
		employeeLaptoResponse.setEmail(employee.getEmail());
		
		if(employee.getLaptopId() != null) {
			employeeLaptoResponse.setLaptop(laptopClient.getlaptop(id));
		}
		return employeeLaptoResponse;
	}

	@Override
	public List<EmployeeLaptoResponse> getAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

}
