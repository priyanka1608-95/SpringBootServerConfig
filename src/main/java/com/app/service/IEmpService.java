package com.app.service;

import java.util.List;

import com.app.pojo.Employee;


public interface IEmpService 
{
	public List<Employee> getAllEmp();
	public Employee addEmp(Employee emp);
	public void deleteEmp(int id);
	public Employee updateEmp(Employee emp);
	public Employee getEmpDetails(int id);


}
