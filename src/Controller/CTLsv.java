package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connJDBC.connJDBCqld;
import model.sinhvien;

public class CTLsv extends connJDBCqld{
	 public static List<sinhvien>findAll(){
		 List<sinhvien>sinhvienList= new ArrayList<>();
		 String query = "select * from sinhvien";
		 try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				sinhvien sv = new sinhvien(rs.getString("MASV"),rs.getString("TENSV"),rs.getInt("GIOITINH"),rs.getString("NGAYSINH"),rs.getString("QUEQUAN"),rs.getString("SDT"),rs.getString("MALOP"));
				sinhvienList.add(sv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sinhvienList;
	 }
	 public static void insert(sinhvien sv) {
		String query = "insert into sinhvien(MASV,TENSV,GIOITINH,NGAYSINH,QUEQUAN,SDT,MALOP) values(?,?,?,?,?,?,?) ";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sv.getMASV());
			pstmt.setString(2, sv.getTENSV());
			pstmt.setInt(3, sv.getGIOITINH());
			pstmt.setString(4, sv.getNGAYSINH());
			pstmt.setString(5, sv.getQUEQUAN());
			pstmt.setString(6, sv.getSDT());
			pstmt.setString(7, sv.getMALOP());
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }
	 public static void update(sinhvien sv) {
		 String query = "update sinhvien set MASV = ?,TENSV = ?,GIOITINH = ?,NGAYSINH = ?,QUEQUAN = ?,SDT = ?,MALOP = ? where MASV = '"+sv.getMASV()+"'";
		 try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sv.getMASV());
			pstmt.setString(2, sv.getTENSV());
			pstmt.setInt(3, sv.getGIOITINH());
			pstmt.setString(4, sv.getNGAYSINH());
			pstmt.setString(5, sv.getQUEQUAN());
			pstmt.setString(6, sv.getSDT());
			pstmt.setString(7, sv.getMALOP());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }
	 public static void delete(sinhvien sv) {
		 String query = "delete from sinhvien where MASV ='"+sv.getMASV()+"'";
		 try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }
	 public static void chon(sinhvien sv) {
		 String query = "select MASV = ? from sinhvien where MASV = '"+sv.getMASV()+"' ";
		 try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }
	 public static void refresh(sinhvien sv) {
		 String query = "select * from sinhvien";
		 try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }
	 public static List<sinhvien>findbyMASV(sinhvien sv1){
		List<sinhvien>sinhvientl = new ArrayList<>();
		String query = "select * from sinhvien where sinhvien.MASV = '"+sv1.getMASV()+"'";
		try {
			Connection conn = getConnection();
			Statement pstmt = conn.createStatement();
			ResultSet rs = pstmt.executeQuery(query);
			while (rs.next()) {
				sinhvien sv = new sinhvien(rs.getString("MASV"),rs.getString("TENSV"),rs.getInt("GIOITINH"),rs.getString("NGAYSINH"),rs.getString("QUEQUAN"),rs.getString("SDT"),rs.getString("MALOP"));
				sinhvientl.add(sv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sinhvientl; 
	 }

}
