import java.sql.*;
import java.util.*;

public class JDBCText03{
	public static void main(String[] args){
		ResourceBundle bundle = ResourceBundle.getBundle("JDBC");
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");

		Connection conn = null;
		Statement stmt = null;

		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url+"?useSSL=false",user,password);
			System.out.println(conn);

		}catch(Exception e){
			e.printStackTrace();
		}finally{
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