package model;

public class monhoc {
	private String MAMH;
	private String TENMH;
	private int SOTINCHI;
	public monhoc() {
	}
	public monhoc(String mAMH, String tENMH, int sOTINCHI) {
		MAMH = mAMH;
		TENMH = tENMH;
		SOTINCHI = sOTINCHI;
	}
	public String getMAMH() {
		return MAMH;
	}
	public void setMAMH(String mAMH) {
		MAMH = mAMH;
	}
	public String getTENMH() {
		return TENMH;
	}
	public void setTENMH(String tENMH) {
		TENMH = tENMH;
	}
	public int getSOTINCHI() {
		return SOTINCHI;
	}
	public void setSOTINCHI(int sOTINCHI) {
		SOTINCHI = sOTINCHI;
	}
	

}
