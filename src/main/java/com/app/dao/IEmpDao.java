package com.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Employee;

public interface IEmpDao extends JpaRepository<Employee,Integer>
{
	
}
