package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import view.KhoaHocView;

public class KhoaHocController implements ActionListener{

	private KhoaHocView khoaHocView;

	public KhoaHocController(KhoaHocView khoaHocView) {
		this.khoaHocView = khoaHocView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String s = e.getActionCommand();
		
		if(s.equals("Mới")) {
			this.khoaHocView.clear();
			
		}else if(s.equals("Thêm")) {
			try {
				this.khoaHocView.thucHienThemKhoaHoc();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
		}else if(s.equals("Sửa")) {
			this.khoaHocView.hienThiThongTinKhoaHocDaChon();
			
		}else if(s.equals("Đóng")) {
			this.khoaHocView.dispose();
			
		}else if(s.equals("Xóa")) {
			this.khoaHocView.thucHienXoa();
			
		}else if(s.equals("Lưu")) {
			this.khoaHocView.luuKhoaHoc();
		
		}else if(s.equals("File")) {
			this.khoaHocView.xem();
							
		}else if(s.equals("l<")) {
			this.khoaHocView.first();
		
		}else if(s.equals(">>")) {
			this.khoaHocView.next();;
			
		}else if(s.equals("<<")) {
			this.khoaHocView.prev();
						
		}else if(s.equals(">l")) {
			this.khoaHocView.last();
		}		
	}
}