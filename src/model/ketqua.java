package model;

public class ketqua {
	private String MASV;
	private String MAMH;
	private int DIEMTHI;
	
	public ketqua() {
	}

	public ketqua(String mASV, String mAMH, int dIEMTHI) {
		MASV = mASV;
		MAMH = mAMH;
		DIEMTHI = dIEMTHI;
	}

	public String getMASV() {
		return MASV;
	}

	public void setMASV(String mASV) {
		MASV = mASV;
	}

	public String getMAMH() {
		return MAMH;
	}

	public void setMAMH(String mAMH) {
		MAMH = mAMH;
	}

	public int getDIEMTHI() {
		return DIEMTHI;
	}

	public void setDIEMTHI(int dIEMTHI) {
		DIEMTHI = dIEMTHI;
	}

}
