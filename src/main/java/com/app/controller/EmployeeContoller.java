package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import com.app.pojo.EmpPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.pojo.Employee;
import com.app.service.IEmpService;

import javax.validation.Valid;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/employees")
public class EmployeeContoller 
{
	@Autowired
	IEmpService service;
	
	@GetMapping
	public ResponseEntity<?> getAllEmps()
	{
		List<Employee> emplist=new ArrayList<Employee>();
		emplist=service.getAllEmp();
		return new ResponseEntity<>(emplist,HttpStatus.OK);
	}
	
	@PostMapping(value = "/addEmp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addEmp(@RequestBody Employee emp)
	{
		 Employee e = service.addEmp(emp);

		System.out.println(emp.getName());
		return new ResponseEntity<>(e,HttpStatus.OK);
		
	}

	
	@DeleteMapping("/deleteEmp/{empId}")
	public void deleteEmp(@PathVariable int empId)
	{
		service.deleteEmp(empId);
	}

	@GetMapping("/getEmpById/{empid}")
	public ResponseEntity<?> getEmpById(@PathVariable int empid)
	{
		Employee e=service.getEmpDetails(empid);
		return new ResponseEntity<>(e,HttpStatus.OK);
	}

	@PutMapping("/updateEmp")
	public ResponseEntity<?> updateEmp(@RequestBody Employee emp)
	{

		Employee e=service.updateEmp(emp);
		return new ResponseEntity<>(e,HttpStatus.OK);
	}

	@PostMapping(value = "/getPaginatedEmps", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPaginatedEmployees(@Valid @RequestBody EmpPageRequest empPageRequest)
	{
		Page<Employee> page = service.getAllPaginatedEmployees(empPageRequest);
		return new ResponseEntity<>(page,HttpStatus.OK);
	}

	
}
