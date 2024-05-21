package databases;

public class Cashier {
    private String cashierId;
    private int locationId;
    private String cashierFirstName;
    private String cashierLastName;
    private String cashierGender;
    private String counterNum;

    // Default constructor
    public Cashier() {}

    // Parameterized constructor
    public Cashier(String cashierId, int locationId, String cashierFirstName, String cashierLastName, String cashierGender, String counterNum) {
        this.cashierId = cashierId;
        this.locationId = locationId;
        this.cashierFirstName = cashierFirstName;
        this.cashierLastName = cashierLastName;
        this.cashierGender = cashierGender;
        this.counterNum = counterNum;
    }

    // Getters and Setters
    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getCashierFirstName() {
        return cashierFirstName;
    }

    public void setCashierFirstName(String cashierFirstName) {
        this.cashierFirstName = cashierFirstName;
    }

    public String getCashierLastName() {
        return cashierLastName;
    }

    public void setCashierLastName(String cashierLastName) {
        this.cashierLastName = cashierLastName;
    }

    public String getCashierGender() {
        return cashierGender;
    }

    public void setCashierGender(String cashierGender) {
        this.cashierGender = cashierGender;
    }

    public String getCounterNum() {
        return counterNum;
    }

    public void setCounterNum(String counterNum) {
        this.counterNum = counterNum;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(cashierId).append(" \t | ").append(locationId).append(" \t | ")
                .append(cashierFirstName).append(" \t | ").append(cashierLastName).append(" \t | ")
                .append(cashierGender).append(" \t | ").append(counterNum);
        return builder.toString();
    }
}
