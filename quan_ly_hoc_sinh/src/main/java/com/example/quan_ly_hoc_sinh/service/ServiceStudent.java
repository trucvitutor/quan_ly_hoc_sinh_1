package com.example.quan_ly_hoc_sinh.service;

import com.example.quan_ly_hoc_sinh.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceStudent implements IServiceStudent{
    public static final String SELECT_FROM_STUDENT = "SELECT * FROM student";
    public static final String INSERT_INTO_STUDENT = "insert into student(name,email,address) values(?,?,?)";

    @Override
    public void save(Student student) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_INTO_STUDENT);
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Student> findAll() {
        List<Student> arrayLists=new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement=null;
        try {
            statement = connection.prepareStatement(SELECT_FROM_STUDENT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Student student = new Student(id, name, email, address);
                arrayLists.add(student);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return arrayLists;
    }
}
