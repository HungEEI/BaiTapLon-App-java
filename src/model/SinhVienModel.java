package model;

import java.util.ArrayList;

public class SinhVienModel {

	private ArrayList<SinhVien> dsSinhVien;
	private String luaChon;
	private String tenFile;
	
	public SinhVienModel() {
		this.dsSinhVien = new ArrayList<SinhVien>();
		this.luaChon = "";
		this.tenFile= "";
	}

	public ArrayList<SinhVien> getDsSinhVien() {
		return dsSinhVien;
	}

	public String getLuaChon() {
		return luaChon;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setDsSinhVien(ArrayList<SinhVien> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}
	
	public void insert(SinhVien sinhVien) {
		this.dsSinhVien.add(sinhVien);
	}
	
	public void delete(SinhVien sinhVien) {
		this.dsSinhVien.remove(sinhVien);
	}
	
	public void update(SinhVien sinhVien) {
		this.dsSinhVien.remove(sinhVien);
		this.dsSinhVien.add(sinhVien);
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public boolean kiemTraTonTai(SinhVien sv) {
		for(SinhVien sinhVien: dsSinhVien) {
			if(sinhVien.getMaSinhVien() == sv.getMaSinhVien())
				return true;
		}
		return false;
	}
	
	public float he4(float chuyenCan, float giuaKy, float cuoiKy) {
		 float diem = 0;
		 return diem = (float)(chuyenCan*0.2+giuaKy*0.2+cuoiKy*0.6);
		 
	}

	public String hang(float he4) {
		String hang = "";
		if(0 < he4 && he4 < 4) hang = "F";
		if(4 <= he4 && he4 < 5) hang = "D";
		if(5 <= he4 && he4 < 5.5) hang = "D+";
		if(5.5 <= he4 && he4 < 6.5) hang = "C";
		if(6.5 <= he4 && he4 < 7) hang = "C+";
		if(7 <= he4 && he4 < 8) hang = "B";
		if(8 <= he4 && he4 < 8.5) hang = "B+";
		if(8.5 <= he4 && he4 < 9) hang = "A";
		if(9 <= he4 && he4 <= 10) hang = "A+";
		return hang;
	}	
	
	public double he10(String hang) {
		double gpa = 0;
		if(hang.equals("F")) gpa = 0;
		if(hang.equals("D")) gpa = 1.0;
		if(hang.equals("D+")) gpa = 1.5;
		if(hang.equals("C")) gpa = 2;
		if(hang.equals("C+")) gpa = 2.5;
		if(hang.equals("B")) gpa = 3;
		if(hang.equals("B+")) gpa = 3.5;
		if(hang.equals("A")) gpa = 3.7;
		if(hang.equals("A+")) gpa = 4.0;
		
		return gpa;
	}
}