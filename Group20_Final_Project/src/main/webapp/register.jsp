<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register - Transit Fleet Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(120deg, #ff9966, #ff5e62);
            margin: 0;
            padding: 0;
        }
        .container {
            width: 400px;
            margin: 80px auto;
            background: #fff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            text-align: center;
        }
        h2 {
            color: #2c3e50;
            margin-bottom: 20px;
        }
        p {
            margin: 5px 0;
        }
        p.error {
            color: red;
            font-weight: bold;
        }
        p.success {
            color: green;
            font-weight: bold;
        }
        form {
            text-align: left;
        }
        label {
            font-weight: bold;
        }
        input, select {
            width: 95%;
            padding: 8px;
            margin: 6px 0 15px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            width: 100%;
            padding: 10px;
            background: #27ae60;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: 0.3s;
        }
        button:hover {
            background: #219150;
        }
        .link {
            margin-top: 15px;
        }
        .link a {
            text-decoration: none;
            color: #2980b9;
            font-weight: bold;
        }
        .link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>📝 User Registration</h2>

        <!-- ✅ Display success or error messages -->
        <% if (request.getAttribute("error") != null) { %>
            <p class="error"><%= request.getAttribute("error") %></p>
        <% } %>
        <% if (request.getAttribute("message") != null) { %>
            <p class="success"><%= request.getAttribute("message") %></p>
        <% } %>

        <!-- ✅ Registration form -->
        <form action="register" method="post">
            <label>Full Name:</label>
            <input type="text" name="fullname" required>

            <label>Email:</label>
            <input type="email" name="email" required>

            <label>Password:</label>
            <input type="password" name="password" required>

            <label>Role:</label>
            <select name="role" required>
                <option value="operator">Operator</option>
                <option value="manager">Manager</option>
                <option value="admin">Admin</option>
            </select>

            <label>Route Reference (Optional):</label>
            <input type="number" name="route_ref" placeholder="Enter route ID or leave empty">

            <button type="submit">Register</button>
        </form>

        <div class="link">
            <p>Already have an account? <a href="login.jsp">Login here</a></p>
        </div>
    </div>
</body>
</html>
