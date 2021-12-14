package model;

import java.util.ArrayList;

public class NhapDiemModel {

	private ArrayList<SinhVien> dsDiem;
	private String luaChon;
	private String tenFile;
	
	public NhapDiemModel() {
		this.dsDiem = new ArrayList<SinhVien>();
		this.luaChon = "";
		this.tenFile= "";
	}

	public ArrayList<SinhVien> getDsDiem() {
		return dsDiem;
	}

	public String getLuaChon() {
		return luaChon;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setDsDiem(ArrayList<SinhVien> dsDiem) {
		this.dsDiem = dsDiem;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	
	public void insert(SinhVien sinhVien) {
		this.dsDiem.add(sinhVien);
	}
	
	public void delete(SinhVien sinhVien) {
		this.dsDiem.remove(sinhVien);
	}
	
	public void update(SinhVien sinhVien) {
		this.dsDiem.remove(sinhVien);
		this.dsDiem.add(sinhVien);
	}

	public boolean kiemTraTonTai(SinhVien sv) {
		for(SinhVien sinhVien: dsDiem) {
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
}
