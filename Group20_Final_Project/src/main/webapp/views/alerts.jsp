<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List,entities.AlertType" %>
<%
    List<AlertType> types = (List<AlertType>) request.getAttribute("alertTypes");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Alert Types - Transit Fleet Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(120deg, #ff758c, #ff7eb3);
            margin: 0;
            padding: 0;
            color: #333;
        }
        .container {
            width: 75%;
            margin: 40px auto;
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            color: #2c3e50;
            margin-top: 10px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            margin-bottom: 30px;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background: #c0392b;
            color: white;
        }
        tr:nth-child(even) {
            background: #f9f9f9;
        }
        tr:hover {
            background: #ffeef1;
        }
        .back-link {
            display: inline-block;
            text-decoration: none;
            color: #fff;
            background: #e67e22;
            padding: 10px 16px;
            border-radius: 5px;
            transition: 0.3s;
            font-weight: bold;
        }
        .back-link:hover {
            background: #d35400;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>⚠️ Alert Types</h2>
        <table>
            <tr>
                <th>Alert ID</th>
                <th>Alert Name</th>
                <th>Description</th>
            </tr>
            <% if (types != null && !types.isEmpty()) {
                for (AlertType t : types) { %>
                    <tr>
                        <td><%= t.getId() %></td>
                        <td><%= t.getName() %></td>
                        <td><%= t.getDescription() %></td>
                    </tr>
            <%  } 
               } else { %>
                    <tr><td colspan="3">No alert types available.</td></tr>
            <% } %>
        </table>

        <div style="text-align:center;">
            <a class="back-link" href="dashboard.jsp">⬅ Back to Dashboard</a>
        </div>
    </div>
</body>
</html>
