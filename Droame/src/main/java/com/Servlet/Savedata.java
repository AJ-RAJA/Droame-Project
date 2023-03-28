package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Customer;
import com.helper.FactoryProvider;

public class Savedata extends HttpServlet {
	/*
		A Servlet class designed to save data 
		When the Data is Being Inserted
		*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println("It is started");
			String fName = request.getParameter("fname");
			String lName = request.getParameter("lname");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String location = request.getParameter("selectin");
			String drone = request.getParameter("shots");
			Customer customer = new Customer(fName, lName, phone, email, address, new Date(), location, drone);
			Session session = FactoryProvider.getFactory().openSession();
			Transaction tx = session.beginTransaction();

			/*
			 * Validation for proper Fields in case Any Data isn't Inserted
			 */
			boolean f = Validation.validate(request, response);
			if (f) {
				session.save(customer);
				tx.commit();
				session.close();
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<h1 style='text-align:center;'>Booking is done successfully </h1>");
				out.println("<h1 style='text-align:center;'><a href='AllBooking.jsp'>View All Bookings</a></h1>");
			} else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<h1 style='text-align:center;'>Add Proper Fields</h1>");
				out.println("<h1 style='text-align:center;'><a href='Add_Booking.jsp'>Back</a></h1>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
