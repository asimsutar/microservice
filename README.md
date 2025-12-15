# Employee – Laptop Microservices 🚀  
(Spring Boot | OpenFeign | MySQL)

## 📌 Project Overview
This project demonstrates a basic microservices architecture using Spring Boot and OpenFeign for inter-service communication.

The system consists of two independent microservices:
- Employee Service – manages employee data
- Laptop Service – manages laptop data

An employee can be assigned a laptop using Feign client communication.

---

## 🧩 Microservices Details

### 🟦 Employee Service
- Port: 9090
- Responsibilities:
  - Add employees
  - Assign laptops to employees
  - Uses OpenFeign to call Laptop Service
- Database: MySQL

### 🟩 Laptop Service
- Port: 9023
- Responsibilities:
  - Manage laptop inventory
  - Validate laptop availability
  - Handle laptop assignment
- Database: MySQL

---

## 🔄 Architecture Flow

Client  
↓  
Employee Service  
↓ (Feign Client)  
Laptop Service  
↓  
Laptop Assigned  
↓  
Employee Updated with Laptop ID  

---

## 🚀 Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- Spring Cloud OpenFeign
- Hibernate
- MySQL
- REST APIs
- Maven
- Git & GitHub

---

## 📡 API Endpoint Example

Assign Laptop to Employee:

POST /employees/{employeeId}/assign-laptop/{laptopId}

Sample Response:
{
  "id": 1,
  "name": "Asim",
  "laptopId": 5
}

---

## ⚠️ Exception Handling
- Global exception handling using @RestControllerAdvice
- Custom exceptions:
  - EmployeeNotFoundException
  - LaptopNotFoundException
- Feign exceptions handled and mapped to domain-specific errors
- Consistent JSON error response format

---

## ▶️ How to Run the Project
1. Start MySQL Server
2. Create required databases
3. Run Laptop Service first
4. Run Employee Service
5. Test APIs using Postman

---

## 📂 Project Structure

employee-microservice  
├── employee-service  
├── laptop-service  
└── README.md  

---

## 🧠 Key Learning Outcomes
- Microservices communication using OpenFeign
- Exception handling across microservices
- Clean layered architecture
- REST API design
- Git & GitHub version control

---

## 👨‍💻 Author
Asim Sutar  
Java Backend Developer  
Spring Boot | Microservices | REST APIs
