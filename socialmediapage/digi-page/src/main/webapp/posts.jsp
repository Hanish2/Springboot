<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #D6F5F0;">
<fieldset style="padding: 20px;">
<table>
<c:forEach items="${result}" var="x">
<tr>
<td>name              :</td> <td>${x.userName}</td>
</tr>
<tr>
<td>image             :</td> <td><img  src= "data:image/jpeg;base64,${x.base64image}" style="width: 50px;height: 80px ;"/></img></td>
</tr>
<tr>
<td>description       :</td> <td>${x.description}</td>
</tr>
<tr>
<td>likes             :</td> <td>${x.likes}</td>
</tr>
<tr>
<td>time of posting   :</td> <td>${x.timeStamp}</td>
</tr> 
</c:forEach>
</tbody>
</table>
</fieldset>


</body>
</html>