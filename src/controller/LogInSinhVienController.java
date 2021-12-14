package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LogInSinhVien;
import view.PhanCapView;

public class LogInSinhVienController implements ActionListener{

	private LogInSinhVien logInSinhVien;

	public LogInSinhVienController(LogInSinhVien logInSinhVien) {
		this.logInSinhVien = logInSinhVien;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cm = e.getActionCommand();
		
		if(cm.equals("Đăng nhập")) {
			this.logInSinhVien.giaoDien();
			
		}else if(cm.equals("Hủy")){
			new PhanCapView();
			this.logInSinhVien.dispose();
		}
		
	}	
	
}
