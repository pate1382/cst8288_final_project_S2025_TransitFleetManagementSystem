<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List,entities.Route" %>
<%
    List<Route> routes = (List<Route>) request.getAttribute("routes");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Routes - Transit Fleet Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(120deg, #43cea2, #185a9d);
            margin: 0;
            padding: 0;
            color: #333;
        }
        .container {
            width: 70%;
            margin: 40px auto;
            background: #fff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background: #16a085;
            color: white;
        }
        tr:nth-child(even) {
            background: #f9f9f9;
        }
        tr:hover {
            background: #ecf9f6;
        }
        .back-link {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            color: #fff;
            background: #e67e22;
            padding: 8px 14px;
            border-radius: 5px;
            transition: 0.3s;
        }
        .back-link:hover {
            background: #d35400;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>🗺️ Available Transit Routes</h2>

        <table>
            <tr>
                <th>ID</th>
                <th>Route Code</th>
                <th>Details</th>
            </tr>
            <% if (routes != null && !routes.isEmpty()) { 
                for (Route r : routes) { %>
                    <tr>
                        <td><%= r.getId() %></td>
                        <td><%= r.getCode() %></td>
                        <td><%= r.getDetails() %></td>
                    </tr>
            <%  } 
               } else { %>
                    <tr><td colspan="3">No routes available at the moment.</td></tr>
            <% } %>
        </table>

        <a class="back-link" href="dashboard.jsp">⬅ Back to Dashboard</a>
    </div>
</body>
</html>
