<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<c:forEach items="${result}" var="x">  
  <tr>
    <td>${x.post_id}</td>
    <td>${x.user_id}</td>  
    
   <td><img url("${x.image_url}")></img></td>
   <td>${x.description}</td>
    <td>${x.likes}</td>
    <td>${x.timestamp}</td>  
</c:forEach>
</tbody>
</table>



</body>
</html>