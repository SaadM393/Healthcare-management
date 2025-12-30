<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accounts</title>

<style>
body{font-family:Arial;background:#f2f2f2;padding:20px;}
.container{max-width:500px;margin:auto;background:white;padding:20px;
border-radius:8px;box-shadow:0 0 10px rgba(0,0,0,0.1);}
input{width:100%;padding:10px;margin:10px 0;border-radius:4px;border:1px solid #ccc;}
button{padding:10px 20px;background:#4CAF50;color:white;border:none;
border-radius:4px;cursor:pointer;}
button:hover{background:#45a049;}
.message{padding:10px;margin-bottom:15px;border-radius:4px;}
.success{background:#d4edda;color:#155724;}
.error{background:#f8d7da;color:#721c24;}
</style>
</head>

<body>
<div class="container">
<h2>Accounts Entry</h2>

<%
String success=request.getParameter("success");
String error=request.getParameter("error");
if(success!=null){%><div class="message success"><%=success%></div><%}
if(error!=null){%><div class="message error"><%=error%></div><%}
%>

<form action="<%=request.getContextPath()%>/AccountsServlet" method="post">
<label>Patient Name:</label>
<input type="text" name="patient" required>

<label>Amount:</label>
<input type="number" name="amount" required>

<button type="submit">Save Account</button>
</form>
</div>
</body>
</html>
