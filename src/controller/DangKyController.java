package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DangKyHocView;

public class DangKyController implements ActionListener {

	private DangKyHocView dk;
	
	public DangKyController(DangKyHocView dk) {
		this.dk = dk;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String t = e.getActionCommand();
		
		if(t.equals("Mở File Khóa Học")) {
			this.dk.thucHienOpenFile();
			
		}else if(t.equals("Đóng")) {
			this.dk.dispose();
			
		}else if(t.equals("Đăng ký")) {
			this.dk.hienThiThongTinKhoaHocDaChon();
		}else if(t.equals("Hủy môn học")) {
			this.dk.thucHienXoa();
		}
		
	}

}
