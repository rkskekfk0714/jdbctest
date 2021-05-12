package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;

public class DBConnect02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{ 
			//String url = "jdbc:mysql://localhost/world?characterEncoding=UTF-8&serverTimezone=UTC";
			String url = "jdbc:mysql://localhost/?characterEncoding=UTF-8&serverTimezone=UTC";
			String user = "root"; 
			String passwd = "1234";			
			Connection con = null;
			String sql = "select * from oneline";
			PreparedStatement pstmt = null;
			PreparedStatement pstmt2 = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, passwd); 
			
			pstmt2 = con.prepareStatement("use world");
			pstmt2.executeUpdate();
			pstmt2.close();
			
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();	//select
			while(rs.next()) {
				int no = rs.getInt(1);
				String memo = rs.getString(2);
				String wdate = rs.getString(3);
				
				System.out.println(no + ": " + memo + " :(" + wdate + ")");
			}
			rs.close();
			pstmt.close();
			/*pstmt.executeQuery();	//select
			pstmt.executeUpdate();	//insert, delete, update, 기타...			
			*/
			
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
