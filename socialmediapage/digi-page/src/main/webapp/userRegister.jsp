<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>

</head>
<body>
<center>
<fieldset style="width:300px;">
<table>

<form action="/register" method="post">
 <tr>
  <td>First name:</td>
  <td>  <input type="text" id="fname" name="firstname"></td>
 </tr>
 <tr>
 <td> Last name:</td>
 <td> <input type="text" id="lname" name="lastname"></td>
 </tr>
  <tr>
  <td>email:</td>
 <td> <input type="email" id="email" name="email"></td>
 </tr>
 <tr>
  <td>Mobile No:</td>
  <td> <input type="number" id="mobile" name="mobile"></td>
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
  <td><input type="password" id="password" name="password"></td></tr>
  
  <tr>
  <td>&nbsp</td>
  <td><input type="submit" value="Submit"></td></tr>
</form> 
</table>
</fieldset>
</center>
</body>
</html>