package databases;

public class Customer {
    private String customerId;
    private String customerFirstName;
    private String customerLastName;
    private Integer customerAge;
    private String customerGender;
    private String customerPhone;
    private String cashierId;
    private Integer locationId;

    // Default constructor
    public Customer() {}

    // Parameterized constructor
    public Customer(String customerId, String customerFirstName, String customerLastName, Integer customerAge,
    		String customerGender, String customerPhone, String cashierId, Integer locationId) {
        this.customerId = customerId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerAge = customerAge;
        this.customerGender = customerGender;
        this.customerPhone = customerPhone;
        this.cashierId = cashierId;
        this.locationId = locationId;
    }

    // Getters and Setters
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public Integer getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(Integer customerAge) {
        this.customerAge = customerAge;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(customerId).append(" \t | ").append(customerFirstName).append(" \t | ")
                .append(customerLastName).append(" \t | ").append(customerAge).append(" \t | ")
                .append(customerGender).append(" \t | ").append(customerPhone).append(" \t | ")
                .append(cashierId).append(" \t | ").append(locationId);
        return builder.toString();
    }
}
