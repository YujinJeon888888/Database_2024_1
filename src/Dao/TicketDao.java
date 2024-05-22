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

	//회원 전체 조회 
	public ArrayList<Ticket> selectList(){
	    //1. JDBC Driver 로딩
	    try {
	        Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	 
	    ArrayList<Ticket> list = null; //결과데이터를 담을 배열
	    String sql = "select * from Ticket"; //SQL문
	    try(Connection conn = DriverManager.getConnection(url, user, password); //2. DB서버 연결
	        Statement stmt = conn.createStatement(); 			//3. SQL 실행 통로 형성
	        ResultSet rs = stmt.executeQuery(sql);
	        ) {
	 
	        //5. SQL 결과 처리
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

