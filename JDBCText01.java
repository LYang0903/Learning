import java.sql.Driver;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCText01{
	public static void main(String[] args){
		Connection conn = null;
		Statement stmt = null;
		try{
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			String url = "jdbc:mysql://127.0.0.1:3306/bts";
			String root = "root";
			String pwd = "1424114642BTS";
			conn = DriverManager.getConnection(url,root,pwd);
			System.out.println("数据库对象"+ conn);
			stmt = conn.createStatement();
			String sql = "insert into dept(deptno,deptname,loc) values(52,'人人部','北京')";
			int count = stmt.executeUpdate(sql);
			System.out.println(count==1? "success":"fail");
		}catch(SQLException e){
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