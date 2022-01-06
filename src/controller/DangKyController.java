package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DangKi;
import view.DangKyHocView;

public class DangKyController implements ActionListener {

	private DangKyHocView dk;
	
	public DangKyController(DangKyHocView dk) {
		this.dk = dk;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String t = e.getActionCommand();
		
		if(t.equals("Khóa Học")) {
			this.dk.xem();
			
		}else if(t.equals("Đóng")) {
			this.dk.thoatKhoiChuongTrinh();
			
		}else if(t.equals("Đăng ký")) {
			this.dk.hienThiThongTinKhoaHocDaChon();
			
		}else if(t.equals("Hủy môn học")) {
			this.dk.thucHienXoa();
			
		}else if(t.equals("Lưu đăng kí học")) {
			this.dk.luuDangKiHoc();
			
		}else if(t.equals("Xem đăng kí học")) {
			new DangKi();
		}		
	}

}
