package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LogInGiaoVienView;
import view.PhanCapView;

public class LogInGiaoVIenController implements ActionListener{

	private LogInGiaoVienView logIn;
		
	public LogInGiaoVIenController(LogInGiaoVienView logIn) {
		this.logIn = logIn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String cm = e.getActionCommand();
		
		if(cm.equals("Đăng nhập")) {
			this.logIn.giaoDien();
			
		}else if(cm.equals("Hủy")){
			new PhanCapView();
			this.logIn.dispose();
			new PhanCapView();
		}
	}

}
