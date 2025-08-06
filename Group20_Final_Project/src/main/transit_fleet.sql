DROP DATABASE IF EXISTS TransitFleetDB;
CREATE DATABASE TransitFleetDB;
USE TransitFleetDB;

-- =============================
-- 1. Routes Table (OC Transpo)
-- =============================
CREATE TABLE fleet_routes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(10) UNIQUE,
    details TEXT
);
INSERT INTO fleet_routes (code, details) VALUES
('88-H', 'Route 88 – Hurdman Station'),
('88-B', 'Route 88 – Bayshore Station'),
('68-T', 'Route 68 – Terry Fox Station'),
('68-B', 'Route 68 – Baseline Station');

-- =============================
-- 2. Stations Table
-- =============================
CREATE TABLE fleet_stations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);
INSERT INTO fleet_stations (name) VALUES
('Hurdman Station'),
('Bayshore Station'),
('Terry Fox Station'),
('Baseline Station'),
('Tunney’s Pasture Station');

-- =============================
-- 3. Alert Types Table
-- =============================
CREATE TABLE maint_alert_types (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    description TEXT
);
INSERT INTO maint_alert_types (name, description) VALUES
('Brake Alert', 'Brake pads require immediate inspection'),
('Engine Warning', 'Engine diagnostics show critical errors'),
('Electrical Alert', 'Electrical system failure detected');

-- =============================
-- 4. Users Table
-- =============================
CREATE TABLE system_users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fullname VARCHAR(100),
    email VARCHAR(100),
    passwd VARCHAR(100),
    role VARCHAR(50),   -- admin, manager, operator
    route_ref INT,
    FOREIGN KEY (route_ref) REFERENCES fleet_routes(id)
);
INSERT INTO system_users (fullname, email, passwd, role, route_ref) VALUES
('System Admin', 'admin@octranspo.ca', 'admin123', 'admin', 1),
('Operator Mike', 'mike@octranspo.ca', 'opmike', 'operator', 2),
('Operator Sarah', 'sarah@octranspo.ca', 'opsarah', 'operator', 3),
('Manager Paul', 'paul@octranspo.ca', 'mgrpaul', 'manager', 1);

-- =============================
-- 5. Route Schedules
-- =============================
CREATE TABLE fleet_schedules (
    id INT AUTO_INCREMENT PRIMARY KEY,
    route_ref INT,
    station_ref INT,
    trip_no INT,
    arrival TIME,
    departure TIME,
    FOREIGN KEY (route_ref) REFERENCES fleet_routes(id),
    FOREIGN KEY (station_ref) REFERENCES fleet_stations(id)
);
INSERT INTO fleet_schedules (route_ref, station_ref, trip_no, arrival, departure) VALUES
(1, 1, 801, '07:30:00', '07:40:00'),
(2, 2, 802, '08:15:00', '08:30:00'),
(3, 3, 803, '09:00:00', '09:15:00'),
(4, 4, 804, '10:10:00', '10:25:00');

-- =============================
-- 6. Operator Station Logs
-- =============================
CREATE TABLE op_station_logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    log_date DATE,
    time_in TIME,
    time_out TIME,
    remarks TEXT,
    schedule_ref INT,
    user_ref INT,
    FOREIGN KEY (schedule_ref) REFERENCES fleet_schedules(id),
    FOREIGN KEY (user_ref) REFERENCES system_users(id)
);
INSERT INTO op_station_logs (log_date, time_in, time_out, remarks, schedule_ref, user_ref) VALUES
('2025-07-22', '07:28:00', '07:45:00', 'On time departure', 1, 2),
('2025-07-22', '08:12:00', '08:35:00', 'Minor delay due to traffic', 2, 3);

-- =============================
-- 7. Vehicles Table
-- =============================
CREATE TABLE fleet_vehicles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_code VARCHAR(50),
    fuel_rate DECIMAL(5,2),
    max_capacity INT,
    fuel_type VARCHAR(50),
    assigned_route INT,
    seating_capacity INT,
    FOREIGN KEY (assigned_route) REFERENCES fleet_routes(id)
);
INSERT INTO fleet_vehicles (vehicle_code, fuel_rate, max_capacity, fuel_type, assigned_route, seating_capacity) VALUES
('OC-501', 11.5, 40, 'Electric', 1, 45),
('OC-502', 10.3, 50, 'Diesel', 2, 50),
('OC-503', 9.1, 55, 'Hybrid', 3, 60),
('OC-504', 8.7, 60, 'Diesel', 4, 65);

-- =============================
-- 8. Fuel Logs
-- =============================
CREATE TABLE fuel_logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_ref INT,
    log_date DATE,
    distance DECIMAL(10,2),
    price_per_unit DECIMAL(6,2),
    FOREIGN KEY (vehicle_ref) REFERENCES fleet_vehicles(id)
);
INSERT INTO fuel_logs (vehicle_ref, log_date, distance, price_per_unit) VALUES
(1, '2025-06-15', 250.5, 2.25),
(2, '2025-06-16', 180.0, 2.40),
(3, '2025-06-18', 300.2, 2.55);

-- =============================
-- 9. Vehicle Components
-- =============================
CREATE TABLE vehicle_parts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    vehicle_ref INT,
    hours_used INT,
    hours_limit INT,
    FOREIGN KEY (vehicle_ref) REFERENCES fleet_vehicles(id)
);
INSERT INTO vehicle_parts (name, vehicle_ref, hours_used, hours_limit) VALUES
('Brake Pads', 1, 210, 500),
('Engine Module', 2, 190, 550),
('Battery Pack', 3, 260, 600);

-- =============================
-- 10. Maintenance Alerts
-- =============================
CREATE TABLE maint_alerts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    alert_type_ref INT,
    part_ref INT,
    alert_date DATE,
    reported_by INT,
    resolved BOOLEAN,
    FOREIGN KEY (alert_type_ref) REFERENCES maint_alert_types(id),
    FOREIGN KEY (part_ref) REFERENCES vehicle_parts(id),
    FOREIGN KEY (reported_by) REFERENCES system_users(id)
);
INSERT INTO maint_alerts (alert_type_ref, part_ref, alert_date, reported_by, resolved) VALUES
(1, 1, '2025-07-20', 2, 0),
(2, 2, '2025-07-19', 3, 1);

-- =============================
-- 11. Maintenance Schedule
-- =============================
CREATE TABLE maint_schedule (
    id INT AUTO_INCREMENT PRIMARY KEY,
    alert_ref INT,
    scheduled_date DATE,
    notes TEXT,
    cost DECIMAL(10,2),
    completed BOOLEAN,
    FOREIGN KEY (alert_ref) REFERENCES maint_alerts(id)
);
INSERT INTO maint_schedule (alert_ref, scheduled_date, notes, cost, completed) VALUES
(1, '2025-07-23', 'Parts ordered and pending delivery', 600.00, 0),
(2, '2025-07-25', 'Oil replacement completed', 130.00, 1);


-- =============================
-- 12. Vehicle Alerts View
-- =============================
CREATE OR REPLACE VIEW vw_vehicle_alerts AS
SELECT u.id AS user_id, v.id AS vehicle_id, t.name AS alert_name, t.description AS alert_details
FROM system_users u
JOIN fleet_routes r ON u.route_ref = r.id
JOIN fleet_vehicles v ON r.id = v.assigned_route
JOIN vehicle_parts p ON v.id = p.vehicle_ref
JOIN maint_alerts a ON p.id = a.part_ref
JOIN maint_alert_types t ON a.alert_type_ref = t.id
ORDER BY v.id;
