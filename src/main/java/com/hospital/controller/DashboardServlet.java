package com.hospital.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.hospital.util.DBConnection;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int doctors = 0;
        int patients = 0;
        int appointments = 0;
        int diagnosis = 0;
        int prescriptions = 0;
        int medicines = 0;
        int accounts = 0;

        try (Connection con = DBConnection.getConnection()) {

            doctors = getCount(con, "doctors");
            patients = getCount(con, "patients");
            appointments = getCount(con, "appointments");
            diagnosis = getCount(con, "diagnosis");
            prescriptions = getCount(con, "prescription");
            medicines = getCount(con, "medical_store");
            accounts = getCount(con, "accounts");

            request.setAttribute("doctors", doctors);
            request.setAttribute("patients", patients);
            request.setAttribute("appointments", appointments);
            request.setAttribute("diagnosis", diagnosis);
            request.setAttribute("prescriptions", prescriptions);
            request.setAttribute("medicines", medicines);
            request.setAttribute("accounts", accounts);

            request.getRequestDispatcher("dashboard.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("dashboard.jsp?error=Something+went+wrong");
        }
    }

    private int getCount(Connection con, String table) throws Exception {

        int count = 0;

        try (PreparedStatement ps =
                     con.prepareStatement("SELECT COUNT(*) FROM " + table);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt(1);
            }
        }
        return count;
    }
}
