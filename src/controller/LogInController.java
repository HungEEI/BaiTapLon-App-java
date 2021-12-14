package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LogInView;
import view.PhanCapView;

public class LogInController implements ActionListener{
	
	private LogInView logInView;
	
	public LogInController(LogInView logInView) {

		this.logInView = logInView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		String st = e.getActionCommand();
		
		if(st.equals("Đăng nhập")) {
			this.logInView.giaoDien();
		}else if(st.equals("Hủy")) {
			this.logInView.dispose();
			new PhanCapView();
		}
	
	}

}
