package Dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import databases.*;
public class CustomerDao {
	private String driver = UrlUserPassword.driver;
	private String url = UrlUserPassword.url;
	private String user = UrlUserPassword.user;
	private String password = UrlUserPassword.password;
	// ȸ�� ���� ����
    public void insertCustomer(String customerId, String firstName, String lastName, int age, String gender, String phone, String cashierId, int locationId) {
        // 1. JDBC Driver �ε�
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO Customer (Customer_ID, Customer_FirstName, Customer_LastName, Customer_Age, Customer_Gender, Customer_Phone, Cashier_ID, Location_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, customerId);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setInt(4, age);
            pstmt.setString(5, gender);
            pstmt.setString(6, phone);
            pstmt.setString(7, cashierId);
            pstmt.setInt(8, locationId);

            pstmt.executeUpdate();
            System.out.println("Customer inserted successfully"); // ���⿡ �߰��մϴ�

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	//ȸ�� ��ü ��ȸ 
	public ArrayList<Customer> selectList(){
	    //1. JDBC Driver �ε�
	    try {
	        Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	 
	    ArrayList<Customer> list = null; //��������͸� ���� �迭
	    String sql = "select * from Customer"; //SQL��
	    try(Connection conn = DriverManager.getConnection(url, user, password); //2. DB���� ����
	        Statement stmt = conn.createStatement(); 			//3. SQL ���� ��� ����
	        ResultSet rs = stmt.executeQuery(sql);
	        ) {
	 
	        //5. SQL ��� ó��
	        list = new ArrayList<>();
	        while(rs.next()) {
	            String Customer_ID  = rs.getString("Customer_ID");
                String Customer_FirstName     = rs.getString("Customer_FirstName");
                String Customer_LastName      = rs.getString("Customer_LastName");
                String Customer_Gender       = rs.getString("Customer_Gender");
                String Customer_Phone        = rs.getString("Customer_Phone");
                String Cashier_ID         = rs.getString("Cashier_ID");
                
                Integer Customer_Age = rs.getInt("Customer_Age");
                Integer Location_ID  = rs.getInt("Location_ID");
                
                Customer dto = new Customer( Customer_ID,  Customer_FirstName,  Customer_LastName,  Customer_Age,
                		Customer_Gender,  Customer_Phone,  Cashier_ID,  Location_ID);
                list.add(dto);
	        }
	 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
}

