<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>

</head>
<body style="background-color: #D6F5F0;">
<center>
<fieldset style="width:300px; margin-top: 400px;">
<table>

<form action="/register" method="post">
 <tr>
  <td>First name:</td>
  <td>  <input type="text" id="fname" name="firstname" required></td>
 </tr>
 <tr>
 <td> Last name:</td>
 <td> <input type="text" id="lname" name="lastname"></td>
 </tr>
  <tr>
  <td>email:</td>
 <td> <input type="email" id="email" name="email" required></td>
 </tr>
 <tr>
  <td>Mobile No:</td>
  <td> <input type="number" id="mobile" name="mobile"pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"></td>
  </tr>
  <tr>
  <td>date of birth:</td>
  <td><input type="date" id="date" name="dateofbirth"></td>
  </tr>
  <tr>
  <td>Gender:</td>
  <td><input type="radio" id="checkbox" name="gender" value="male">male
  <input type="radio" id="checkbox" name="gender" value="female">female</td></tr>
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