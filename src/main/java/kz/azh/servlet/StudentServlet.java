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

    	String crud = (request.getParameter("crud") !=null && !request.getParameter("crud").isEmpty()) ? request.getParameter("crud") : "";
		String id = (request.getParameter("id") !=null && !request.getParameter("id").isEmpty()) ? request.getParameter("id") : "";
    	String name = (request.getParameter("name") !=null && !request.getParameter("name").isEmpty()) ? request.getParameter("name") : "";
    	String age = (request.getParameter("age") !=null && !request.getParameter("age").isEmpty()) ? request.getParameter("age") : "";
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/success.jsp"); 
		ArrayList<Student> students;
		Student student;
		Long _id;
    	
    	switch(crud){
    		case "create":
        		rd = request.getRequestDispatcher("/jsp/addStudent.jsp");
            	request.setAttribute("title", "Добавить студента");   
    		break;
    		case "add":
    			_id = Long.parseLong(id);
        		StudentDAO.addStudent(_id, name, age);
    	    	students = StudentDAO.getByName("");
    	    	request.setAttribute("title", "Список студентов");   
    	    	request.setAttribute("students", students);	 
    		break;
    		case "delete":
    			_id = Long.parseLong(id);
    			StudentDAO.deleteStudent(_id);
    	    	students = StudentDAO.getByName("");
    	    	request.setAttribute("title", "Список студентов");   
    	    	request.setAttribute("students", students);	 
    		break;
    		case "update":
    			_id = Long.parseLong(id);
    			student = StudentDAO.getById(_id); 
        		rd = request.getRequestDispatcher("/jsp/updateStudent.jsp");
    	    	request.setAttribute("title", "Редактирование студента"); 
    	    	request.setAttribute("student", student);	 
    		break;
    		case "save":
    			_id = Long.parseLong(id);
        		StudentDAO.updateStudent(_id, name, age);
    	    	students = StudentDAO.getByName("");
    	    	request.setAttribute("title", "Список студентов");   
    	    	request.setAttribute("students", students);	
    			break;
    		default:
    	    	students = StudentDAO.getByName(name);
    	    	request.setAttribute("title", "Список студентов");   
    	    	request.setAttribute("students", students);	    			
    		break;    		
    	}
    	if(rd != null)
    		rd.forward(request, response);
	}

}
