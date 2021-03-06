package com.app.service;

import java.util.List;

import com.app.pojo.EmpPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	@Cacheable(value = "Emp-Cache")
	@Override
	public Page<Employee> getAllPaginatedEmployees(EmpPageRequest empPageRequest)
	{
		Page<Employee> page = null;
		try {
			Thread.sleep(10000);
			page = dao.findAll(PageRequest.of(empPageRequest.getPageNo(),
					empPageRequest.getPageSize(), Sort.by(empPageRequest.getName()).ascending()));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return page;
	}


}
