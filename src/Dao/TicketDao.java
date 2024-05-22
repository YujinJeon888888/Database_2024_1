package Dao;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import databases.*;
public class TicketDao {
	private String driver = UrlUserPassword.driver;
	private String url = UrlUserPassword.url;
	private String user = UrlUserPassword.user;
	private String password = UrlUserPassword.password;

	//ȸ�� ��ü ��ȸ 
	public ArrayList<Ticket> selectList(){
	    //1. JDBC Driver �ε�
	    try {
	        Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	 
	    ArrayList<Ticket> list = null; //��������͸� ���� �迭
	    String sql = "select * from Ticket"; //SQL��
	    try(Connection conn = DriverManager.getConnection(url, user, password); //2. DB���� ����
	        Statement stmt = conn.createStatement(); 			//3. SQL ���� ��� ����
	        ResultSet rs = stmt.executeQuery(sql);
	        ) {
	 
	        //5. SQL ��� ó��
	        list = new ArrayList<>();
	        while(rs.next()) {
	            String transNo = rs.getString("Trans_No");
                String concertCode = rs.getString("Concert_Code");
                String seatNo = rs.getString("Seat_No");
                String areaCode = rs.getString("Area_Code");
                String customerId = rs.getString("Customer_ID");
                Date purchasedDate = rs.getDate("Purchased_Date");
                Time purchasedTime = rs.getTime("Purchased_Time");
                String ticketType = rs.getString("Ticket_Type");
                String ticketRefundable = rs.getString("Ticket_Refundable");
                BigDecimal discountedPrice = rs.getBigDecimal("Discounted_Price");
                
                Ticket dto = new Ticket( transNo,  concertCode,  seatNo,  areaCode,  customerId,
                         purchasedDate,  purchasedTime,  ticketType,  ticketRefundable,  discountedPrice);
                list.add(dto);
	        }
	 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
}

