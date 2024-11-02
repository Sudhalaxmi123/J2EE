package com.qn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qn.moadel.Student;


public class AddResult extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		
		String name = request.getParameter("name");
		
		int marks1 = Integer.parseInt(request.getParameter("marks1"));
		int marks2 = Integer.parseInt(request.getParameter("marks2"));
		int marks3 = Integer.parseInt(request.getParameter("marks3"));
		
		Student tempStudent = new Student();
		tempStudent.setId(id);
		tempStudent.setName(name);
		tempStudent.setMarks1(marks1);
		tempStudent.setMarks2(marks2);
		tempStudent.setMarks3(marks3);
		int rows = tempStudent.addResult();
		if(rows == 1) {
			response.sendRedirect("/add-result-mvn/addResultSuccess.html");
			
		}else {
			response.sendRedirect("/add-result-mvn/addResultFailure.html");
		}
		
		
	}
}
	