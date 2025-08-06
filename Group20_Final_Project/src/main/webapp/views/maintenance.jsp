<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List,entities.MaintenanceAlert,entities.MaintenanceSchedule" %>
<%
    List<MaintenanceAlert> alerts = (List<MaintenanceAlert>) request.getAttribute("alerts");
    List<MaintenanceSchedule> schedules = (List<MaintenanceSchedule>) request.getAttribute("schedules");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Maintenance - Transit Fleet Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(120deg, #6a11cb, #2575fc);
            margin: 0;
            padding: 0;
            color: #333;
        }
        .container {
            width: 85%;
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
            margin-bottom: 40px;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background: #34495e;
            color: white;
        }
        tr:nth-child(even) {
            background: #f9f9f9;
        }
        tr:hover {
            background: #eef3ff;
        }
        .status-resolved {
            color: green;
            font-weight: bold;
        }
        .status-pending {
            color: red;
            font-weight: bold;
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
        <!-- Maintenance Alerts -->
        <h2>⚠️ Maintenance Alerts</h2>
        <table>
            <tr>
                <th>Alert ID</th>
                <th>Alert Date</th>
                <th>Status</th>
            </tr>
            <% if (alerts != null && !alerts.isEmpty()) {
                for (MaintenanceAlert a : alerts) { %>
                    <tr>
                        <td><%= a.getId() %></td>
                        <td><%= a.getAlertDate() %></td>
                        <td class="<%= a.isResolved() ? "status-resolved" : "status-pending" %>">
                            <%= a.isResolved() ? "✅ Resolved" : "❌ Pending" %>
                        </td>
                    </tr>
            <%  } 
               } else { %>
                    <tr><td colspan="3">No maintenance alerts available.</td></tr>
            <% } %>
        </table>

        <!-- Maintenance Schedules -->
        <h2>🛠️ Maintenance Schedules</h2>
        <table>
            <tr>
                <th>Schedule ID</th>
                <th>Scheduled Date</th>
                <th>Notes</th>
            </tr>
            <% if (schedules != null && !schedules.isEmpty()) {
                for (MaintenanceSchedule s : schedules) { %>
                    <tr>
                        <td><%= s.getId() %></td>
                        <td><%= s.getScheduledDate() %></td>
                        <td><%= s.getNotes() %></td>
                    </tr>
            <%  } 
               } else { %>
                    <tr><td colspan="3">No maintenance schedules found.</td></tr>
            <% } %>
        </table>

        <div style="text-align:center;">
            <a class="back-link" href="dashboard.jsp">⬅ Back to Dashboard</a>
        </div>
    </div>
</body>
</html>
