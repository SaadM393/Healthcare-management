<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
        }

        .grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 20px;
            max-width: 900px;
            margin: auto;
        }

        .card {
            background: white;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            text-align: center;
        }

        .card h3 {
            margin: 0;
            color: #555;
        }

        .card p {
            font-size: 32px;
            margin-top: 10px;
            color: #4CAF50;
            font-weight: bold;
        }

        .message {
            max-width: 500px;
            margin: 0 auto 20px;
            padding: 10px;
            border-radius: 4px;
            text-align: center;
        }

        .error {
            background-color: #f8d7da;
            color: #721c24;
        }
    </style>
</head>

<body>

<h2>Hospital Dashboard</h2>

<%
    String error = request.getParameter("error");
    if (error != null) {
%>
    <div class="message error"><%= error %></div>
<%
    }
%>

<div class="grid">

    <div class="card">
        <h3>Doctors</h3>
        <p><%= request.getAttribute("doctors") %></p>
    </div>

    <div class="card">
        <h3>Patients</h3>
        <p><%= request.getAttribute("patients") %></p>
    </div>

    <div class="card">
        <h3>Appointments</h3>
        <p><%= request.getAttribute("appointments") %></p>
    </div>

    <div class="card">
        <h3>Diagnosis</h3>
        <p><%= request.getAttribute("diagnosis") %></p>
    </div>

    <div class="card">
        <h3>Prescriptions</h3>
        <p><%= request.getAttribute("prescriptions") %></p>
    </div>

    <div class="card">
        <h3>Medicines</h3>
        <p><%= request.getAttribute("medicines") %></p>
    </div>

    <div class="card">
        <h3>Accounts</h3>
        <p><%= request.getAttribute("accounts") %></p>
    </div>

</div>

</body>
</html>
