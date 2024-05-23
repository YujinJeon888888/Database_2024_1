package Dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import databases.*;
public class AreaDao {
	private String driver = UrlUserPassword.driver;
	private String url = UrlUserPassword.url;
	private String user = UrlUserPassword.user;
	private String password = UrlUserPassword.password;

	//insert
    public ArrayList<Area> insertArea(String areaCode, String areaDescription, BigDecimal price) {
        // 1. JDBC Driver 로딩
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Area> list = new ArrayList<>(); // Initialize the ArrayList

        String sql = "INSERT INTO AREA (Area_Code, Area_Description, Price) VALUES (?, ?, ?)"; // SQL statement

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the values for the prepared statement
            pstmt.setString(1, areaCode);
            pstmt.setString(2, areaDescription);
            pstmt.setBigDecimal(3, price);

            // Execute the update
            pstmt.executeUpdate();
            System.out.println("Area inserted successfully"); // 여기에 추가합니다
            // Optionally, you can retrieve the inserted record and add it to the list
            Area area = new Area(areaCode, areaDescription, price);
            list.add(area);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }	
	//회원 전체 조회 
	public ArrayList<Area> selectList(){
	    //1. JDBC Driver 로딩
	    try {
	        Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	 
	    ArrayList<Area> list = null; //결과데이터를 담을 배열
	    String sql = "select * from Area"; //SQL문
	    try(Connection conn = DriverManager.getConnection(url, user, password); //2. DB서버 연결
	        Statement stmt = conn.createStatement(); 			//3. SQL 실행 통로 형성
	        ResultSet rs = stmt.executeQuery(sql);
	        ) {
	 
	        //5. SQL 결과 처리
	        list = new ArrayList<>();
	        while(rs.next()) {
	            String Area_Code = rs.getString("Area_Code");
                String Area_Description    = rs.getString("Area_Description");
                BigDecimal Price  = rs.getBigDecimal("Price");
                Area dto = new Area(Area_Code, Area_Description, Price);
                list.add(dto);
	        }
	 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
}

