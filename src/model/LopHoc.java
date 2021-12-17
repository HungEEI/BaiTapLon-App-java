package model;

public class LopHoc {

	private int id;
	private String tenPhong;
	private int soLuong;
	private boolean trangThai;
	
	public LopHoc() {
	}

	public LopHoc(int id, String tenPhong, int soLuong, boolean trangThai) {
		this.id = id;
		this.tenPhong = tenPhong;
		this.soLuong = soLuong;
		this.trangThai = trangThai;
	}

	public int getId() {
		return id;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
		
}
