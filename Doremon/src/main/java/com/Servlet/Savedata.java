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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Session session = FactoryProvider.getFactory().openSession()) {
            String firstName = request.getParameter("fname");
            String lastName = request.getParameter("lname");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String location = request.getParameter("selectin");
            String drone = request.getParameter("shots");
            Customer customer = new Customer(firstName, lastName, phone, email, address, new Date(), location, drone);
            /*
            Validation for proper Fields in case Any Data isn't Inserted
            */
            boolean isValid = validateData(request, response);
            if (isValid) {
                Transaction transaction = session.beginTransaction();
                session.save(customer);
                transaction.commit();
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                StringBuilder builder = new StringBuilder();
                builder.append("<h1 style='text-align:center;'>Booking is done successfully </h1>");
                builder.append("<h1 style='text-align:center;'><a href='AllBooking.jsp'>View All Bookings</a></h1>");
                out.println(builder.toString());
            } else {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                StringBuilder builder = new StringBuilder();
                builder.append("<h1 style='text-align:center;'>Add Proper Fields</h1>");
                builder.append("<h1 style='text-align:center;'><a href='Add_Booking.jsp'>Back</a></h1>");
                out.println(builder.toString());
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /*
    A method to validate the form data
    */
    private boolean validateData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String location = request.getParameter("selectin");
        String drone = request.getParameter("shots");
        return !(firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty()
                || location.isEmpty() || drone.isEmpty());
    }
}
