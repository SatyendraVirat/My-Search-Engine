<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result Page</title>
</head>
<body>
//<h1 >Student: ${student}</h1>
<h2>Name is: ${student.name}</h2>
<h2>Id is: ${student.id}</h2>
<h2>Date is: ${student.date}</h2>
<h2>Courses is: ${student.courses}</h2>
<h2>Gender is: ${student.gender}</h2>
<h2>Student type is: ${student.type}</h2>
<hr>
<h1>Address>>>>>>>>>>>>><<<<<<<<<<<<<<<</h1>
<h2>Street is: ${student.address.street}</h2>
<h2>City is: ${student.address.city}</h2>
</body>
</html>