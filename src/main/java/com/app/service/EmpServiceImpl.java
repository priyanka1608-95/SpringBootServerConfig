package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IEmpDao;
import com.app.pojo.Employee;


@Repository
@Transactional
public class EmpServiceImpl implements IEmpService
{
	@Autowired
	IEmpDao dao;
	
	@Override
	public List<Employee> getAllEmp() {
		
		return dao.findAll();
	}

	@Override
	public Employee addEmp(Employee emp) {
		
		return dao.save(emp);
	}

	@Override
	public void deleteEmp(int eid) {
		dao.deleteById(eid);
		
	}

	@Override
	public Employee updateEmp( Employee emp)
	{
		Employee e=dao.findById(emp.getId()).get();

		e.setName(emp.getName());
		e.setSalary(emp.getSalary());

		return dao.save(e);

	}

	@Override
	public Employee getEmpDetails(int id) {
		return dao.findById(id).get();
	}



}
