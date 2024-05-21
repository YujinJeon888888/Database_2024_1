package Dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import databases.*;
public class ConcertShowingDao {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/TeamProject?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	private String user = "root";
	private String password = "8501";

	//회원 전체 조회 
	public ArrayList<ConcertShowing> selectList(){
	    //1. JDBC Driver 로딩
	    try {
	        Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	 
	    ArrayList<ConcertShowing> list = null; //결과데이터를 담을 배열
	    String sql = "select * from CONCERT_SHOWING"; //SQL문
	    try(Connection conn = DriverManager.getConnection(url, user, password); //2. DB서버 연결
	        Statement stmt = conn.createStatement(); 			//3. SQL 실행 통로 형성
	        ResultSet rs = stmt.executeQuery(sql);
	        ) {
	 
	        //5. SQL 결과 처리
	        list = new ArrayList<>();
	        while(rs.next()) {
	            String Concert_Code  = rs.getString("Concert_Code");
                String Concert_Title  = rs.getString("Concert_Title");
                String Venue_Code  = rs.getString("Venue_Code");
            
                Date Concert_Date  = rs.getDate("Concert_Date");
                Time Concert_StartTime  = rs.getTime("Concert_StartTime");
                Time Concert_EndTime   = rs.getTime("Concert_EndTime");

               
                
                ConcertShowing dto = new ConcertShowing(Concert_Code, Concert_Title, Concert_Date, Concert_StartTime, Concert_EndTime, Venue_Code);
                list.add(dto);
	        }
	 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
}

