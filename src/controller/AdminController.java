package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AdminView;
import view.ChangePassView;
import view.GiaoVienView;
import view.KhoaHocView;
import view.SinhVienView;

public class AdminController implements ActionListener{
	
	private AdminView appView;

	public AdminController(AdminView appView) {
		this.appView = appView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String st = e.getActionCommand();
		
		if(st.equals("Thoát")) {
			this.appView.thoatKhoiChuongTrinh();
			
		}else if(st.equals("Khóa học")) {
			new KhoaHocView();
			
		}else if(st.equals("Người học")) {
			new SinhVienView();	
			
		}else if(st.equals("Đăng xuất")) {
			this.appView.dangXuat();
			
		}else if(st.equals("Đổi mật khẩu")) {
			new ChangePassView();
			
		}else if(st.equals("Quản lý giảng viên")) {
			new GiaoVienView();
			
		}		
		
	}

}
