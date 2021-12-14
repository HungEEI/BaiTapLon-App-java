package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AdminView;
import view.ChangePassView;
import view.KhoaHocView;
import view.LogInView;
import view.SinhVienView;

public class SinhVienController implements ActionListener {
	
	private SinhVienView sinhVienView;

	public SinhVienController(SinhVienView sinhVienView) {
		this.sinhVienView = sinhVienView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cm = e.getActionCommand();
		
		if(cm.equals("Hủy bỏ")) {
			this.sinhVienView.xoaForm();
			this.sinhVienView.model.setLuaChon("Hủy bỏ");
			
		}else if(cm.equals("Thêm")) {
			try {
				this.sinhVienView.thucHienThemSinhVien();
			} catch (Exception e2) {
				e2.printStackTrace();
		}
			
		}else if(cm.equals("Cập nhật")) {
			this.sinhVienView.hienThiThongTinSinhVienDaChon();
			
		}else if(cm.equals("Xóa")) {
			this.sinhVienView.thucHienXoa();
		
		}else if(cm.equals("Tìm kiếm")) {
			this.sinhVienView.thucHienTim();
			
		}else if(cm.equals("Hủy tìm")) {
			this.sinhVienView.thucHienTaiLaiDuLieu();
			
		}else if(cm.equals("Đóng")) {
			this.sinhVienView.dispose();
			
		}else if(cm.equals("Save")) {
			this.sinhVienView.thucHienSaveFile();
			this.sinhVienView.fileCSV();
			
		}else if(cm.equals("Open")) {
			this.sinhVienView.thucHienOpenFile();
			
		}	
	}
}
