package Dao;

import java.sql.*;
import java.util.ArrayList;
import databases.Cashier;

public class CashierDao {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/TeamProject?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
    private String user = "root";
    private String password = "8501";

    // Cashier 전체 조회 
    public ArrayList<Cashier> selectList() {
        // 1. JDBC Driver 로딩
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
     
        ArrayList<Cashier> list = null; // 결과 데이터를 담을 배열
        String sql = "SELECT * FROM Cashier"; // SQL문
        try(Connection conn = DriverManager.getConnection(url, user, password); // 2. DB서버 연결
            Statement stmt = conn.createStatement(); // 3. SQL 실행 통로 형성
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            // 5. SQL 결과 처리
            list = new ArrayList<>();
            while(rs.next()) {
                String cashierId = rs.getString("Cashier_ID");
                int locationId = rs.getInt("Location_ID");
                String cashierFirstName = rs.getString("Cashier_FirstName");
                String cashierLastName = rs.getString("Cashier_LastName");
                String cashierGender = rs.getString("Cashier_Gender");
                String counterNum = rs.getString("Counter_Num");

                Cashier dto = new Cashier(cashierId, locationId, cashierFirstName, cashierLastName, cashierGender, counterNum);
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
