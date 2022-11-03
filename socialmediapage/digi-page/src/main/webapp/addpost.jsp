<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #D6F5F0;">

<table>
<form action="/addpost" method="post" enctype="multipart/form-data">
 <tr>
  <td>image:</td>
  <td> <input type="file" name="image_url" accept="image/png, image/jpeg"></td>
 </tr>
 <tr>
 <td>add a note:</td>
 <td><input type="text" id="lname" name="description"></td>
 </tr>
  <tr>
  <td>likes:</td>
 <td> <input type="text" id="email" name="likes"></td>
 </tr>
 <tr>
  <td>user_id:</td>
  <td> <input type="text" id="mobile" name="user_id"></td>
  </tr>
  <tr>
  <td></td>
  <td><input type="submit" value="submit"></td>
  </form>
</table>
</body>
</html>