<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <h2>Welcome, ${username}!</h2>
    <p>This is a protected page accessible only with a valid JWT.</p>
    <p>Your JWT is stored in a HttpOnly cookie.</p>
    
    <h3>How it works:</h3>
    <ul>
        <li>When you logged in, the server generated a JWT using <code>JwtUtils</code>.</li>
        <li>The JWT was sent back to your browser as a <code>HttpOnly</code> cookie named <code>JWT</code>.</li>
        <li>Every request you make to this dashboard is intercepted by <code>JwtRequestFilter</code>.</li>
        <li>The filter extracts the token from the cookie, validates it, and sets the Security Context.</li>
    </ul>

    <a href="/login">Back to Login (Logout)</a>
</body>
</html>
