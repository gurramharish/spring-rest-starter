package com.hans.srs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hans.srs.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	Optional<Employee> getByEmailId(String emailId);
	
	List<Employee> getByEmpDetailsBloodGroup(String bloodGroup);
}
