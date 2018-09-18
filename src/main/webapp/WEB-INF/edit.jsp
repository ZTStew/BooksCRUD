<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
</head>
<body>
<h1>Edit Book</h1>

<!-- <p>Title: <input type="text" value = "${book.title}" placeholder = "${book.title}"/></p>
<p>Description: <input type="text" value = "${book.description}" placeholder = "${book.description}"/></p>
<p>Language: <input type="text" value = "${book.language}" placeholder = "${book.language}"/></p>
<p>Number of pages: <input type="text" value = "${book.numberOfPages}" placeholder = "${book.numberOfPages}"/></p>

<form action="/books/edit/${book.id}" method = "post">
<input type = "hidden" name = "_method" value = "patch">
<input type="submit" value = "Edit">
</form> -->



<form:form action="/books/edit/${book.id}" method="post" modelAttribute="book">
    <input type="hidden" name="_method" value="put">
    <p><form:errors path="title"/></p>
    <p>
        <form:label path="title">Title</form:label>
        <form:input path="title"/>
    </p>
    
    <p><form:errors path="description"/></p>
    <p>
        <form:label path="description">Description</form:label>
        <form:input path="description"/>
    </p>
    
    <p><form:errors path="language"/></p>
    <p>
        <form:label path="language">Language</form:label>
        <form:input path="language"/>
    </p>
    
    <p><form:errors path="numberOfPages"/></p>
    <p>
        <form:label path="numberOfPages">Pages</form:label>    
        <form:input type="number" path="numberOfPages"/>
    </p>     
    <input type="submit" value="Edit"/>
</form:form>

<form action="/books/m/show/${book.id}" method = "get">
<input type="submit" value = "Back">
</form>

</body>
</html>