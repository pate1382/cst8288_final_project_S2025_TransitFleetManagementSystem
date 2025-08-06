package entities;

/**
 * Represents a route schedule (arrival/departure times).
 * Maps to table: fleet_schedules
 * 
 * @author Sarthak
 */
public class Schedule {
    private int id;
    private int routeRef;
    private int stationRef;
    private int tripNo;
    private String arrival;
    private String departure;

    public Schedule() {}

    public Schedule(int id, int routeRef, int stationRef, int tripNo, String arrival, String departure) {
        this.id = id;
        this.routeRef = routeRef;
        this.stationRef = stationRef;
        this.tripNo = tripNo;
        this.arrival = arrival;
        this.departure = departure;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getRouteRef() { return routeRef; }
    public void setRouteRef(int routeRef) { this.routeRef = routeRef; }

    public int getStationRef() { return stationRef; }
    public void setStationRef(int stationRef) { this.stationRef = stationRef; }

    public int getTripNo() { return tripNo; }
    public void setTripNo(int tripNo) { this.tripNo = tripNo; }

    public String getArrival() { return arrival; }
    public void setArrival(String arrival) { this.arrival = arrival; }

    public String getDeparture() { return departure; }
    public void setDeparture(String departure) { this.departure = departure; }

    @Override
    public String toString() {
        return "Schedule{id=" + id + ", tripNo=" + tripNo + ", arrival=" + arrival + ", departure=" + departure + "}";
    }
}
