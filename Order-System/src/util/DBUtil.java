package util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getconn() {
		Connection conn=null;
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/info";
			/*连接数据库的账号，user账号的格式，如未经特殊修改可以为root，如果修改，改成哪个即为哪个*/
			String user="root";
			/*连接数据库的密码，密码的话设置啥密码就是啥咯*/
			String password="mysql0az9lzx";
			//执行sql对象
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
	
	public static void closeAll(Connection conn,Statement stmt) {
		try {
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
