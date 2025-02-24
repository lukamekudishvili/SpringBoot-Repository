package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//define as Repository, so Spring will get that this class is DAO(Data Access object) implementation
@Repository
public class StudentDAOImpl implements StudentDAO{
    //define field entityManager
    private EntityManager entityManager;

    //define constructor
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> queryForFindByLastName=
                entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
        queryForFindByLastName.setParameter("theData",lastName);
        return queryForFindByLastName.getResultList();
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> queryForFindAll=entityManager.createQuery("FROM Student",Student.class);
        return queryForFindAll.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        entityManager.remove(findById(id));
    }

    @Override
    @Transactional
    public int deleteAll() {
        int deletedRowNum=entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return deletedRowNum;
    }
}
