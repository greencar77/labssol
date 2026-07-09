<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Task List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h1>Task List</h1>
    
    <c:if test="${not empty tasks}">
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Priority</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="task" items="${tasks}">
                    <tr>
                        <td><c:out value="${task.id}"/></td>
                        <td><c:out value="${task.title}"/></td>
                        <td><c:out value="${task.description}"/></td>
                        <td>
                            <c:choose>
                                <c:when test="${task.priority == 1}">
                                    <span style="color: red;">High</span>
                                </c:when>
                                <c:when test="${task.priority == 2}">
                                    <span style="color: orange;">Medium</span>
                                </c:when>
                                <c:otherwise>
                                    <span style="color: green;">Low</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    
    <c:if test="${empty tasks}">
        <p>No tasks found.</p>
    </c:if>

    <a href="${pageContext.request.contextPath}/add-task" class="btn">Add New Task</a>

    <script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>
