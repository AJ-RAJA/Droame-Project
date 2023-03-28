package com.Servlet;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*Validation Class To validate All the data is Inserted
while Booking
*/

public class Validation extends HttpServlet {
	static boolean f = true;

	public static boolean validate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String location = request.getParameter("selectin");
		String drone = request.getParameter("shots");
		if (fName != null && lName != null && phone != null && email != null && email != null && address != null
				&& location != null && drone != null) {
			f = true;
		}
		return f;
	}
}
