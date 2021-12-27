package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GiangVien {

	private String hoVaTen;
	private Date ngaySinh;
	private String email;
	private boolean hocVi;
	private float luong;
	
	public GiangVien() {
	}	

	public GiangVien(String hoVaTen, Date ngaySinh, String email, boolean hocVi, float luong) {
		this.hoVaTen = hoVaTen;
		this.ngaySinh = ngaySinh;
		this.email = email;
		this.hocVi = hocVi;
		this.luong = luong;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public String getEmail() {
		return email;
	}

	public boolean isHocVi() {
		return hocVi;
	}

	public float getLuong() {
		return luong;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setHocVi(boolean hocVi) {
		this.hocVi = hocVi;
	}

	public void setLuong(float luong) {
		this.luong = luong;
	}
	
	SimpleDateFormat spt = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public String toString() {
		return  hoVaTen + ", " + spt.format(ngaySinh) + ", " + email + ", " + (hocVi ? "PGS.TS" : "TS") + ", " + luong;
	}	
		
}