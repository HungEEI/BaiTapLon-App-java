package model;

import java.util.ArrayList;

public class LopHocModel {

	private ArrayList<LopHoc> dsLopHoc;
	private String luaChon;
	private String tenFile;
	
	public LopHocModel() {
		this.dsLopHoc = new ArrayList<LopHoc>();
		this.luaChon = "";
		this.tenFile = "";
	}
	
	public ArrayList<LopHoc> getDsLopHoc() {
		return dsLopHoc;
	}

	public String getLuaChon() {
		return luaChon;
	}
	
	public String getTenFile() {
		return tenFile;
	}

	public void setDsLopHoc(ArrayList<LopHoc> dsLopHoc) {
		this.dsLopHoc = dsLopHoc;
	}
	
	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public void insert(LopHoc lopHoc) {
		this.dsLopHoc.add(lopHoc);
	}
	
	public void delete(LopHoc lopHoc) {
		this.dsLopHoc.remove(lopHoc);
	}
	
	public void update(LopHoc lopHoc) {
		this.dsLopHoc.remove(lopHoc);
		this.dsLopHoc.add(lopHoc);
	}
	
	public boolean kiemTraTonTai(LopHoc lh) {
		for(LopHoc lopHoc: dsLopHoc) {
			if(lopHoc.getId() == lh.getId())
				return true;
		}
		return false;
	}
}
