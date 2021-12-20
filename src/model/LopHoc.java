package model;

import java.io.Serializable;
import java.util.ArrayList;

public class LopHoc implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private LopHoc tenPhong;
	private int soLuong;
	private boolean trangThai;
	
	private String ten;
	
	public LopHoc() {
	}

	public LopHoc(int id, LopHoc tenPhong, int soLuong, boolean trangThai) {
		this.id = id;
		this.tenPhong = tenPhong;
		this.soLuong = soLuong;
		this.trangThai = trangThai;
	}

	public LopHoc(int i, String ten) {
		this.ten = ten;
	}

	public int getId() {
		return id;
	}

	public LopHoc getTenPhong() {
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

	public void setTenPhong(LopHoc tenPhong) {
		this.tenPhong = tenPhong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	
	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public static ArrayList<LopHoc> getDSLopHoc(){
		
		String[] arr_lopHoc = {"101 - T1", "102 - T1", "103 - T1", 
								"201 - T2", "202 - T2", "203 - T2", 
								"301 - T3", "302 - T3", "303 - T3", 
								"401 - T4", "402 - T4", "404 - T4",};
		
		ArrayList<LopHoc> listLopHoc = new ArrayList<LopHoc>();
		int i = 0;
		for (String tenlop : arr_lopHoc) {
			LopHoc l = new LopHoc(i, tenlop);
			listLopHoc.add(l);
		}
		return listLopHoc;
	}	
	
	public static LopHoc getLopById(int lopHoc) {
		return LopHoc.getDSLopHoc().get(lopHoc);
	}

	public static LopHoc getLopByTen(String tenLop) {
		ArrayList<LopHoc> listLop = LopHoc.getDSLopHoc();
		for (LopHoc lop : listLop) {
			if(lop.ten.equals(tenLop))
				return lop;
		}
		return null;
	}
}