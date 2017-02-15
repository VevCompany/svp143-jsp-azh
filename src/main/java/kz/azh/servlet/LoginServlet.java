package kz.azh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kz.azh.model.Student;
import kz.azh.model.StudentList;
import kz.azh.model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
    private static final long serialVersionUID = 2116983427258983113L;
    
    private static final String PAGE_SUCCESS = "/jsp/success.jsp";
    private static final String PAGE_ERROR = "/jsp/error.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setAttribute("title", "Welcome");
    	
    	String login = request.getParameter("login");
    	String password = request.getParameter("password");
    	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
    	
    	if(login != null && password != null) {    		
    		User user = new User(login, password);
    		if(user.authValidate()) {
    			rd = request.getRequestDispatcher("/jsp/success.jsp");
    			request.setAttribute("title", "Main page");
    			request.setAttribute("user", user);
    		}else {
    			/*request.setAttribute("error", "Invalid login OR password");
    			rd = request.getRequestDispatcher(PAGE_ERROR);*/
    			System.out.println("ERROR");
    		}
    	}    	
    	rd.forward(request, response);

	}

}
