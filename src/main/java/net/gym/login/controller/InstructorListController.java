package net.gym.login.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gym.login.dao.InstructorDao;
import net.gym.login.model.Instructor;

/**
 * Servlet implementation class InstructorListController
 */
@WebServlet("/")
public class InstructorListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InstructorListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	private InstructorDao instructorDao;

	public void init() {
		instructorDao = new InstructorDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {

			switch (action) {
			case "/delete":
				deleteTodo(request, response);
				break;
			case "/edit":
				editTodo(request, response);
				break;
			case "/update":
				updateTodo(request, response);
				break;
			case "/InstructorListController":
				ListTodo(request, response);
				break;
			default:

				break;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void ListTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		try {
			List<Instructor> instructors = instructorDao.queryInstructor();
			request.setAttribute("instructors", instructors);
			RequestDispatcher dispatcher = request.getRequestDispatcher("instructorlist.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void editTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
//
//		String name = request.getParameter("name");
//		String gender = request.getParameter("gender");
//		Instructor updateTodo = new Instructor();
//		updateTodo.setId(id);
//		updateTodo.setGender(gender);
//		updateTodo.setName(name);
//		instructorDao.updateTodo(updateTodo);

//		response.sendRedirect("/GYM/InstructorListController");

		Instructor instructor = null;
		try {
			instructor = instructorDao.queryInstructor(id);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

//		RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");

		request.setAttribute("instructor", instructor);
		try {
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} catch (ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	private void updateTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		Instructor instructor = new Instructor();
		instructor.setId(id);
		instructor.setGender(gender);
		instructor.setName(name);
		instructorDao.updateTodo(instructor);
		response.sendRedirect("/GYM/InstructorListController");
	}

	private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		instructorDao.deleteTodo(id);
		response.sendRedirect("/GYM/InstructorListController");
	}

}
