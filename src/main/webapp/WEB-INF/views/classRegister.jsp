<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
  <h1>Classes Register Form</h1>
  <form action="<%= request.getContextPath() %>/registerClasses" method="post">
   <table style="with: 80%">
    <tr>
     <td>Class Name</td>
     <td><input type="text" name="classname" /></td>
    </tr>
    <tr>
     <td>Instructor</td>
     <td><input type="text" name="instructor" /></td>
    </tr>
    <tr>
     <td>Class time</td>
     <td><input type="text" name="classtime" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>