package model;

import java.util.Objects;

public class KhoaHoc{
	
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
		return "maHocPhan: " + maHocPhan + ", monHoc: " + monHoc + ","
				+ " soTin: " + soTin + ", hocPhi: " + hocPhi;
		}

	@Override
	public int hashCode() {
		return Objects.hash(hocPhi, maHocPhan, monHoc, soTin);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhoaHoc other = (KhoaHoc) obj;
		return Float.floatToIntBits(hocPhi) == Float.floatToIntBits(other.hocPhi)
				&& Objects.equals(maHocPhan, other.maHocPhan) && Objects.equals(monHoc, other.monHoc)
				&& soTin == other.soTin;
	}
						
}