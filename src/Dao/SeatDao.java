package Dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import databases.*;
public class SeatDao {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/TeamProject?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	private String user = "root";
	private String password = "8501";

	//회원 전체 조회 
	public ArrayList<Seat> selectList(){
	    //1. JDBC Driver 로딩
	    try {
	        Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	 
	    ArrayList<Seat> list = null; //결과데이터를 담을 배열
	    String sql = "select * from Seat"; //SQL문
	    try(Connection conn = DriverManager.getConnection(url, user, password); //2. DB서버 연결
	        Statement stmt = conn.createStatement(); 			//3. SQL 실행 통로 형성
	        ResultSet rs = stmt.executeQuery(sql);
	        ) {
	 
	        //5. SQL 결과 처리
	        list = new ArrayList<>();
	        while(rs.next()) {
	            String Seat_No   = rs.getString("Seat_No");
                String Area_Code   = rs.getString("Area_Code");
                String Seat_Row   = rs.getString("Seat_Row");
                String Seat_Col    = rs.getString("Seat_Col");
                
                Seat dto = new Seat( Seat_No,  Area_Code,  Seat_Row,  Seat_Col);
                list.add(dto);
	        }
	 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
}

