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

@WebServlet("/NewpatientServlet")
public class NewpatientServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // GET → JSP open
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/newPatient.jsp");
    }

    // POST → Form submit
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        String disease = request.getParameter("disease");

        // Validation
        if (name == null || name.trim().isEmpty()
                || ageStr == null || ageStr.trim().isEmpty()
                || disease == null || disease.trim().isEmpty()) {

            response.sendRedirect(
                request.getContextPath() + "/newPatient.jsp?error=Please+fill+all+fields"
            );
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            response.sendRedirect(
                request.getContextPath() + "/newPatient.jsp?error=Invalid+age"
            );
            return;
        }

        // DB Insert
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO patients(name, age, disease) VALUES (?, ?, ?)")) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, disease);
            ps.executeUpdate();

            response.sendRedirect(
                request.getContextPath() + "/newPatient.jsp?success=Patient+added+successfully"
            );

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(
                request.getContextPath() + "/newPatient.jsp?error=Database+error"
            );
        }
    }
}
