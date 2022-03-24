package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connJDBC.connJDBCqld;
import model.ketqua;

public class CTLdiem extends connJDBCqld{
	public static List<ketqua>findAll(){
		List<ketqua>ketqualist = new ArrayList<>();
		String query = "select * from ketqua";
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				ketqua kq = new ketqua(rs.getString("MASV"),rs.getString("MAMH"),rs.getInt("DIEMTHI"));
				ketqualist.add(kq);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ketqualist;
	}
	public static void insert(ketqua kq) {
		String query = "insert into ketqua (MASV,MAMH,DIEMTHI) values(?,?,?)";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, kq.getMASV());
			pstmt.setString(2, kq.getMAMH());
			pstmt.setInt(3, kq.getDIEMTHI());
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void update(ketqua kq) {
		String query = "update ketqua set MASV = ?, MAMH = ?, DIEMTHI = ? where MASV ='"+kq.getMASV()+"'and MAMH ='"+kq.getMAMH()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, kq.getMASV());
			pstmt.setString(2, kq.getMAMH());
			pstmt.setInt(3, kq.getDIEMTHI());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void delete(ketqua kq) {
		String query = "delete from ketqua where MASV ='"+kq.getMASV()+"'and MAMH ='"+kq.getMAMH()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
