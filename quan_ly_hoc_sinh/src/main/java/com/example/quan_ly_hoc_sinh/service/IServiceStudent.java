package com.example.quan_ly_hoc_sinh.service;

import com.example.quan_ly_hoc_sinh.model.Student;

import java.util.List;

public interface IServiceStudent {


     void save(Student student);


    List<Student> findAll();

}
