package model;

import java.io.Serializable;

public class KhoaHoc implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String maHocPhan;
	private String monHoc;
	private int soTin;
	private float hocPhi;
	
	public KhoaHoc() {
	}

	public KhoaHoc(String maHocPhan, String monHoc, int soTin, float hocPhi) {
		this.maHocPhan = maHocPhan;
		this.monHoc = monHoc;
		this.soTin = soTin;
		this.hocPhi = hocPhi;
	}

	public String getMonHoc() {
		return monHoc;
	}

	public int getSoTin() {
		return soTin;
	}

	public float getHocPhi() {
		return hocPhi;
	}

	public String getMaHocPhan() {
		return maHocPhan;
	}
	
	public void setMahocPhan(String maHocPhan) {
		this.maHocPhan = maHocPhan;
	}

	public void setMonHoc(String monHoc) {
		this.monHoc = monHoc;
	}

	public void setSoTin(int soTin) {
		this.soTin = soTin;
	}

	public void setHocPhi(float hocPhi) {
		this.hocPhi = hocPhi;
	}

	@Override
	public String toString() {
		return  maHocPhan + ", " + monHoc + ", " + soTin + ", " + hocPhi;
	}
	
	
}