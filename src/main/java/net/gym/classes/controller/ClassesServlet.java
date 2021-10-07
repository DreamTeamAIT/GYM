package net.gym.classes.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.gym.classes.dao.ClassDao;
import net.gym.classes.model.Classes;

/**
 * Servlet implementation class ClassesServlet
 */
@WebServlet("/registerClasses")
public class ClassesServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
    private ClassDao classDao;

    public void init() {
        classDao = new ClassDao();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/classRegister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String classname = request.getParameter("classname");
	     String instructor = request.getParameter("instructor");
	     String classtime = request.getParameter("classtime");
	     

	     Classes classes = new Classes();
	     classes.setClassname(classname);
	     classes.setInstructor(instructor);
	     classes.setClasstime(classtime);
	   
	        try {
	            classDao.registerClass(classes);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/classesInsertedSuccessfully.jsp");
			dispatcher.forward(request, response);
	 }
}


