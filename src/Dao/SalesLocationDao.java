package Dao;

import java.sql.*;
import java.util.ArrayList;
import databases.SalesLocation;

public class SalesLocationDao {
	private String driver = UrlUserPassword.driver;
	private String url = UrlUserPassword.url;
	private String user = UrlUserPassword.user;
	private String password = UrlUserPassword.password;
	 // insert
    public ArrayList<SalesLocation> insertSalesLocation(String locationDescription, String locationCity, String locationState, String locationPostCode) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<SalesLocation> list = new ArrayList<>();
        String sql = "INSERT INTO SALES_LOCATION (Location_Description, Location_City, Location_State, Location_PostCode) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, locationDescription);
            pstmt.setString(2, locationCity);
            pstmt.setString(3, locationState);
            pstmt.setString(4, locationPostCode);

            pstmt.executeUpdate();
            System.out.println("SalesLocation inserted successfully"); // 여기에 추가합니다
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int locationId = rs.getInt(1);
                SalesLocation salesLocation = new SalesLocation(locationId, locationDescription, locationCity, locationState, locationPostCode);
                list.add(salesLocation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    // SalesLocation 전체 조회 
    public ArrayList<SalesLocation> selectList() {
        // 1. JDBC Driver 로딩
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
     
        ArrayList<SalesLocation> list = null; // 결과 데이터를 담을 배열
        String sql = "SELECT * FROM SALES_LOCATION"; // SQL문
        try (Connection conn = DriverManager.getConnection(url, user, password); // 2. DB서버 연결
             Statement stmt = conn.createStatement(); // 3. SQL 실행 통로 형성
             ResultSet rs = stmt.executeQuery(sql);
        ) {
            // 5. SQL 결과 처리
            list = new ArrayList<>();
            while (rs.next()) {
                int locationId = rs.getInt("Location_ID");
                String locationDescription = rs.getString("Location_Description");
                String locationCity = rs.getString("Location_City");
                String locationState = rs.getString("Location_State");
                String locationPostCode = rs.getString("Location_PostCode");

                SalesLocation dto = new SalesLocation(locationId, locationDescription, locationCity, locationState, locationPostCode);
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
