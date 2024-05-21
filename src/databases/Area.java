package databases;
import java.math.BigDecimal;
public class Area {
    private String areaCode;
    private String areaDescription;
    private BigDecimal price;

    // Default constructor
    public Area() {}

    // Parameterized constructor
    public Area(String areaCode, String areaDescription, BigDecimal price) {
        this.areaCode = areaCode;
        this.areaDescription = areaDescription;
        this.price = price;
    }

    // Getters and Setters
    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaDescription() {
        return areaDescription;
    }

    public void setAreaDescription(String areaDescription) {
        this.areaDescription = areaDescription;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(areaCode).append(" \t | ").append(areaDescription).append(" \t | ").append(price);
        return builder.toString();
    }
}
