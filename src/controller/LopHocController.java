package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import view.LopHocView;

public class LopHocController implements ActionListener {

	private LopHocView lopHocView;
	
	public LopHocController(LopHocView lopHocView) {
		this.lopHocView = lopHocView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String s = e.getActionCommand();
		
		if(s.equals("Mới")) {
			this.lopHocView.clear();
			
		}else if(s.equals("Thêm")) {
			try {
				this.lopHocView.thucHienThemKhoaHoc();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
		}else if(s.equals("Sửa")) {
			this.lopHocView.hienThiThongTinKhoaHocDaChon();
			
		}else if(s.equals("Đóng")) {
			this.lopHocView.dispose();
			
		}else if(s.equals("Xóa")) {
			this.lopHocView.thucHienXoa();
			
		}else if(s.equals("Lưu")) {
			this.lopHocView.thucHienSaveFile();
			
		}else if(s.equals("Cập nhật")) {
			this.lopHocView.hienThiThongTinKhoaHocDaChon();
		}
	}
}