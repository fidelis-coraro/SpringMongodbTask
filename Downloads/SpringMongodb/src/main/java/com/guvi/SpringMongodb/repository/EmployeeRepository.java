package com.guvi.SpringMongodb.repository;


import com.guvi.SpringMongodb.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
