<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List,entities.FuelLog,entities.MaintenanceAlert" %>
<%
    List<FuelLog> logs = (List<FuelLog>) request.getAttribute("fuelLogs");
    List<MaintenanceAlert> alerts = (List<MaintenanceAlert>) request.getAttribute("alerts");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Reports - Transit Fleet Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(120deg, #4facfe, #00f2fe);
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
            background: #2980b9;
            color: white;
        }
        tr:nth-child(even) {
            background: #f9f9f9;
        }
        tr:hover {
            background: #eef5ff;
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
        <h2>📊 Fuel Usage Report</h2>
        <table>
            <tr>
                <th>Date</th>
                <th>Distance (km)</th>
                <th>Price Per Unit ($)</th>
            </tr>
            <% if (logs != null && !logs.isEmpty()) {
                for (FuelLog f : logs) { %>
                    <tr>
                        <td><%= f.getLogDate() %></td>
                        <td><%= f.getDistance() %></td>
                        <td><%= f.getPricePerUnit() %></td>
                    </tr>
            <%  } 
               } else { %>
                    <tr><td colspan="3">No fuel logs available.</td></tr>
            <% } %>
        </table>

        <h2>🛠️ Maintenance Alerts Report</h2>
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
                        <td><%= a.isResolved() ? "✅ Resolved" : "❌ Pending" %></td>
                    </tr>
            <%  } 
               } else { %>
                    <tr><td colspan="3">No maintenance alerts found.</td></tr>
            <% } %>
        </table>

        <div style="text-align:center;">
            <a class="back-link" href="dashboard.jsp">⬅ Back to Dashboard</a>
        </div>
    </div>
</body>
</html>
