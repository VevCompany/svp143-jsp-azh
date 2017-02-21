package kz.azh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import kz.azh.dao.StudentDAO;
import kz.azh.model.*;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String id = (request.getParameter("id") !=null && !request.getParameter("id").isEmpty()) ? request.getParameter("id") : "";
    	String name = (request.getParameter("name") !=null && !request.getParameter("name").isEmpty()) ? request.getParameter("name") : "";
    	String age = (request.getParameter("age") !=null && !request.getParameter("age").isEmpty()) ? request.getParameter("age") : "";
    	boolean newStud = (request.getParameter("new") != null && !request.getParameter("new").isEmpty()) ? true : false;
    	
    	if(age!=null && !age.isEmpty()) 
    	{
    		Long _id = Long.parseLong(id);
    		StudentDAO.addStudent(_id, name, age);  
    		name = null;
    	}
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/jsp/success.jsp"); 
    	ArrayList<Student> students = StudentDAO.getByName(name);
    	request.setAttribute("title", "Список студентов");   
    	request.setAttribute("students", students);	
    	
    	if(newStud){
    		rd = request.getRequestDispatcher("/jsp/addStudent.jsp");
        	request.setAttribute("title", "Добавить студента");   	
		}    	
    	if(rd != null)
    		rd.forward(request, response);
	}

}
