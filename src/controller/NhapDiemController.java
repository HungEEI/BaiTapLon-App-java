package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DangKyKhocHoc;
import view.NhapDiemView;

public class NhapDiemController implements ActionListener{

	private NhapDiemView nhapDiemView;

	public NhapDiemController(NhapDiemView nhapDiemView) {
		this.nhapDiemView = nhapDiemView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cm = e.getActionCommand();
		
		if(cm.equals("Hủy bỏ")) {
			this.nhapDiemView.xoaForm();
			this.nhapDiemView.model.setLuaChon("Hủy bỏ");
			
		}else if(cm.equals("Thêm")) {
			try {
				this.nhapDiemView.thucHienThemDiem();
			} catch (Exception e2) {
				e2.printStackTrace();
		}
			
		}else if(cm.equals("Cập nhật")) {
			this.nhapDiemView.hienThiDiemDaChon();
			
		}else if(cm.equals("Xóa")) {
			this.nhapDiemView.thucHienXoa();
			
		}else if(cm.equals("Đóng")) {
			this.nhapDiemView.thoatKhoiChuongTrinh();
			
		}else if(cm.equals("Save")) {
			this.nhapDiemView.thucHienSaveFile();
			
		}else if(cm.equals("Open")) {
			this.nhapDiemView.thucHienOpenFile();
			
		}	
		
	}

	
	
}
