package databases;


public class SalesLocation {
    private int locationId;
    private String locationDescription;
    private String locationCity;
    private String locationState;
    private String locationPostCode;

    // Default constructor
    public SalesLocation() {}

    // Parameterized constructor
    public SalesLocation(int locationId, String locationDescription, String locationCity, String locationState, String locationPostCode) {
        this.locationId = locationId;
        this.locationDescription = locationDescription;
        this.locationCity = locationCity;
        this.locationState = locationState;
        this.locationPostCode = locationPostCode;
    }

    // Getters and Setters
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationState() {
        return locationState;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public String getLocationPostCode() {
        return locationPostCode;
    }

    public void setLocationPostCode(String locationPostCode) {
        this.locationPostCode = locationPostCode;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(locationId).append(" \t | ").append(locationDescription).append(" \t | ")
                .append(locationCity).append(" \t | ").append(locationState).append(" \t | ").append(locationPostCode);
        return builder.toString();
    }
}
