<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"> <!-- Bootstrap CSS --> <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<title>Student Registration Form</title>
</head>
<body>
<h3>Student Form for ${mode}</h3>
<form action="save" method="post">
<div class="form-inline">
	<input type="hidden" name="studentId" value="${student.studentId}" class="form-control mb-4 col-4"/>
	<input type="text" name="firstName" value="${student.firstName}" placeholder="First Name" required=true class="form-control mb-4 col-4">
	<input type="text" name="lastName" value="${student.lastName}" placeholder="Last Name" required=true class="form-control mb-4 col-4">
	<input type="text" name="courseName" value="${student.courseName}" placeholder="Course Name" required=true class="form-control mb-4 col-4">
	<input type="text" name="country" value="${student.country}" placeholder="Country" required=true class="form-control mb-4 col-4">
	<button type="submit" class="btn btn-info col-2">Save</button>
</div>
</form>
<a href="list">Back to Students List</a>
</body>
</html>