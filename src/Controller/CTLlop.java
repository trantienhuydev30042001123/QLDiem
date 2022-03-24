package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connJDBC.connJDBCqld;
import model.lop; 
public class CTLlop extends connJDBCqld{
	public static List<lop>
	findAll(){
		List<lop>loplist = new ArrayList<>();
		String query = "select * from lop";
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lop l = new lop(rs.getString("MALOP"),rs.getString("TENLOP"),rs.getString("MAK"));
				loplist.add(l);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return loplist;
		
	}
	public static void insert(lop l) {
		String query = "insert into lop(MALOP,TENLOP,MAK) values(?,?,?)";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, l.getMALOP());
			pstmt.setString(2, l.getTENLOP());
			pstmt.setString(3, l.getMAK());
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void update(lop l) {
		String query = "update lop set MALOP = ?, TENLOP = ?, MAK = ? where MALOP = '"+l.getMALOP()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, l.getMALOP());
			pstmt.setString(2, l.getTENLOP());
			pstmt.setString(3, l.getMAK());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void delete(lop l) {
		String query = "delete from lop where MALOP = '"+l.getMALOP()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
