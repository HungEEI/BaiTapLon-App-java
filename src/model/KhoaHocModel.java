package model;

import java.util.ArrayList;

public class KhoaHocModel {

	private ArrayList<KhoaHoc> dsKhoaHoc;
	private String luaChon;
	private String tenFile;

	public KhoaHocModel() {
		this.dsKhoaHoc = new ArrayList<KhoaHoc>();
		this.luaChon = "";
		this.tenFile = "";
	}

	public ArrayList<KhoaHoc> getDsKhoaHoc() {
		return dsKhoaHoc;
	}

	public void setDsKhoaHoc(ArrayList<KhoaHoc> dsKhoaHoc) {
		this.dsKhoaHoc = dsKhoaHoc;
	}
	
	public String getLuaChon() {
		return luaChon;
	}
	
	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public void insert(KhoaHoc khoaHoc) {
		this.dsKhoaHoc.add(khoaHoc);
	}
	
	public void delete(KhoaHoc khoaHoc) {
		this.dsKhoaHoc.remove(khoaHoc);
	}
	
	public void update(KhoaHoc khoaHoc) {
		this.dsKhoaHoc.remove(khoaHoc);
		this.dsKhoaHoc.add(khoaHoc);
	}
	
	public boolean kiemTraTonTai(KhoaHoc kh) {
		for(KhoaHoc khoaHoc: dsKhoaHoc) {
			if((khoaHoc.getMaHocPhan()).equals(kh.getMaHocPhan()))
				return true;
		}
		return false;
	}
}
