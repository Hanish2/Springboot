<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

 div.message {
                margin:5px;
                padding:5px;
                
                width: 500px;
                height: 110px;
                overflow: auto;
                text-align:justify;
            }</style>
</head>
<body style="background-color: #D6F5F0;">
 <%
 response.setIntHeader("Refresh", 10);
 %>
 <div class="card">
      <h2>chat box</h5> 
 <div class="message" id="divActivites" name="divActivites" style="border:1px solid black;width:250px;">
		<c:forEach items="${chat_data}" var="x">
		${x.name}:&nbsp &nbsp<p>${x.content}</p>
       </c:forEach>
</div>
 <form action="/sendchat">
<input type="hidden" name="name"  value="${name}"/>
<input type="text" name="content" placeholder="type text here"/><input type="submit" value="send"/>
</form>
<button><a href="/chatbox?name=${name}">refresh</a></button>
    </div>
    

</body>
</html>