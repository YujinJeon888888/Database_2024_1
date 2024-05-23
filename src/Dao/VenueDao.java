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
            System.out.println("Venue inserted successfully"); // ���⿡ �߰��մϴ�

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	//ȸ�� ��ü ��ȸ 
	public ArrayList<Venue> selectList(){
	    //1. JDBC Driver �ε�
	    try {
	        Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	 
	    ArrayList<Venue> list = null; //��������͸� ���� �迭
	    String sql = "select * from Venue"; //SQL��
	    try(Connection conn = DriverManager.getConnection(url, user, password); //2. DB���� ����
	        Statement stmt = conn.createStatement(); 			//3. SQL ���� ��� ����
	        ResultSet rs = stmt.executeQuery(sql);
	        ) {
	 
	        //5. SQL ��� ó��
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

