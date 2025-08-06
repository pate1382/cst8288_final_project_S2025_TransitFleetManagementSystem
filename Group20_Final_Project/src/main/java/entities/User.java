package entities;

/**
 * Entity class for system users.
 * 
 * author Sarthak
 */
public class User {
    private int id;
    private String fullname;
    private String email;
    private String password;
    private String role;
    private int routeRef;

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public int getRouteRef() { return routeRef; }
    public void setRouteRef(int routeRef) { this.routeRef = routeRef; }
}
