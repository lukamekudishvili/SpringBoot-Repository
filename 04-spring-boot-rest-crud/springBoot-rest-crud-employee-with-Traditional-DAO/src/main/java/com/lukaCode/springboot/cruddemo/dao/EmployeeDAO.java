package com.lukaCode.springboot.cruddemo.dao;

import com.lukaCode.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int theId);
}
