package com.app.service;

import java.util.List;

import com.app.pojo.EmpPageRequest;
import com.app.pojo.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IEmpService 
{
	public List<Employee> getAllEmp();
	public Employee addEmp(Employee emp);
	public void deleteEmp(int id);
	public Employee updateEmp(Employee emp);
	public Employee getEmpDetails(int id);
	public Page<Employee> getAllPaginatedEmployees(EmpPageRequest empPageRequest);

}
