package Select;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import databases.*;
import Dao.UrlUserPassword;

public class SelectMenu {
	private String driver = UrlUserPassword.driver;
	private String url = UrlUserPassword.url;
	private String user = UrlUserPassword.user;
	private String password = UrlUserPassword.password;
	
	//select: 사용자 입력을 기반으로 조인 및 뷰를 사용하는 쿼리 - ConcertVenueView
    public ArrayList<ConcertVenueView> selectConcertTitleDate(String concertTitle) {
        // 1. JDBC Driver 로딩
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<ConcertVenueView> list = new ArrayList<>(); // Initialize the ArrayList

        String sql = "select cv.concert_title, cv.concert_date, cv.venue_description"
        		+ " from concertvenue_view cv"
        		+ " join concert_showing cs on cv.concert_title = cs.concert_title"
        		+ " where cs.concert_title=?"; // SQL statement

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the values for the prepared statement
            pstmt.setString(1, concertTitle);
            // Execute the update
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Selected successfully"); // 여기에 추가합니다
            // Optionally, you can retrieve the inserted record and add it to the list
            // Process the result set and add to the list
            while (rs.next()) {
                String title = rs.getString("Concert_Title");
                Date date = rs.getDate("Concert_Date");
                String venueDescription = rs.getString("Venue_Description");

                ConcertVenueView concertVenueView = new ConcertVenueView(title, date, venueDescription);
                
                list.add(concertVenueView);
            }    
       
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }	
	
}
