package connJDBC;

import java.sql.Connection;
import java.sql.DriverManager;


public class connJDBCqld {
	static String url = "jdbc:mysql://localhost:3306/qldiem";
	static String user = "root";
	static String password = "";
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (conn != null) {
			System.out.println("ket noi mysql thanh cong");
		} else {
			System.out.println("ket noi mysql khong thanh cong");
		}
		return conn;
	}
}