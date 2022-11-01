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
<table border = "1" width = "100%">
<thead>
<tr>
<th > Id</th>
<th>Post by</th>
<th>image</th>
<th>description</th>
<th>likes</th>
<th>time of posting</th>
</tr>
</thead>
<tbody>
<c:forEach items="${postList}" var="x">  
  <tr>
    <td>${x.post_id}</td>
    <td>${x.uname}</td>  
    <td><img  src= "data:image/jpeg;base64,${x.base64image}" style="width: 50px;height:80px ;"/></img></td>
    <td>${x.description}</td>
    <td>${x.likes}</td>
    <td>${x.timestamp}</td> 
      <td>
       <a href="/admindeletepost?id=${x.post_id}" >Delete</a>
      </td>
</c:forEach>
</tbody>
</table>


</body>
</html>