package net.javasguides.registration.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.a.NativeConstants.StringLengthDataType;

import net.javasguides.registration.dao.CustomerDao;
import net.javasguides.registration.model.Customer;

/**
 * Servlet implementation class customerServlet
 */
@WebServlet("/listCustomer")
public class CustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomerDao customerDao = new CustomerDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	private void setUp()
	{
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Customer> customerList;
		try {
			customerList = customerDao.selectAllCustomer();
			request.setAttribute("listCustomer", customerList);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customerList.jsp");
		dispatcher.forward(request, response);
		/*
		List < Todo > listTodo = todoDAO.selectAllTodos();
        request.setAttribute("listTodo", listTodo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-list.jsp");
        dispatcher.forward(request, response);
        */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
