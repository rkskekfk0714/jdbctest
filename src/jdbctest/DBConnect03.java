package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{ 
			String url = "jdbc:mysql://localhost/world?characterEncoding=UTF-8&serverTimezone=UTC";
			//String url = "jdbc:mysql://localhost/?characterEncoding=UTF-8&serverTimezone=UTC";
			String user = "root"; 
			String passwd = "1234";			
			Connection con = null;
			//String sql = "insert into oneline (no, memo) values(?, ?)";
			String sql = "insert into oneline (memo) values(?)";
			PreparedStatement pstmt = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, passwd); 
			pstmt = con.prepareStatement(sql);
			//sql = "delete from oneline where no = 4";
			//pstmt = con.prepareStatement(sql); 없애는 방법			
			//pstmt.setInt(1, 4);
			pstmt.setString(1, "안녕하세요");
			pstmt.executeUpdate();
			
			pstmt.close();			
			con.close(); 
			System.out.println("DB조회 성공"); 
		} 
		catch (SQLException e)
		{ 
			System.out.println("DB연결 실패"); 
			System.out.print("사유 : " + e.getMessage()); 
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
