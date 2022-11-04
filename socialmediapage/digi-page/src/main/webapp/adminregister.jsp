<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<fieldset style="width:300px;">
<table>ss
<form action="/adminregister" method="post">
<tr>
 <td> name:</td>
 <td> <input type="text" id="lname" name="name"></td>
 </tr>
  <tr>
  <td>email:</td>
 <td> <input type="email" id="email" name="email" required></td>
 </tr>
 <tr>
  <td>Mobile No:</td>
  <td> <input type="number" id="mobile" name="phoneNumber"pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"></td>
  </tr>
  <tr>
  <td>password:</td>
  <td><input type="password" id="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required></td></tr>
  
  <tr>
  <td>&nbsp</td>
  <td><input type="submit" value="Submit"></td></tr>
</form> 
</table>
</fieldset>
</center>
</body>
</html>