package Dao;
import java.sql.*;
import java.util.ArrayList;

import databases.*;
public class VenueDao {
	private String driver = UrlUserPassword.driver;
	private String url = UrlUserPassword.url;
	private String user = UrlUserPassword.user;
	private String password = UrlUserPassword.password;
	// insert
    public void insertVenue(String venueCode, String venueDescription, String venueCity, String venueState, String venuePostCode) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO Venue (Venue_Code, Venue_Description, Venue_City, Venue_State, Venue_PostCode) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, venueCode);
            pstmt.setString(2, venueDescription);
            pstmt.setString(3, venueCity);
            pstmt.setString(4, venueState);
            pstmt.setString(5, venuePostCode);

            pstmt.executeUpdate();
            System.out.println("Venue inserted successfully"); // 여기에 추가합니다

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	//회원 전체 조회 
	public ArrayList<Venue> selectList(){
	    //1. JDBC Driver 로딩
	    try {
	        Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	 
	    ArrayList<Venue> list = null; //결과데이터를 담을 배열
	    String sql = "select * from Venue"; //SQL문
	    try(Connection conn = DriverManager.getConnection(url, user, password); //2. DB서버 연결
	        Statement stmt = conn.createStatement(); 			//3. SQL 실행 통로 형성
	        ResultSet rs = stmt.executeQuery(sql);
	        ) {
	 
	        //5. SQL 결과 처리
	        list = new ArrayList<>();
	        while(rs.next()) {
	            String Venue_Code = rs.getString("Venue_Code");
	            String Venue_Description = rs.getString("Venue_Description");
	            String Venue_City = rs.getString("Venue_City");
	            String Venue_State = rs.getString("Venue_State");
	            String Venue_PostCode = rs.getString("Venue_PostCode");
	            
	            Venue dto = new Venue(Venue_Code, Venue_Description, Venue_City, Venue_State, Venue_PostCode);
	 
	            list.add(dto);
	        }
	 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
}

