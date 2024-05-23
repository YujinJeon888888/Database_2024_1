package Dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import databases.*;
public class SeatDao {
	private String driver = UrlUserPassword.driver;
	private String url = UrlUserPassword.url;
	private String user = UrlUserPassword.user;
	private String password = UrlUserPassword.password;
	// insert
    public void insertSeat(String seatNo, String areaCode, String seatRow, String seatCol) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO Seat (Seat_No, Area_Code, Seat_Row, Seat_Col) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, seatNo);
            pstmt.setString(2, areaCode);
            pstmt.setString(3, seatRow);
            pstmt.setString(4, seatCol);

            pstmt.executeUpdate();
            System.out.println("Seat inserted successfully"); // ���⿡ �߰��մϴ�

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	//ȸ�� ��ü ��ȸ 
	public ArrayList<Seat> selectList(){
	    //1. JDBC Driver �ε�
	    try {
	        Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	 
	    ArrayList<Seat> list = null; //��������͸� ���� �迭
	    String sql = "select * from Seat"; //SQL��
	    try(Connection conn = DriverManager.getConnection(url, user, password); //2. DB���� ����
	        Statement stmt = conn.createStatement(); 			//3. SQL ���� ��� ����
	        ResultSet rs = stmt.executeQuery(sql);
	        ) {
	 
	        //5. SQL ��� ó��
	        list = new ArrayList<>();
	        while(rs.next()) {
	            String Seat_No   = rs.getString("Seat_No");
                String Area_Code   = rs.getString("Area_Code");
                String Seat_Row   = rs.getString("Seat_Row");
                String Seat_Col    = rs.getString("Seat_Col");
                
                Seat dto = new Seat( Seat_No,  Area_Code,  Seat_Row,  Seat_Col);
                list.add(dto);
	        }
	 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
}

