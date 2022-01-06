package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SinhVien implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int maSinhVien;
	private String hoVaTen;
	private QueQuan queQuan;
	private Date ngaySinh;
	private boolean gioiTinh;
	private float chuyenCan, giuaKy, cuoiKy, he4;
	private double he10;
	private String hang;
	private String monHoc;
	
	public SinhVien() {
	}

	public SinhVien(int maSinhVien, String hoVaTen, QueQuan queQuan, Date ngaySinh, String monHoc, 
					boolean gioiTinh, float chuyenCan, float giuaKy, float cuoiKy, float he4, String hang, Double he10) {
		this.maSinhVien = maSinhVien;
		this.hoVaTen = hoVaTen;
		this.queQuan = queQuan;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.chuyenCan = chuyenCan;
		this.giuaKy = giuaKy;
		this.cuoiKy = cuoiKy;
		this.he4 = he4;
		this.hang = hang;	
		this.he10 = he10;
		this.monHoc = monHoc;
	}
	
	
	public SinhVien(int maSinhVien, String hoVaTen, float chuyenCan, float giuaKy, float cuoiKy, float he4, String hang,
			String monHoc) {
		this.maSinhVien = maSinhVien;
		this.hoVaTen = hoVaTen;
		this.chuyenCan = chuyenCan;
		this.giuaKy = giuaKy;
		this.cuoiKy = cuoiKy;
		this.he4 = he4;
		this.hang = hang;
		this.monHoc = monHoc;
	}

	public int getMaSinhVien() {
		return maSinhVien;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public QueQuan getQueQuan() {
		return queQuan;
	}

	public Date getNgaySinh(Date date) {
		return ngaySinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public float getChuyenCan() {
		return chuyenCan;
	}

	public float getGiuaKy() {
		return giuaKy;
	}

	public float getCuoiKy() {
		return cuoiKy;
	}

	public String getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(String monHoc) {
		this.monHoc = monHoc;
	}

	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public void setQueQuan(QueQuan queQuan) {
		this.queQuan = queQuan;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public void setChuyenCan(float chuyenCan) {
		this.chuyenCan = chuyenCan;
	}

	public void setGiuaKy(float giuaKy) {
		this.giuaKy = giuaKy;
	}

	public void setCuoiKy(float cuoiKy) {
		this.cuoiKy = cuoiKy;
	}

	public float getHe4() {
		return he4;
	}

	public String getHang() {
		return hang;
	}

	public void setHe4(float he4) {
		this.he4 = he4;
	}

	public void setHang(String hang) {
		this.hang = hang;
	}
	
	public double getHe10() {
		return he10;
	}

	public void setHe10(double he10) {
		this.he10 = he10;
	}

	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public String toString() {
		return maSinhVien + ", " + hoVaTen + ", " + queQuan +
				", "+ format.format(ngaySinh) + (", " + gioiTinh != null ? ", Giới tính: nam" : ", Giới tính: nữ")
				+ ", " + monHoc + ", " + + chuyenCan + ", " + giuaKy + ", "
				+ cuoiKy + ", " + he4 + ", " + hang + ", " + he10;
	}	
}