package com.Servlet;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validation extends HttpServlet {

    public static boolean validate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fName = request.getParameter("fname");
        String lName = request.getParameter("lname");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String location = request.getParameter("selectin");
        String drone = request.getParameter("shots");

        return !(fName.isEmpty() || lName.isEmpty() || email.isEmpty() || address.isEmpty() || location.isEmpty() || drone.isEmpty());
    }
}
