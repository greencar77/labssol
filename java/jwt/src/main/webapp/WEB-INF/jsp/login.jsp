<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login Page</h2>
    <form action="/authenticate" method="post">
        <div>
            <label>Username:</label>
            <input type="text" name="username" value="user"/>
        </div>
        <div>
            <label>Password:</label>
            <input type="password" name="password" value="password"/>
        </div>
        <div>
            <button type="submit">Login</button>
        </div>
    </form>
    <p>Default credentials: user / password</p>
    <% if (request.getParameter("error") != null) { %>
        <p style="color:red">Invalid username or password.</p>
    <% } %>
</body>
</html>
