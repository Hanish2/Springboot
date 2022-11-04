<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #D6F5F0;margin-top: 250px;">
<center>
<form action="/login" method="post">		
UserName:<input type="text" name="email" required>
<br>
Password:<input type="password"name="password"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
<input type="submit" value="submit">
</form>
<a href="UserRegister.jsp"> register</a>
</center>
<a href="AdminLogin.jsp">admin login</a>
</body>
</html>

 