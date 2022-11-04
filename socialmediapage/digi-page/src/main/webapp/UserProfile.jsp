<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.socialmediapage.digipage.repository.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.socialmediapage.digipage.serviceImpl.UserService" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #D6F5F0;">
<a href="Index.jsp" style="float: right;margin">log out</a>
<a href="/UserUpdate.jsp">update</a>
<div style="float:right;">
<table>
<tr>
<td>firstname    :</td> <td>${user.firstName}</td>
</tr>
<tr>
<td>lastname     :</td> <td>${user.lastName}</td>
</tr>
<tr>
<td>email        :</td> <td>${user.email}</td>
</tr>
<tr>
<td>mobile       :</td> <td>${user.mobile}</td>
</tr>
<tr>
<td>date-of-birth:</td> <td>${user.dateOfBirth}</td>
</tr>
<tr>
<td>gender       :</td> <td>${user.gender}</td>
</tr>
</table>

<h4>friends list</h4>

<table >
<tbody>
<c:forEach items="${friendList}" var="x">
<tr>
<td>firstname    :</td> <td>${x.firstName}</td>
</tr>
<tr>
<td>&nbsp</td> <td><a href="/CompleteDetails?name=${x.firstName}&&uname=${user.email}">get data</a></td>
</tr>
<tr>
<td>
&nbsp
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>


<div style="float: left;">
<a href="AddPost.jsp">add a post</a>
<form action="/searchFriend?name=${user.firstName}" method="post">
<input type="text" name="friendname" placeholder="enter the email of the friend">
<input type="submit" value="search">
</form>

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
<a href="/addFriend?uname=${user.firstName}&&friendId=${friend_data.id}"> add friend</a> 
</td>
</tr>
</table>
</div>
<div class="card" style=" width:300px; margin-left: 450px;">
<c:forEach items="${postList}" var="x">
<center>
<div class="card" style=" width:400px; ">

   <div class="card" style="border:1px solid black;" >
   
      <h5>Post by: ${x.userName} &nbsp &nbsp post time:${x.timeStamp} </h5>
      <div class="fakeimg" style="height:350px;"><img src="data:image/jpeg;base64,${x.base64image}" style="width: 180px;height:300px 	;"/>
       <p>${x.userName}: ${x.description}&nbsp&nbsp<a href="deletePost?name=${user.firstName}&&id=${x.post_id}"> delete post</a></p>
       
     
    </div>
    </div>
 </center>
</c:forEach>

</div>
 

</body>
</html>