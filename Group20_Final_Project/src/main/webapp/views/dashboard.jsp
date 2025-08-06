<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="entities.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard - Transit Fleet Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(120deg, #4a90e2, #50c9c3);
            margin: 0;
            padding: 0;
            color: #333;
        }
        .container {
            width: 60%;
            margin: 60px auto;
            background: #fff;
            border-radius: 10px;
            padding: 30px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
            text-align: center;
        }
        h2 {
            color: #2c3e50;
            margin-bottom: 20px;
        }
        ul {
            list-style: none;
            padding: 0;
            margin: 30px 0;
        }
        ul li {
            margin: 12px 0;
        }
        ul li a {
            display: inline-block;
            width: 200px;
            padding: 10px;
            text-decoration: none;
            color: #fff;
            background: #3498db;
            border-radius: 5px;
            transition: 0.3s;
            font-weight: bold;
        }
        ul li a:hover {
            background: #2980b9;
        }
        .logout-btn {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background: #e74c3c;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: 0.3s;
        }
        .logout-btn:hover {
            background: #c0392b;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome, <%= user.getFullname() %> 👋</h2>
        <p>Select an option below to manage the transit fleet system:</p>
        <ul>
            <li><a href="vehicles">🚍 Manage Vehicles</a></li>
            <li><a href="routes">🗺️ View Routes</a></li>
            <li><a href="maintenance">🛠️ Maintenance Alerts</a></li>
            <li><a href="alerts">⚠️ Alert Types</a></li>
            <li><a href="reports">📊 Reports</a></li>
        </ul>
        <a class="logout-btn" href="logout.jsp">🚪 Logout</a>
    </div>
</body>
</html>
