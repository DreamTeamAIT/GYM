<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GYM</title>
</head>
<body>
 <div align="center">
  <h1>Insert Instructor</h1>
  <form action="<%=request.getContextPath()%>/instructorcontroller" method="post">
   <table style="with: 100%">
    <tr>
     <td>Instructor Name</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>Gender</td>
     <td><input type="text" name="gender" /></td>
    </tr>

   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>