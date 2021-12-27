package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.GiaoVienView;

public class GiangVienController implements ActionListener {

	private GiaoVienView giaoVienView;

	public GiangVienController(GiaoVienView giaoVienView) {
		this.giaoVienView = giaoVienView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String st = e.getActionCommand();
		
		if(st.equals("Hủy bỏ")) {
			this.giaoVienView.xoaForm();
			this.giaoVienView.model.setLuaChon("Hủy bỏ");
			
		}else if(st.equals("Thêm")) {
			try {
				this.giaoVienView.thucHienThemGiangVien();
			} catch (Exception e2) {
				e2.printStackTrace();
		}
			
		}else if(st.equals("Cập nhật")) {
			this.giaoVienView.hienThiThongTinGiangVienDaChon();
			
		}else if(st.equals("Xóa")) {
			this.giaoVienView.thucHienXoa();
			
		}else if(st.equals("Hủy tìm")) {
			this.giaoVienView.thucHienTaiLaiDuLieu();
			
		}else if(st.equals("Đóng")) {
			this.giaoVienView.dispose();
			
		}else if(st.equals("Save")) {
			this.giaoVienView.thucHienSaveFile();
			this.giaoVienView.FileCSV();
			
		}else if(st.equals("Open")) {
			this.giaoVienView.thucHienOpenFile();
			
		}		
	}	
}
