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
<a href="index.jsp" style="float: right;">log out</a>
<table style="float: right;">
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

</table>
<a href="addpost.jsp">add a post</a>

<fieldset style="padding: 10px;">
<table>
<c:forEach items="${postlist}" var="x">
<tr>
</tr>
<tr>
<td>name                  :</td> <td>${x.uname}</td>
</tr>
<tr>
<td>image                 :</td> <td>
<img  src= "data:image/jpeg;base64,${x.base64image}" style="width: 50px;height: 80px ;"/></img></td>
</tr>
<tr>
<td>description           :</td> <td>${x.description}</td>
</tr>
<tr>
<td>likes                 :</td> <td>${x.likes}</td>
</tr>
<tr>
<td>time of posting       :</td> <td>${x.timestamp}</td>
</tr> 
</c:forEach>
</tbody>
</table>
</fieldset>
</body>
</html>