<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Patient</title>
    <style>
        body { font-family: Arial; background:#f2f2f2; padding:20px; }
        .container { max-width:500px; margin:auto; background:#fff; padding:20px;
            border-radius:8px; box-shadow:0 0 10px rgba(0,0,0,0.1); }
        input { width:100%; padding:10px; margin:8px 0; }
        input[type=submit] { background:#4CAF50; color:white; border:none; cursor:pointer; }
        .success { background:#d4edda; padding:10px; margin-bottom:10px; }
        .error { background:#f8d7da; padding:10px; margin-bottom:10px; }
    </style>
</head>
<body>

<div class="container">
    <h2>Add Patient</h2>

    <% String success = request.getParameter("success");
       String error = request.getParameter("error"); %>

    <% if(success != null){ %>
        <div class="success"><%= success %></div>
    <% } %>

    <% if(error != null){ %>
        <div class="error"><%= error %></div>
    <% } %>

    <form action="<%=request.getContextPath()%>/NewpatientServlet" method="post">
        <label>Name</label>
        <input type="text" name="name" required>

        <label>Age</label>
        <input type="number" name="age" required>

        <label>Disease</label>
        <input type="text" name="disease" required>

        <input type="submit" value="Add Patient">
    </form>
</div>

</body>
</html>
