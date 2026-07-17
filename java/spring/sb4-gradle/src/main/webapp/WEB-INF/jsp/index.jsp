<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task List</title>
</head>
<body>
    <h1>Task List (Spring Boot 4 + JSP)</h1>
    <form action="/add" method="post">
        <input type="text" name="description" placeholder="Enter new task" required>
        <button type="submit">Add Task</button>
    </form>
    <ul>
        <c:forEach var="task" items="${tasks}">
            <li>${task.description} (ID: ${task.id})</li>
        </c:forEach>
    </ul>
    <hr>
    <p><a href="/h2-console">H2 Console</a> (JDBC URL: jdbc:h2:file:./data/demo)</p>
</body>
</html>
