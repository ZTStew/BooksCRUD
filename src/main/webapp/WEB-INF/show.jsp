<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show</title>
</head>
<body>
	<h1><c:out value = "${book.title}" /></h1>
	<p>Description: <c:out value = "${book.description}" /></p>
	<p>Language: <c:out value = "${book.language}" /></p>
	<p>Number of Pages: <c:out value = "${book.numberOfPages}" /></p>
	<!-- <a href="/edit/${book.id}">Edit Book</a> -->
	<form action="/books/m/edit/${book.id}" method = "get">
		<input type = "submit" value = "Edit">
	</form>
	<form action="/books" method = "get">
		<input type = "submit" value = "Back">
	</form>
	<form action="/books/delete/${book.id}" method = "post">
		<input type = "hidden" name = "_method" value = "delete">
		<input type = "submit" value = "Delete Book">
	</form>
</body>
</html>