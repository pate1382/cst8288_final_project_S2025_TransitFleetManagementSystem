package entities;

/**
 * Represents a transit route in the system.
 * Maps to table: fleet_routes
 * 
 * @author Sarthak
 */
public class Route {
    private int id;
    private String code;
    private String details;

    public Route() {}

    public Route(int id, String code, String details) {
        this.id = id;
        this.code = code;
        this.details = details;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    @Override
    public String toString() {
        return "Route{id=" + id + ", code='" + code + "', details='" + details + "'}";
    }
}
