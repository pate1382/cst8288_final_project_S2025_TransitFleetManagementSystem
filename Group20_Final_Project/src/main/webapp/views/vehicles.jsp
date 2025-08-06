<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List,entities.Vehicle" %>
<%
    List<Vehicle> vehicles = (List<Vehicle>) request.getAttribute("vehicles");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Fleet Vehicles - Transit Fleet Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(120deg, #50c9c3, #96deda);
            margin: 0;
            padding: 0;
            color: #333;
        }
        .container {
            width: 80%;
            margin: 40px auto;
            background: #fff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            color: #2c3e50;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background: #3498db;
            color: #fff;
        }
        tr:nth-child(even) {
            background: #f9f9f9;
        }
        tr:hover {
            background: #eef7ff;
        }
        form {
            margin-top: 30px;
            padding: 20px;
            background: #f7f9fc;
            border: 1px solid #ddd;
            border-radius: 8px;
        }
        form input {
            width: 95%;
            padding: 8px;
            margin: 6px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        form button {
            background: #27ae60;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: 0.3s;
        }
        form button:hover {
            background: #219150;
        }
        .back-link {
            display: inline-block;
            margin-top: 15px;
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
        <h2>🚍 Fleet Vehicles</h2>

        <!-- Vehicle Table -->
        <table>
            <tr>
                <th>ID</th>
                <th>Code</th>
                <th>Fuel Type</th>
                <th>Seating Capacity</th>
            </tr>
            <% if (vehicles != null && !vehicles.isEmpty()) { 
                for (Vehicle v : vehicles) { %>
                    <tr>
                        <td><%= v.getId() %></td>
                        <td><%= v.getVehicleCode() %></td>
                        <td><%= v.getFuelType() %></td>
                        <td><%= v.getSeatingCapacity() %></td>
                    </tr>
            <%  } 
               } else { %>
                    <tr><td colspan="4">No vehicles available.</td></tr>
            <% } %>
        </table>

        <!-- Add Vehicle Form -->
        <h3>Add New Vehicle</h3>
        <form action="../vehicles" method="post">
            <label>Vehicle Code:</label>
            <input type="text" name="vehicleCode" required>

            <label>Fuel Rate:</label>
            <input type="text" name="fuelRate" required>

            <label>Max Capacity:</label>
            <input type="number" name="maxCapacity" required>

            <label>Fuel Type:</label>
            <input type="text" name="fuelType" required>

            <label>Route ID:</label>
            <input type="number" name="routeRef" required>

            <label>Seating Capacity:</label>
            <input type="number" name="seatingCapacity" required>

            <button type="submit">➕ Add Vehicle</button>
        </form>

        <a class="back-link" href="dashboard.jsp">⬅ Back to Dashboard</a>
    </div>
</body>
</html>
