<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Diagnosis</title>

<style>
body { font-family: Arial, sans-serif; background-color: #f2f2f2; padding: 20px; }
.container { max-width: 500px; margin: auto; background: white; padding: 20px;
border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
input, textarea { width: 100%; padding: 10px; margin: 10px 0;
border-radius: 4px; border: 1px solid #ccc; }
textarea { resize: none; height: 80px; }
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
<h2>Add Diagnosis</h2>

<%
String success = request.getParameter("success");
String error = request.getParameter("error");
if(success!=null){
%><div class="message success"><%=success%></div><%}
if(error!=null){
%><div class="message error"><%=error%></div><%}
%>

<form action="<%=request.getContextPath()%>/DiagnosisServlet" method="post">

<label>Patient Name:</label>
<input type="text" name="patient" placeholder="Enter patient name" required>

<label>Doctor Name:</label>
<input type="text" name="doctor" placeholder="Enter doctor name" required>

<label>Diagnosis Details:</label>
<textarea name="details" placeholder="Enter diagnosis details" required></textarea>

<button type="submit">Save Diagnosis</button>

</form>
</div>
</body>
</html>
