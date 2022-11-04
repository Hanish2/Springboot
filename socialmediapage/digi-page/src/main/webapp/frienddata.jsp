<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #D6F5F0;">

<table>
<tr>
<td>firstname    :</td> <td>${friend_data.firstName}</td>
</tr>
<tr>
<td>lastname     :</td> <td>${friend_data.lastName}</td>
</tr>
<tr>
<td>email        :</td> <td>${friend_data.email}</td>
</tr>
<tr>
<td>mobile       :</td> <td>${friend_data.mobile}</td>
</tr>
<tr>
<td>date-of-birth:</td> <td>${friend_data.dateOfBirth}</td>
</tr>
<tr>
<td>gender       :</td> <td>${friend_data.gender}</td>
</tr>
<tr>
<td>
</td>
<td>
<a href="profile?name=${name}"  style="float:right;">profile</a>
</td>
<h4>${name}: name</h4>
</tr>
</table>
</div>
</body>
</html>