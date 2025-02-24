package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findByLastName(String lastName);
    List<Student> findAll();
    void update(Student theStudent);
    void delete(Integer id);
    int deleteAll();

}
