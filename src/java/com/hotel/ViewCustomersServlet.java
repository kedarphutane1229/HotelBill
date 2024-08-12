/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hotel;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ViewCustomersServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void  doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
       PrintWriter out = response.getWriter();

         // Retrieve the customer list from session
        List<Customer> customerList = (List<Customer>) request.getSession().getAttribute("customerlist");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Customer List</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Customer List</h1>");
        
        if (customerList != null && !customerList.isEmpty()) {
            out.println("<table border='1'>");
            out.println("<tr><th>Name</th><th>Contact</th><th>Total Bill</th></tr>");
            for (Customer customer : customerList) {
                out.println("<tr>");
                out.println("<td>" + customer.getName() + "</td>");
                out.println("<td>" + customer.getContactno() + "</td>");
                out.println("<td>" + customer.getTotalBill() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } else {
            out.println("<p>No customers found.</p>");
        }
        
        out.println("</body>");
        out.println("</html>");
        
    }

   
}
