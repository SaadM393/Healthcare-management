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
@WebServlet("/MedicalStoreServlet")
public class MedicalStoreServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String medicine = request.getParameter("medicine");
        String qtyStr = request.getParameter("qty");

        if (medicine == null || medicine.isEmpty() ||
            qtyStr == null || qtyStr.isEmpty()) {

            response.sendRedirect("medicalStore.jsp?error=Please+fill+all+fields");
            return;
        }

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO medical_store(medicine_name, quantity) VALUES (?, ?)")) {

            ps.setString(1, medicine);
            ps.setInt(2, Integer.parseInt(qtyStr));
            ps.executeUpdate();

            response.sendRedirect("medicalStore.jsp?success=Stock+added");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("medicalStore.jsp?error=Something+went+wrong");
        }
    }
}
