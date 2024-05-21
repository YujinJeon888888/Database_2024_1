package Dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import databases.*;
public class CustomerDao {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/TeamProject?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	private String user = "root";
	private String password = "8501";

	//회원 전체 조회 
	public ArrayList<Customer> selectList(){
	    //1. JDBC Driver 로딩
	    try {
	        Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	 
	    ArrayList<Customer> list = null; //결과데이터를 담을 배열
	    String sql = "select * from Customer"; //SQL문
	    try(Connection conn = DriverManager.getConnection(url, user, password); //2. DB서버 연결
	        Statement stmt = conn.createStatement(); 			//3. SQL 실행 통로 형성
	        ResultSet rs = stmt.executeQuery(sql);
	        ) {
	 
	        //5. SQL 결과 처리
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

