import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class JDBCText02{
	public static void main(String[] args){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bts?useSSL=false","root","1424114642BTS");
			
			stmt = conn.createStatement();
			String sql = "select * from dept";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.print(rs.getString(1)+' ');
				System.out.print(rs.getString(2)+' ');
				System.out.println(rs.getString(3));
			}		
		}catch(Exception e){
			e.printStackTrace();

		}finally{
			if(rs != null){
				try{
					rs.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(stmt != null){
				try{
					stmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}
}