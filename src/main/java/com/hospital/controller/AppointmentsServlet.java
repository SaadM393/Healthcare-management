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

@WebServlet("/AppointmentsServlet")
public class AppointmentsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String patient = request.getParameter("patient");
        String doctor = request.getParameter("doctor");
        String date = request.getParameter("date");

        if (patient == null || patient.isEmpty() ||
            doctor == null || doctor.isEmpty() ||
            date == null || date.isEmpty()) {

            response.sendRedirect("appointments.jsp?error=Please+fill+all+fields");
            return;
        }

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO appointments(patient_name, doctor_name, date) VALUES (?, ?, ?)")) {

            ps.setString(1, patient);
            ps.setString(2, doctor);
            ps.setString(3, date);
            ps.executeUpdate();

            response.sendRedirect("appointments.jsp?success=Appointment+booked");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("appointments.jsp?error=Something+went+wrong");
        }
    }
}
