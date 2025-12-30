<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Doctors Management</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f2f2f2; padding: 20px; }
        .container { max-width: 500px; margin: auto; background: white; padding: 20px;
                     border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        input[type=text] { width: 100%; padding: 10px; margin: 10px 0;
                           border-radius: 4px; border: 1px solid #ccc; }
        button { padding: 10px 20px; background-color: #4CAF50; color: white;
                 border: none; border-radius: 4px; cursor: pointer; }
        button:hover { background-color: #45a049; }
        .message { padding: 10px; margin-bottom: 15px; border-radius: 4px; }
        .success { background-color: #d4edda; color: #155724; }
        .error { background-color: #f8d7da; color: #721c24; }
    </style>
</head>

<body>
<div class="container">
    <h2>Add Doctor</h2>

    <% 
        String success = request.getParameter("success");
        String error = request.getParameter("error");
    %>

    <% if (success != null) { %>
        <div class="message success"><%= success %></div>
    <% } %>

    <% if (error != null) { %>
        <div class="message error"><%= error %></div>
    <% } %>

    <!-- ✅ SINGLE FORM ONLY -->
    <form action="<%=request.getContextPath()%>/DoctorsServlet" method="post">

        <label>Doctor Name:</label>
        <input type="text" name="name" placeholder="Enter doctor's name" required>

        <label>Specialization:</label>
        <input type="text" name="spec" placeholder="Enter specialization" required>

        <button type="submit">Add Doctor</button>
    </form>
</div>
</body>
</html>
