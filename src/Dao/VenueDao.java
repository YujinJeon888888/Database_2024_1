package Dao;
import java.sql.*;
import java.util.ArrayList;

import databases.*;
public class VenueDao {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/TeamProject?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	private String user = "root";
	private String password = "8501";

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

