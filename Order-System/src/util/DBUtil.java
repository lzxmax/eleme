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
			/*�������ݿ���˺ţ�user�˺ŵĸ�ʽ����δ�������޸Ŀ���Ϊroot������޸ģ��ĳ��ĸ���Ϊ�ĸ�*/
			String user="root";
			/*�������ݿ�����룬����Ļ�����ɶ�������ɶ��*/
			String password="mysql0az9lzx";
			//ִ��sql����
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
