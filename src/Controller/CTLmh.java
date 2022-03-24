package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connJDBC.connJDBCqld;
import model.monhoc;

public class CTLmh extends connJDBCqld{
	public static List<monhoc>findAll(){
		List<monhoc>monhoclist = new ArrayList<>();
		String query = "select * from monhoc";
		try {
			Connection conn =getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				monhoc mh = new monhoc(rs.getString("MAMH"),rs.getString("TENMH"),rs.getInt("SOTINCHI"));
				monhoclist.add(mh);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return monhoclist;
	}
	public static void insert(monhoc mh) {
		String query = "insert into monhoc (MAMH,TENMH,SOTINCHI) values(?,?,?)";
		try {
			Connection conn =getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mh.getMAMH());
			pstmt.setString(2, mh.getTENMH());
			pstmt.setInt(3, mh.getSOTINCHI());
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void update(monhoc mh) {
		String query = "update monhoc set MAMH = ?,TENMH = ?, SOTINCHI = ? where MAMH ='"+mh.getMAMH()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mh.getMAMH());
			pstmt.setString(2, mh.getTENMH());
			pstmt.setInt(3, mh.getSOTINCHI());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void delete(monhoc mh) {
		String query = "delete from monhoc where MAMH = '"+mh.getMAMH()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
