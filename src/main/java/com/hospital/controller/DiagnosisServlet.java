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
@WebServlet("/DiagnosisServlet")
public class DiagnosisServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String patient = request.getParameter("patient");
        String details = request.getParameter("details");

        if (patient == null || patient.isEmpty() ||
            details == null || details.isEmpty()) {

            response.sendRedirect("diagnosis.jsp?error=Please+fill+all+fields");
            return;
        }

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO diagnosis(patient_name, details) VALUES (?, ?)")) {

            ps.setString(1, patient);
            ps.setString(2, details);
            ps.executeUpdate();

            response.sendRedirect("diagnosis.jsp?success=Diagnosis+saved");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("diagnosis.jsp?error=Something+went+wrong");
        }
    }
}
