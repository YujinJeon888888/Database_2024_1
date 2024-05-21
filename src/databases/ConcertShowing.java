package databases;

import java.sql.Date;
import java.sql.Time;

public class ConcertShowing {
    private String concertCode;
    private String concertTitle;
    private Date concertDate;
    private Time concertStartTime;
    private Time concertEndTime;
    private String venueCode;

    // Default constructor
    public ConcertShowing() {}

    // Parameterized constructor
    public ConcertShowing(String concertCode, String concertTitle, Date concertDate, Time concertStartTime, Time concertEndTime, String venueCode) {
        this.concertCode = concertCode;
        this.concertTitle = concertTitle;
        this.concertDate = concertDate;
        this.concertStartTime = concertStartTime;
        this.concertEndTime = concertEndTime;
        this.venueCode = venueCode;
    }

    // Getters and Setters
    public String getConcertCode() {
        return concertCode;
    }

    public void setConcertCode(String concertCode) {
        this.concertCode = concertCode;
    }

    public String getConcertTitle() {
        return concertTitle;
    }

    public void setConcertTitle(String concertTitle) {
        this.concertTitle = concertTitle;
    }

    public Date getConcertDate() {
        return concertDate;
    }

    public void setConcertDate(Date concertDate) {
        this.concertDate = concertDate;
    }

    public Time getConcertStartTime() {
        return concertStartTime;
    }

    public void setConcertStartTime(Time concertStartTime) {
        this.concertStartTime = concertStartTime;
    }

    public Time getConcertEndTime() {
        return concertEndTime;
    }

    public void setConcertEndTime(Time concertEndTime) {
        this.concertEndTime = concertEndTime;
    }

    public String getVenueCode() {
        return venueCode;
    }

    public void setVenueCode(String venueCode) {
        this.venueCode = venueCode;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(concertCode).append(" \t | ").append(concertTitle).append(" \t | ")
                .append(concertDate).append(" \t | ").append(concertStartTime).append(" \t | ")
                .append(concertEndTime).append(" \t | ").append(venueCode);
        return builder.toString();
    }
}
