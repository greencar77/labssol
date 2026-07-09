<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Add Task</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h1>Add New Task</h1>
    
    <form action="${pageContext.request.contextPath}/add-task" method="post" onsubmit="return validateForm()">
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" required>
        </div>
        
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea id="description" name="description" rows="4"></textarea>
        </div>
        
        <div class="form-group">
            <label for="priority">Priority:</label>
            <select id="priority" name="priority">
                <option value="1">High</option>
                <option value="2" selected>Medium</option>
                <option value="3">Low</option>
            </select>
        </div>
        
        <button type="submit">Save Task</button>
        <a href="${pageContext.request.contextPath}/" style="margin-left: 10px;">Cancel</a>
    </form>

    <script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>
