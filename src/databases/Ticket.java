package databases;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

public class Ticket {
    private String transNo;
    private String concertCode;
    private String seatNo;
    private String areaCode;
    private String customerId;
    private Date purchasedDate;
    private Time purchasedTime;
    private String ticketType;
    private String ticketRefundable;
    private BigDecimal discountedPrice;
    // Default constructor
    public Ticket() {}

    // Parameterized constructor
    public Ticket(String transNo, String concertCode, String seatNo, String areaCode, String customerId,
                  Date purchasedDate, Time purchasedTime, String ticketType, String ticketRefundable, BigDecimal discountedPrice) {
        this.transNo = transNo;
        this.concertCode = concertCode;
        this.seatNo = seatNo;
        this.areaCode = areaCode;
        this.customerId = customerId;
        this.purchasedDate = purchasedDate;
        this.purchasedTime = purchasedTime;
        this.ticketType = ticketType;
        this.ticketRefundable = ticketRefundable;
        this.discountedPrice = discountedPrice;
    }

    // Getters and Setters
    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getConcertCode() {
        return concertCode;
    }

    public void setConcertCode(String concertCode) {
        this.concertCode = concertCode;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(Date purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public Time getPurchasedTime() {
        return purchasedTime;
    }

    public void setPurchasedTime(Time purchasedTime) {
        this.purchasedTime = purchasedTime;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketRefundable() {
        return ticketRefundable;
    }

    public void setTicketRefundable(String ticketRefundable) {
        this.ticketRefundable = ticketRefundable;
    }

    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(transNo).append(" \t | ").append(concertCode).append(" \t | ")
                .append(seatNo).append(" \t | ").append(areaCode).append(" \t | ")
                .append(customerId).append(" \t | ").append(purchasedDate).append(" \t | ")
                .append(purchasedTime).append(" \t | ").append(ticketType).append(" \t | ")
                .append(ticketRefundable).append(" \t | ").append(discountedPrice);
        return builder.toString();
    }
}
