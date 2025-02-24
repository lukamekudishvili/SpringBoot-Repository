package com.lukaCode.springboot.cruddemo.dao;

import com.lukaCode.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //es ase mushaobs, ar unda aranairi kodi (ukve aris shesabamisi CRUD functional)
}
