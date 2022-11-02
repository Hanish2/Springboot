<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<tr>
<td>firstname    :</td> <td>${friend_data.firstname}</td>
</tr>
<tr>
<td>lastname     :</td> <td>${friend_data.lastname}</td>
</tr>
<tr>
<td>email        :</td> <td>${friend_data.email}</td>
</tr>
<tr>
<td>mobile       :</td> <td>${friend_data.mobile}</td>
</tr>
<tr>
<td>date-of-birth:</td> <td>${friend_data.dateofbirth}</td>
</tr>
<tr>
<td>gender       :</td> <td>${friend_data.gender}</td>
</tr>
<tr>
<td>
</td>
<td>
<a href="/profile?name=${name}"> back to profile</a> 
</td>
</tr>
</table>
</div>
</body>
</html>