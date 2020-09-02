package com.hans.srs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hans.srs.entity.Employee;
import com.hans.srs.entity.EmployeeDetails;
import com.hans.srs.exception.ErrorCode;
import com.hans.srs.exception.SRSException;
import com.hans.srs.model.SRSResponse;
import com.hans.srs.model.SRSStatus;
import com.hans.srs.model.employee.EmployeeInfo;
import com.hans.srs.model.employee.EmployeeRequest;
import com.hans.srs.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping
	public ResponseEntity<SRSResponse> saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
		Employee employee = new Employee();
		employee.setFirstName(employeeRequest.getFirstName());
		employee.setLastName(employeeRequest.getLastName());
		StringBuilder emailBuilder = new StringBuilder(employeeRequest.getFirstName().substring(0, 1));
		emailBuilder.append(employeeRequest.getLastName()).append("@hans.com");
		employee.setEmailId(emailBuilder.toString());
		
		EmployeeDetails empDetails = new EmployeeDetails();
		empDetails.setAddressLine1(employeeRequest.getAddressLine1());
		empDetails.setAddressLine2(employeeRequest.getAddressLine2());
		empDetails.setStreet(employeeRequest.getStreet());
		empDetails.setBloodGroup(employeeRequest.getBloodGroup());
		empDetails.setArea(employeeRequest.getArea());
		empDetails.setCity(employeeRequest.getCity());
		empDetails.setContactNumber(employeeRequest.getPrimaryContactNumber());
		
		employee.setEmployeeDetails(empDetails);
		
		Employee employee2 = employeeRepository.save(employee);
		System.out.println("Saving employee done ------------------------- >>>");
		
		SRSResponse response = new SRSResponse(SRSStatus.SUCCESS, "Employee created successfully!!, with id " + employee2.getId());
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{emailId:.+}")
	public ResponseEntity<EmployeeInfo> getEmployeeByEmailId(@PathVariable("emailId") String emailId) {
		Optional<Employee> employee =  employeeRepository.getByEmailId(emailId);
		final EmployeeInfo employeeInfo = new EmployeeInfo();
		/*
		 * if(employee.isPresent()) { Employee emp = employee.get();
		 * employeeInfo.setFirstName(emp.getFirstName());
		 * employeeInfo.setId(emp.getId()); employeeInfo.setLastName(emp.getLastName());
		 * } else { throw new SRSException("No employee found with email id " + emailId,
		 * HttpStatus.NOT_FOUND); }
		 */
		employee.orElseThrow(() -> new SRSException("No employee found with email id " + emailId, HttpStatus.NOT_FOUND, ErrorCode.USER_NOT_FOUND));
		employee.ifPresent(emp  -> {
			employeeInfo.setFirstName(emp.getFirstName());
			employeeInfo.setId(emp.getId());
			employeeInfo.setLastName(emp.getLastName());
			System.out.println("----------------------------------------------------");
			EmployeeDetails empDetails = emp.getEmpDetails();
			employeeInfo.setAddressLine1(empDetails.getAddressLine1());
		});
		return ResponseEntity.ok(employeeInfo);
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
}
