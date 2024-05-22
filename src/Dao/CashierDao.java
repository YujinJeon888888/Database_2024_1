package Dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import databases.Area;
import databases.Cashier;

public class CashierDao {
	private String driver = UrlUserPassword.driver;
	private String url = UrlUserPassword.url;
	private String user = UrlUserPassword.user;
	private String password = UrlUserPassword.password;
	//insert
    public ArrayList<Cashier> insertCashier(String cashierId, int locationId, String cashierFirstName, String cashierLastName, String cashierGender, String counterNum) {
        // 1. JDBC Driver 로딩
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Cashier> list = new ArrayList<>(); // Initialize the ArrayList

        String sql = "INSERT INTO CASHIER  (Cashier_ID, Location_ID, Cashier_FirstName, Cashier_LastName, Cashier_Gender, Counter_Num) VALUES (?, ?, ?, ?, ?, ?)"; // SQL statement

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the values for the prepared statement
            pstmt.setString(1, cashierId);
            pstmt.setInt(2, locationId);
            pstmt.setString(3, cashierFirstName);
            pstmt.setString(4, cashierLastName);
            pstmt.setString(5, cashierGender);
            pstmt.setString(6, counterNum);


            // Execute the update
            pstmt.executeUpdate();

            // Optionally, you can retrieve the inserted record and add it to the list
            Cashier cashier = new Cashier(cashierId, locationId, cashierFirstName, cashierLastName, cashierGender, counterNum);
            list.add(cashier);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }	

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
