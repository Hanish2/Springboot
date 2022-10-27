<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.socialmediapage.digipage.posts.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.socialmediapage.digipage.user.UserService" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>firstname    :</td> <td>${user.firstname}</td>
</tr>
<tr>
<td>lastname     :</td> <td>${user.lastname}</td>
</tr>
<tr>
<td>email        :</td> <td>${user.email}</td>
</tr>
<tr>
<td>mobile       :</td> <td>${user.mobile}</td>
</tr>
<tr>
<td>date-of-birth:</td> <td>${user.dateofbirth}</td>
</tr>
<tr>
<td>gender       :</td> <td>${user.gender}</td>
</tr>
</tbody>
</table>
<a href="addpost.jsp">add a post</a>
<table>

<table>
<c:forEach items="${postlist}" var="x">  
  <tr>
    <td>${x.post_id}</td>
    <td>${x.uname}</td>   
   <td><img url("${x.image_url}")></img></td>
   <td>${x.description}</td>
    <td>${x.likes}</td>
    <td>${x.timestamp}</td>  
</c:forEach>
</tbody>
</table>
</table>

</body>
</html>