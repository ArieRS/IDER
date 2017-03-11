package jti46.ider.engine;

/**
 * Created by yunhasnawa on 11/03/17.
 */

public class Vendor
{
    private int id;
    private String username;
    private String category;
    private String displayName;
    private String status;
    private String currentLocation;
    private int distance;

    public Vendor()
    {
    }

    public Vendor(int id, String username, String category, String displayName, String status,
                  String currentLocation, int distance) {
        this.id = id;
        this.username = username;
        this.category = category;
        this.displayName = displayName;
        this.status = status;
        this.currentLocation = currentLocation;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getCategoryDisplayName()
    {
        String category = "[" + this.getCategory() + "]";
        String displayName = " " + this.getDisplayName();

        String join = category + displayName;

        return join;
    }

    public String getLocationDistance()
    {
        String location = this.getCurrentLocation() + ", ";
        String distance = this.getDistance() + " meter";

        String join = location + distance;

        return join;
    }
}
