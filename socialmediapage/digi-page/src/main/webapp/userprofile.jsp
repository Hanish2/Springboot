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
<a href="index.jsp" style="float: right;margin">log out</a>
<div style="float:right;">
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
</table>

<h4>friends list</h4>

<table >
<tbody>
<c:forEach items="${friendlist}" var="x">
<tr>
<td>firstname    :</td> <td>${x.firstname}</td>
</tr>
<tr>
<td>&nbsp</td> <td><a href="/completeDetails?name=${x.firstname}&&uname=${user.firstname}">get data</a></td>
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
<a href="addpost.jsp">add a post</a>
<form action="/searchfriend?name=${user.firstname}" method="post">
<input type="text" name="friendname" placeholder="enter the email of the friend">
<input type="submit" value="search">
</form>

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
<a href="/addfriend?uname=${user.firstname}&&friendid=${friend_data.id}"> add friend</a> 
</td>
</tr>
</table>
</div>
<center>

<table>
<tbody>
<c:forEach items="${postlist}" var="x">
<tr>
<td>
<div style="display:none;">${x.post_id}</div>
</td> 

</tr>
<tr>
<td> <br></td>
</tr>
<tr>
<td>name                  :</td> <td>${x.uname}</td>
</tr>
<tr>
<td>image                 :</td> <td>
<img  src= "data:image/jpeg;base64,${x.base64image}" style="width: 130px;height:200px ;"/></img></td>
</tr>
<tr>
<td>description           :</td> <td>${x.description}</td>
</tr>
<tr>

<td>likes                 :</td> <td>${x.likes} </td>
</tr>
<tr>
<td>time of posting       :</td> <td>${x.timestamp}</td>
</tr>
 <tr>
<td>______________________</td>
<td><a href="deletepost?uname=${user.firstname}&&id=${x.post_id}"> delete post</a></td>
 </tr>
</c:forEach>
</tbody>
</table>
</center>

</body>
</html>