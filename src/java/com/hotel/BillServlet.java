/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hotel;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */

public class BillServlet extends HttpServlet {
    
    private List<Customer> customerlist=new ArrayList<>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get selected starter options
        String name=request.getParameter("custname");
        String contactStr = request.getParameter("custcontact");
         BigInteger contact = new BigInteger(contactStr);
         
       String bisleri = request.getParameter("Bisleri");
   
         
        
        String[] starterSelections = request.getParameterValues("starter");
       int  starterPrice=0;
       if (starterSelections != null) {
            for (String starter : starterSelections) {
                starterPrice += Integer.parseInt(starter);
            }
        }
          
         
        // Get selected veg option
        String[] vegSelection = request.getParameterValues("veg");
        int vegPrice=0;
         if (vegSelection != null) {
            for (String veg : vegSelection) {
                vegPrice += Integer.parseInt(veg);
            }
        }
       

        // Get selected non-veg option
        String[] nonVegSelection = request.getParameterValues("nonVeg");
        int nonVegPrice = 0;
            if (nonVegSelection != null) {
            for (String nonveg : nonVegSelection) {
                nonVegPrice += Integer.parseInt(nonveg);
            }
        }

        // Calculate total bill
        int totalBill = starterPrice + vegPrice + nonVegPrice;

        // Generate the response
        response.setContentType("text/html");
        
         //adding ifo to customer class
         Customer cust=new Customer(name,contact,totalBill+20);
         customerlist.add(cust);
         
         
       // Store the list in session
        List<Customer> customerList = (List<Customer>) request.getSession().getAttribute("customerlist");
        if (customerList == null) {
            customerList = new ArrayList<>();
            request.getSession().setAttribute("customerlist", customerList);
        }
        customerList.add(cust);
   
        
        if("yes".equals(bisleri))
        {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h5>customer name: " + name + "</h5>");
        out.println("<h5>customer contact: " +contact  + "</h5>");
        out.println("<h5> Total Bill: Rs. " + (totalBill+20)+ "</h5>");
        out.println("</body></html>");
        }
        else
        {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h5>customer name: " + name + "</h5>");
        out.println("<h5>customer contact: " +contact  + "</h5>");
        out.println("<h5> Total Bill: Rs. " + totalBill + "</h5>");
        out.println("</body></html>");
        }
        

        RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
        dispatcher.include(request,response);
     
    }
}

       


