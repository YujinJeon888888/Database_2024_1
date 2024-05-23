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
        // 1. JDBC Driver �ε�
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
            System.out.println("Area inserted successfully"); // ���⿡ �߰��մϴ�
            // Optionally, you can retrieve the inserted record and add it to the list
            Area area = new Area(areaCode, areaDescription, price);
            list.add(area);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }	
	//ȸ�� ��ü ��ȸ 
	public ArrayList<Area> selectList(){
	    //1. JDBC Driver �ε�
	    try {
	        Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	 
	    ArrayList<Area> list = null; //��������͸� ���� �迭
	    String sql = "select * from Area"; //SQL��
	    try(Connection conn = DriverManager.getConnection(url, user, password); //2. DB���� ����
	        Statement stmt = conn.createStatement(); 			//3. SQL ���� ��� ����
	        ResultSet rs = stmt.executeQuery(sql);
	        ) {
	 
	        //5. SQL ��� ó��
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

