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
    	
    	String name = (request.getParameter("name") !=null && !request.getParameter("name").isEmpty()) ? request.getParameter("name") : "";
    	boolean newStud = (request.getParameter("new") != null && !request.getParameter("new").isEmpty()) ? true : false;
    	
    	ArrayList<Student> students = StudentDAO.getByName(name);
    	request.setAttribute("title", "Сптсок студентов");
    	request.setAttribute("students", students);
    	RequestDispatcher rd = request.getRequestDispatcher("/jsp/success.jsp");
    	if(rd != null)
    		rd.forward(request, response);
	}

}
