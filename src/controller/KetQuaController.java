package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DangKyKhocHoc;

public class KetQuaController implements ActionListener{

	private DangKyKhocHoc dangKyKhocHoc;
	
	public KetQuaController(DangKyKhocHoc dangKyKhocHoc) {
		this.dangKyKhocHoc = dangKyKhocHoc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				
		String s = e.getActionCommand();
		
		if(s.equals("Đóng")) {
			this.dangKyKhocHoc.thoatKhoiChuongTrinh();
			
		}else if(s.equals("Điểm")) {
			this.dangKyKhocHoc.xem();
		}		
	}
}