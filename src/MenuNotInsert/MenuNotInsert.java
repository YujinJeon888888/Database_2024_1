package MenuNotInsert;

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

public class MenuNotInsert {
	private String driver = UrlUserPassword.driver;
	private String url = UrlUserPassword.url;
	private String user = UrlUserPassword.user;
	private String password = UrlUserPassword.password;
	
	//select: 사용자 입력을 기반으로 aggregation, group by를 사용하는 쿼리
    public void deleteCashierID(String casherID) {
        // 1. JDBC Driver 로딩
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "DELETE FROM CUSTOMER WHERE Cashier_ID = ?"; // SQL statement

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the values for the prepared statement
            pstmt.setString(1, casherID);
            // Execute the update
            pstmt.executeUpdate();
            System.out.println("Deleted successfully"); // 여기에 추가합니다
            // Optionally, you can retrieve the inserted record and add it to the list
            // Process the result set and add to the list
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }	

	
	//select: 사용자 입력을 기반으로 aggregation, group by를 사용하는 쿼리
    public ArrayList<String> selectConcertCodeCOUNT(String concertCode) {
        // 1. JDBC Driver 로딩
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> list = new ArrayList<>(); // Initialize the ArrayList

        String sql = "SELECT Concert_Code, COUNT(*) AS Total_Tickets_Sold FROM TICKET	WHERE Concert_Code =?  GROUP BY Concert_Code"; // SQL statement

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the values for the prepared statement
            pstmt.setString(1, concertCode);
            // Execute the update
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Selected successfully"); // 여기에 추가합니다
            // Optionally, you can retrieve the inserted record and add it to the list
            // Process the result set and add to the list
            while (rs.next()) {
                String Concert_Code = rs.getString("Concert_Code");
                int Total_Tickets_Sold = rs.getInt("Total_Tickets_Sold");

                String concertCode_RESULT = Concert_Code;
                int totalTicketsSold=Total_Tickets_Sold;
               
                
                list.add(concertCode_RESULT+"\t|"+totalTicketsSold+"\n");
            }    
       
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }	

	//select: 사용자 입력을 기반으로 조인 및 뷰를 사용하는 쿼리 - ConcertVenueView
    public ArrayList<String> selectConcertTitleDateVenueCode(String concertTitle) {
        // 1. JDBC Driver 로딩
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> list = new ArrayList<>(); // Initialize the ArrayList

        String sql = "select cv.concert_title, cv.venue_description, cs.Venue_Code"
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
                String venueDescription = rs.getString("Venue_Description");
                String Venue_Code = rs.getString("Venue_Code");
                
                
                
                list.add(title+"|\t"+venueDescription+"|\t"+Venue_Code+"\n");
            }    
       
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }	
	
}
