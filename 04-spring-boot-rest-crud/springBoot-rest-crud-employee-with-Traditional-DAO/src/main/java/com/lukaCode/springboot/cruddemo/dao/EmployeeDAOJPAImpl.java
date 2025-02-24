package com.lukaCode.springboot.cruddemo.dao;

import com.lukaCode.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJPAImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public List<Employee> findAll(){
        TypedQuery<Employee> queryForFindAll=entityManager.createQuery("FROM Employee",Employee.class);
        return queryForFindAll.getResultList();
    }

    @Override
    public Employee findById(int id){
        Employee employee=entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public Employee save(Employee employee){
        Employee tempEmployee=entityManager.merge(employee);

        return tempEmployee;
    }

    @Override
    public void deleteById(int theId) {
        entityManager.remove(findById(theId));
    }
}
