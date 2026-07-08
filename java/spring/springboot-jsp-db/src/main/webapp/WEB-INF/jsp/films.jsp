<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Films List</title>
</head>
<body>
    <h1>Films</h1>
    <p><a href="/">Back to Home</a></p>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Release Year</th>
            <th>Description</th>
        </tr>
        <c:forEach var="film" items="${films}">
            <tr>
                <td>${film.id}</td>
                <td>${film.title}</td>
                <td>${film.releaseYear}</td>
                <td>${film.description}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
