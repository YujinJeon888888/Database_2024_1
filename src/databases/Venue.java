package databases;

public class Venue {
    private String venueCode;
    private String venueDescription;
    private String venueCity;
    private String venueState;
    private String venuePostCode;

    // Default constructor
    public Venue() {}

    // Parameterized constructor
    public Venue(String venueCode, String venueDescription, String venueCity, String venueState, String venuePostCode) {
        this.venueCode = venueCode;
        this.venueDescription = venueDescription;
        this.venueCity = venueCity;
        this.venueState = venueState;
        this.venuePostCode = venuePostCode;
    }

    // Getters and Setters
    public String getVenueCode() {
        return venueCode;
    }

    public void setVenueCode(String venueCode) {
        this.venueCode = venueCode;
    }

    public String getVenueDescription() {
        return venueDescription;
    }

    public void setVenueDescription(String venueDescription) {
        this.venueDescription = venueDescription;
    }

    public String getVenueCity() {
        return venueCity;
    }

    public void setVenueCity(String venueCity) {
        this.venueCity = venueCity;
    }

    public String getVenueState() {
        return venueState;
    }

    public void setVenueState(String venueState) {
        this.venueState = venueState;
    }

    public String getVenuePostCode() {
        return venuePostCode;
    }

    public void setVenuePostCode(String venuePostCode) {
        this.venuePostCode = venuePostCode;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(venueCode).append(" \t | ").append(venueDescription).append(" \t | ")
                .append(venueCity).append(" \t | ").append(venueState).append(" \t | ")
                .append(venuePostCode);
        return builder.toString();
    }
}
