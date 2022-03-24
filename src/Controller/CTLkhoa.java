package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connJDBC.connJDBCqld;
import model.khoa;

public class CTLkhoa extends connJDBCqld{
	public static List<khoa>findAll()
	{
		List<khoa>khoaList = new ArrayList<>();
		String query = "select * from khoa";
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(query);
			while (rs.next()) {
				khoa k = new khoa(rs.getString("MAK"),rs.getString("TENK"),rs.getString("SDT"));
				khoaList.add(k);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return khoaList;
	}
	public static void insert(khoa k) {
		String query = "insert into khoa (MAK,TENK,SDT) values(?,?,?)";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, k.getMAK());
			pstmt.setString(2, k.getTENK());
			pstmt.setString(3, k.getSDT());
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void update(khoa k) {
		String query = "update khoa set MAK = ?,TENK = ?,SDT = ? where MAK ='"+k.getMAK()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, k.getMAK());
			pstmt.setString(2, k.getTENK());
			pstmt.setString(3, k.getSDT());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void delete(khoa k) {
		String query = "delete from khoa where MAK = '"+k.getMAK()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
