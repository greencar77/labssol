<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Actors List</title>
</head>
<body>
    <h1>Actors</h1>
    <p><a href="/">Back to Home</a></p>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        <c:forEach var="actor" items="${actors}">
            <tr>
                <td>${actor.id}</td>
                <td>${actor.firstName}</td>
                <td>${actor.lastName}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
