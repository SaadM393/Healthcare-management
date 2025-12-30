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

@WebServlet("/DoctorsServlet")
public class DoctorsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String spec = request.getParameter("spec"); // make sure this matches your form input

        if (name == null || name.isEmpty() || spec == null || spec.isEmpty()) {
            response.sendRedirect("doctors.jsp?error=Please+fill+all+fields");
            return;
        }

        // Use try-with-resources to auto-close
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO doctors(name, specialization) VALUES (?, ?)")) {

            ps.setString(1, name);
            ps.setString(2, spec);
            ps.executeUpdate();

            response.sendRedirect("doctors.jsp?success=Doctor+added+successfully");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("doctors.jsp?error=Something+went+wrong");
        }
    }
}
