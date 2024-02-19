package com.example.quan_ly_hoc_sinh.controller;

import com.example.quan_ly_hoc_sinh.model.Student;
import com.example.quan_ly_hoc_sinh.service.IServiceStudent;
import com.example.quan_ly_hoc_sinh.service.ServiceStudent;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceStudent", urlPatterns = "/student")
public class ControllerStudent extends HttpServlet {
   private static final  IServiceStudent iServiceStudent = new ServiceStudent();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                showFormCreate(req, resp);
                break;
            default:
                showlist(req,resp);
        }
    }

    private void showlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        List<Student> students = iServiceStudent.findAll();
        req.setAttribute("ds", students);
        dispatcher.forward(req,resp);
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":

                createStudent(req, resp);
                break;
        }
    }

    private void createStudent(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        Student student = new Student(name, email,address);
        iServiceStudent.save(student);
        try {
            resp.sendRedirect("/student");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    }

