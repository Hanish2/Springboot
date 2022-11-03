<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #D6F5F0;">
<center>
<fieldset style="width:300px;">
<table>
<form action="/updateuser" method="post">
 <tr>
 <input type="hidden" id="id" name="id" value="${user.id}">
  <td>First name:</td>
  <td>  <input type="text" id="fname" name="firstname" value="${user.firstname}" required></td>
 </tr>
 <tr>
 <td> Last name:</td>
 <td> <input type="text" id="lname" name="lastname" value="${user.lastname}" ></td>
 </tr>
 <td> <input type="hidden" id="email" name="email" value="${user.email}" ></td>
 <tr>
  <td>Mobile No:</td>
  <td> <input type="number" id="mobile" name="mobile"pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" value="${user.mobile}" ></td>
  </tr>
  <tr>
  <td>date of birth:</td>
  <td><input type="date" id="date" name="dateofbirth" value="${user.gender}" ></td>
  </tr>
  <tr>
  <td>Gender:</td>
  <td><input type="radio" id="checkbox" name="gender" value="male">male
  <input type="radio" id="checkbox" name="gender" value="female">female</td></tr>
  <tr>
  <td>password:</td>
  <td><input type="password" id="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" value="${user.password}" ></td></tr>
  
  <tr>
  <td>&nbsp</td>
  <td><input type="submit" value="Submit"></td></tr>
</form> 
</table>
</fieldset>
</center>

</body>
</html>