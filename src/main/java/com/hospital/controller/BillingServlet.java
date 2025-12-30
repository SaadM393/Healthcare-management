package com.hospital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/generateBill")
public class BillingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String patient = request.getParameter("patient");
        String amount = request.getParameter("amount");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Bill Generated</h2>");
        out.println("<p>Patient: " + patient + "</p>");
        out.println("<p>Amount: ₹" + amount + "</p>");
        out.println("<a href='index.jsp'>Go Home</a>");
        out.println("</body></html>");
    }
}
