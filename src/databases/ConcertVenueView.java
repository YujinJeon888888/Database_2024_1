package databases;
import java.sql.Date;
public class ConcertVenueView {
	private String concertTitle;
    private Date concertDate;
    private String venueDescription;

    public ConcertVenueView(String concertTitle, Date concertDate, String venueDescription) {
        this.concertTitle = concertTitle;
        this.concertDate = concertDate;
        this.venueDescription = venueDescription;
    }

    // Getters and setters
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

    public String getVenueDescription() {
        return venueDescription;
    }

    public void setVenueDescription(String venueDescription) {
        this.venueDescription = venueDescription;
    }
    
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(concertTitle).append(" \t | ")
               .append(concertDate).append(" \t | ")
               .append(venueDescription);
        return builder.toString();
    }
}
