package model;

import java.util.ArrayList;

public class GiangVienModel {

	private ArrayList<GiangVien> dsGiangVien;
	private String luaChon;
	private String tenFile;
	
	public GiangVienModel() {
		this.dsGiangVien = new ArrayList<GiangVien>();
		this.luaChon = "";
		this.tenFile = "";
	}

	public ArrayList<GiangVien> getDsGiangVien() {
		return dsGiangVien;
	}

	public String getLuaChon() {
		return luaChon;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setDsGiangVien(ArrayList<GiangVien> dsGiangVien) {
		this.dsGiangVien = dsGiangVien;
	}
	
	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	
	public void insert(GiangVien giangVien) {
		this.dsGiangVien.add(giangVien);
	}
	
	public void delete(GiangVien giangVien) {
		this.dsGiangVien.remove(giangVien);
	}
	
	public void update(GiangVien giangVien) {
		this.dsGiangVien.remove(giangVien);
		this.dsGiangVien.add(giangVien);
	}
	
	public boolean kiemTraTonTai(GiangVien gv) {
		for(GiangVien giangVien: dsGiangVien) {
			if(giangVien.getHoVaTen().equals(gv.getHoVaTen()))
				return true;
		}
		return false;
	}
}
