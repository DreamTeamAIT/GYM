package net.javasguides.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javasguides.registration.dao.CustomerDao;
import net.javasguides.registration.model.Customer;

/**
 * Servlet implementation class customerServlet
 */
@WebServlet("/updateCustomer")
public class CustomerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String idString;
	private CustomerDao customerDao = new CustomerDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		idString = request.getParameter("id");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customerUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String id = idString;
		try 
		{
			//We want to check for password and email duplicates, and if there are we want to stop the page and display an error
			//If it passes, we want to register the customer.
			Customer customer = new Customer("",firstName, lastName, password, email);
			
			customerDao.updateCustomer(customer, id);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
