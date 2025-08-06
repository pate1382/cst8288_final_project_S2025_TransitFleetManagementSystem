package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DatabaseManager {
    private static final String PROPERTIES_FILE = "database.properties";

    public static Connection getConnection() {
        try (InputStream input = Thread.currentThread()
                                       .getContextClassLoader()
                                       .getResourceAsStream(PROPERTIES_FILE)) {

            if (input == null) {
                System.err.println("❌ database.properties NOT FOUND! Must be in src/main/resources");
                return null;
            }

            Properties props = new Properties();
            props.load(input);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String pass = props.getProperty("db.password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            System.out.println("✅ DB Connection Successful");
            return conn;

        } catch (Exception e) {
            System.err.println("❌ DB Connection Failed: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
