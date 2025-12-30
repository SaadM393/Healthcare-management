package com.hospital.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.hospital.util.DBConnection;

@WebServlet("/AccountsServlet")
public class AccountsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String patient = request.getParameter("patient");
        String amountStr = request.getParameter("amount");

        if (patient == null || patient.isEmpty() || amountStr == null || amountStr.isEmpty()) {
            response.sendRedirect("accounts.jsp?error=Please+fill+all+fields");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {
            response.sendRedirect("accounts.jsp?error=Invalid+amount");
            return;
        }

        // Use try-with-resources to auto-close resources
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO accounts(patient_name, amount) VALUES (?, ?)")) {

            ps.setString(1, patient);
            ps.setDouble(2, amount);
            ps.executeUpdate();

            response.sendRedirect("accounts.jsp?success=Account+saved+successfully");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("accounts.jsp?error=Something+went+wrong");
        }
    }
}
