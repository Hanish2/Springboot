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
<td>${name}</td>
<a href="profile?name=${name}"  style="float:right;">profile</a>
<br>
<a href="/chatbox?name=${name}" style="float :right;">chatbox</a>


<div class="card" style=" width:300px; margin-left: 450px;">
<center>
<c:forEach items="${result}" var="x">

<div class="card" style=" width:400px; ">

   <div class="card" style="border:1px solid black;" >
      <h5>Post by: ${x.uname} &nbsp &nbsp post time:${x.timestamp} </h5>
      <div class="fakeimg" style="height:350px;"><img src="data:image/jpeg;base64,${x.base64image}" style="width: 180px;height:300px 	;"/>
       <p>${x.uname}: ${x.description}</p>
       </div>
     
    </div>
</c:forEach>
</center>
</div>


</body>
</html>

