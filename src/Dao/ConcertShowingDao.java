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
	 // �ܼ�Ʈ �߰� �޼���
    public void insertConcertShowing(String concertCode, String concertTitle, Date concertDate, Time concertStartTime, Time concertEndTime, String venueCode) {
        // 1. JDBC Driver �ε�
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //(Concert_Code, Concert_Title, Concert_Date, Concert_StartTime, Concert_EndTime, Venue_Code) 
        String sql = "INSERT INTO CONCERT_SHOWING (Concert_Code, Concert_Title, Concert_Date, Concert_StartTime, Concert_EndTime, Venue_Code) VALUES (?, ?, ?, ?, ?, ?)"; // SQL��

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // PreparedStatement�� ���� ����
            pstmt.setString(1, concertCode);
            pstmt.setString(2, concertTitle);
            pstmt.setDate(3, concertDate);
            pstmt.setTime(4, concertStartTime);
            pstmt.setTime(5, concertEndTime);
            pstmt.setString(6, venueCode);

            // SQL ����
            pstmt.executeUpdate();
            System.out.println("ConcertShowing inserted successfully"); // ���⿡ �߰��մϴ�
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	//ȸ�� ��ü ��ȸ 
	public ArrayList<ConcertShowing> selectList(){
	    //1. JDBC Driver �ε�
	    try {
	        Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	 
	    ArrayList<ConcertShowing> list = null; //��������͸� ���� �迭
	    String sql = "select * from CONCERT_SHOWING"; //SQL��
	    try(Connection conn = DriverManager.getConnection(url, user, password); //2. DB���� ����
	        Statement stmt = conn.createStatement(); 			//3. SQL ���� ��� ����
	        ResultSet rs = stmt.executeQuery(sql);
	        ) {
	 
	        //5. SQL ��� ó��
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

