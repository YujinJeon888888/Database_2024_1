package Dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import databases.*;
public class ConcertShowingDao {
	private String driver = UrlUserPassword.driver;
	private String url = UrlUserPassword.url;
	private String user = UrlUserPassword.user;
	private String password = UrlUserPassword.password;
	 // 콘서트 추가 메서드
    public void insertConcertShowing(String concertCode, String concertTitle, Date concertDate, Time concertStartTime, Time concertEndTime, String venueCode) {
        // 1. JDBC Driver 로딩
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //(Concert_Code, Concert_Title, Concert_Date, Concert_StartTime, Concert_EndTime, Venue_Code) 
        String sql = "INSERT INTO CONCERT_SHOWING (Concert_Code, Concert_Title, Concert_Date, Concert_StartTime, Concert_EndTime, Venue_Code) VALUES (?, ?, ?, ?, ?, ?)"; // SQL문

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // PreparedStatement에 값을 설정
            pstmt.setString(1, concertCode);
            pstmt.setString(2, concertTitle);
            pstmt.setDate(3, concertDate);
            pstmt.setTime(4, concertStartTime);
            pstmt.setTime(5, concertEndTime);
            pstmt.setString(6, venueCode);

            // SQL 실행
            pstmt.executeUpdate();
            System.out.println("ConcertShowing inserted successfully"); // 여기에 추가합니다
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	//회원 전체 조회 
	public ArrayList<ConcertShowing> selectList(){
	    //1. JDBC Driver 로딩
	    try {
	        Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	 
	    ArrayList<ConcertShowing> list = null; //결과데이터를 담을 배열
	    String sql = "select * from CONCERT_SHOWING"; //SQL문
	    try(Connection conn = DriverManager.getConnection(url, user, password); //2. DB서버 연결
	        Statement stmt = conn.createStatement(); 			//3. SQL 실행 통로 형성
	        ResultSet rs = stmt.executeQuery(sql);
	        ) {
	 
	        //5. SQL 결과 처리
	        list = new ArrayList<>();
	        while(rs.next()) {
	            String Concert_Code  = rs.getString("Concert_Code");
                String Concert_Title  = rs.getString("Concert_Title");
                String Venue_Code  = rs.getString("Venue_Code");
            
                Date Concert_Date  = rs.getDate("Concert_Date");
                Time Concert_StartTime  = rs.getTime("Concert_StartTime");
                Time Concert_EndTime   = rs.getTime("Concert_EndTime");

               
                
                ConcertShowing dto = new ConcertShowing(Concert_Code, Concert_Title, Concert_Date, Concert_StartTime, Concert_EndTime, Venue_Code);
                list.add(dto);
	        }
	 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
}

