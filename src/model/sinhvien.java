package model;

public class sinhvien {
	private String MASV;
	private String TENSV;
	private int GIOITINH;
	private String NGAYSINH;
	private String QUEQUAN;
	private String SDT;
	private String MALOP;
	public sinhvien() {
	}
	public sinhvien(String mASV, String tENSV, int gIOITINH, String nGAYSINH, String qUEQUAN, String sDT,
			String mALOP) {
		MASV = mASV;
		TENSV = tENSV;
		GIOITINH = gIOITINH;
		NGAYSINH = nGAYSINH;
		QUEQUAN = qUEQUAN;
		SDT = sDT;
		MALOP = mALOP;
	}
	public String getMASV() {
		return MASV;
	}
	public void setMASV(String mASV) {
		MASV = mASV;
	}
	public String getTENSV() {
		return TENSV;
	}
	public void setTENSV(String tENSV) {
		TENSV = tENSV;
	}
	public int getGIOITINH() {
		return GIOITINH;
	}
	public void setGIOITINH(int gIOITINH) {
		GIOITINH = gIOITINH;
	}
	public String getNGAYSINH() {
		return NGAYSINH;
	}
	public void setNGAYSINH(String nGAYSINH) {
		NGAYSINH = nGAYSINH;
	}
	public String getQUEQUAN() {
		return QUEQUAN;
	}
	public void setQUEQUAN(String qUEQUAN) {
		QUEQUAN = qUEQUAN;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getMALOP() {
		return MALOP;
	}
	public void setMALOP(String mALOP) {
		MALOP = mALOP;
	}
	

}
