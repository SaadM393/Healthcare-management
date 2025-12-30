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

@WebServlet("/PrescriptionServlet")
public class PrescriptionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String patient = request.getParameter("patient");
        String doctor = request.getParameter("doctor");
        String medicines = request.getParameter("medicines");

        if (patient == null || doctor == null || medicines == null ||
            patient.isEmpty() || doctor.isEmpty() || medicines.isEmpty()) {

            response.sendRedirect("prescription.jsp?error=Fill+all+fields");
            return;
        }

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO prescription(patient, doctor, medicines) VALUES (?,?,?)"
            );

            ps.setString(1, patient);
            ps.setString(2, doctor);
            ps.setString(3, medicines);

            ps.executeUpdate();

            response.sendRedirect("prescription.jsp?success=Saved+successfully");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("prescription.jsp?error=DB+Error");
        }
    }
}
