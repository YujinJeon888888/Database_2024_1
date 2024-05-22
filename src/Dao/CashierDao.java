package Dao;

import java.sql.*;
import java.util.ArrayList;
import databases.Cashier;

public class CashierDao {
	private String driver = UrlUserPassword.driver;
	private String url = UrlUserPassword.url;
	private String user = UrlUserPassword.user;
	private String password = UrlUserPassword.password;
    // Cashier ��ü ��ȸ 
    public ArrayList<Cashier> selectList() {
        // 1. JDBC Driver �ε�
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
     
        ArrayList<Cashier> list = null; // ��� �����͸� ���� �迭
        String sql = "SELECT * FROM Cashier"; // SQL��
        try(Connection conn = DriverManager.getConnection(url, user, password); // 2. DB���� ����
            Statement stmt = conn.createStatement(); // 3. SQL ���� ��� ����
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            // 5. SQL ��� ó��
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
