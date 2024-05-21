package Dao;

import java.sql.*;
import java.util.ArrayList;
import databases.SalesLocation;

public class SalesLocationDao {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/TeamProject?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
    private String user = "root";
    private String password = "8501";

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
