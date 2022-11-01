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
<th>first  name</th>
<th>last name</th>
<th>email</th>
<th>mobile</th>
<th>gender</th>
<th>dateofbirth</th>
</tr>
</thead>
<tbody>
<c:forEach items="${userlist}" var="x">  
  <tr>
    <td>${x.id}</td>
    <td>${x.firstname}</td>  
    <td>${x.lastname}</td>
    <td>${x.email}</td>
   
    <td>${x.mobile}</td>
    <td>${x.gender}</td>
    <td>${x.dateofbirth}</td> 
    <td>
       <a class="btn btn-info" href="/adminedituser?id=${x.id}">Update</a>
      </td>
      <td>
       <a class="btn btn-danger" href="/admindeleteuser?id=${x.id}" >Delete</a>
      </td>
</c:forEach>
</tbody>
</table>

</body>
</html>