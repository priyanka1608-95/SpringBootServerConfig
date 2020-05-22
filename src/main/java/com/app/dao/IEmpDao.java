package com.app.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IEmpDao extends JpaRepository<Employee,Integer>, PagingAndSortingRepository<Employee,Integer>
{

}
