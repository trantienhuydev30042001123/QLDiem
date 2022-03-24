package model;

public class khoa {
	private String MAK;
	private String TENK;
	private String SDT;
	public khoa() {
	}
	public khoa(String mAK, String tENK, String sDT) {
		MAK = mAK;
		TENK = tENK;
		SDT = sDT;
	}
	public String getMAK() {
		return MAK;
	}
	public void setMAK(String mAK) {
		MAK = mAK;
	}
	public String getTENK() {
		return TENK;
	}
	public void setTENK(String tENK) {
		TENK = tENK;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}

}
