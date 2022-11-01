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
 <%
 response.setIntHeader("Refresh", 5);
 %>
 <div class="card" >
      <h2>chat box</h5> 
 <div id="divActivites" name="divActivites" style="border:1px solid black;width:250px;">
<textbox>
<c:forEach items="${chat_data}" var="x">

${x.name}:&nbsp &nbsp<p>${x.content}</p>
</c:forEach>
</textbox>

</div>
 <form action="/sendchat" method="post">
<input type="hidden" name="uname"  value="${name}"/>
<input type="text" name="content" placeholder="type text here"/><input type="submit" value="send"/>

</form>
    </div>

</body>
</html>