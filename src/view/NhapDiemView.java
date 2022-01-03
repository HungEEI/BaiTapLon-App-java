package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.NhapDiemController;
import model.NhapDiemModel;
import model.SinhVien;
import model.SinhVienModel;

public class NhapDiemView extends JFrame {
	
	public NhapDiemView() {
		init();
	}

//////---Form
	public void init() {
		this.model = new SinhVienModel();
		this.model_nd = new NhapDiemModel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(880, 617);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener actionListener = new NhapDiemController(this);
		
		panel_nhapDiem = new JPanel();
		panel_nhapDiem.setBounds(10, 65, 846, 505);
		panel_nhapDiem.setBackground(new Color(255, 228, 181));
		contentPane.add(panel_nhapDiem);
		panel_nhapDiem.setLayout(null);
		
		lblNewLabel = new JLabel("Nhập Điểm");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(281, 11, 308, 38);
		contentPane.add(lblNewLabel);
		
		jButton_thoat = new JButton("Đóng");
		jButton_thoat.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\Logout.png"));
		jButton_thoat.addActionListener(actionListener);
		jButton_thoat.setForeground(Color.RED);
		jButton_thoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		jButton_thoat.setBounds(10, 10, 103, 44);
		contentPane.add(jButton_thoat);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				" MÃ SINH VIÊN", "   HỌ VÀ TÊN", "   MÔN HỌC",
				"  CHUYÊN CẦN", "     GIỮA KỲ", "     CUỐI KỲ", "        HỆ 10", "       HẠNG"
			}
		));
		table.setRowHeight(25);
	
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 821, 243);
		panel_nhapDiem.add(scrollPane);
		
		jLabel_maSinhVien = new JLabel("Mã sinh viên");
		jLabel_maSinhVien.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel_maSinhVien.setBounds(32, 275, 92, 18);
		panel_nhapDiem.add(jLabel_maSinhVien);
		
		jLabel_hoVaTen = new JLabel("Họ và tên");
		jLabel_hoVaTen.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel_hoVaTen.setBounds(32, 316, 73, 18);
		panel_nhapDiem.add(jLabel_hoVaTen);
		
		jlabel_chuyenCan = new JLabel("Chuyên Cần");
		jlabel_chuyenCan.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabel_chuyenCan.setBounds(369, 276, 73, 17);
		panel_nhapDiem.add(jlabel_chuyenCan);
		
		jLabel_giuaKy = new JLabel("Giữa kỳ");
		jLabel_giuaKy.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel_giuaKy.setBounds(369, 316, 66, 18);
		panel_nhapDiem.add(jLabel_giuaKy);
		
		jLabel_CuoiKy = new JLabel("Cuối kỳ");
		jLabel_CuoiKy.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel_CuoiKy.setBounds(369, 348, 66, 18);
		panel_nhapDiem.add(jLabel_CuoiKy);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 263, 841, 2);
		panel_nhapDiem.add(separator_1_1);
		
		textField_maSinhVien = new JTextField();
		textField_maSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_maSinhVien.setBounds(134, 274, 176, 22);
		panel_nhapDiem.add(textField_maSinhVien);
		textField_maSinhVien.setColumns(10);
		
		textField_hoVaTen = new JTextField();
		textField_hoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_hoVaTen.setBounds(134, 315, 176, 22);
		panel_nhapDiem.add(textField_hoVaTen);
		textField_hoVaTen.setColumns(10);
		
		textField_chuyenCan = new JTextField();
		textField_chuyenCan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_chuyenCan.setBounds(463, 274, 142, 22);
		panel_nhapDiem.add(textField_chuyenCan);
		textField_chuyenCan.setColumns(10);
		
		textField_giuaKy = new JTextField();
		textField_giuaKy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_giuaKy.setBounds(463, 315, 142, 22);
		panel_nhapDiem.add(textField_giuaKy);
		textField_giuaKy.setColumns(10);
		
		textField_cuoiKy = new JTextField();
		textField_cuoiKy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_cuoiKy.setBounds(463, 347, 142, 22);
		panel_nhapDiem.add(textField_cuoiKy);
		textField_cuoiKy.setColumns(10);
		
		jLabel_maSinhVien_1 = new JLabel("Môn học");
		jLabel_maSinhVien_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel_maSinhVien_1.setBounds(32, 348, 92, 18);
		panel_nhapDiem.add(jLabel_maSinhVien_1);
		
		textField_monHoc = new JTextField();
		textField_monHoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_monHoc.setColumns(10);
		textField_monHoc.setBounds(134, 347, 176, 22);
		panel_nhapDiem.add(textField_monHoc);
		
		lblNewLabel_5 = new JLabel("Hệ 10");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(653, 287, 45, 27);
		panel_nhapDiem.add(lblNewLabel_5);
		
		textField_he4 = new JTextField();
		textField_he4.setEditable(false);
		textField_he4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_he4.setBounds(708, 290, 85, 22);
		panel_nhapDiem.add(textField_he4);
		textField_he4.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Hạng");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(653, 327, 45, 27);
		panel_nhapDiem.add(lblNewLabel_6);
		
		textField_hang = new JTextField();
		textField_hang.setEditable(false);
		textField_hang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_hang.setBounds(708, 330, 85, 22);
		panel_nhapDiem.add(textField_hang);
		textField_hang.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(10, 440, 831, 55);
		panel_nhapDiem.add(panel_1);
		panel_1.setLayout(null);
		
		jButton_xoa = new JButton("Xóa");
		jButton_xoa.setBounds(34, 10, 105, 35);
		panel_1.add(jButton_xoa);
		jButton_xoa.setBackground(Color.RED);
		jButton_xoa.setOpaque(true);
		jButton_xoa.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\exit.png"));
		jButton_xoa.addActionListener(actionListener);
		jButton_xoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jButton_capNhat = new JButton("Cập nhật");
		jButton_capNhat.setBounds(194, 10, 105, 35);
		panel_1.add(jButton_capNhat);
		jButton_capNhat.setBackground(Color.GREEN);
		jButton_capNhat.setOpaque(true);
		jButton_capNhat.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\update.png"));
		jButton_capNhat.addActionListener(actionListener);
		jButton_capNhat.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jButton_them = new JButton("Thêm");
		jButton_them.setBounds(363, 10, 105, 35);
		panel_1.add(jButton_them);
		jButton_them.setBackground(Color.GREEN);
		jButton_them.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\add.png"));
		jButton_them.addActionListener(actionListener);
		jButton_them.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jButton_huyBo = new JButton("Hủy bỏ");
		jButton_huyBo.setBounds(541, 10, 101, 35);
		panel_1.add(jButton_huyBo);
		jButton_huyBo.setBackground(Color.RED);
		jButton_huyBo.setOpaque(true);
		jButton_huyBo.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\broom.png"));
		jButton_huyBo.addActionListener(actionListener);
		jButton_huyBo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jButton_save = new JButton("Save");
		jButton_save.setBounds(711, 10, 85, 35);
		panel_1.add(jButton_save);
		jButton_save.setBackground(Color.CYAN);
		jButton_save.setOpaque(true);
		jButton_save.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\Save.png"));
		jButton_save.addActionListener(actionListener);
		jButton_save.setFont(new Font("Tahoma", Font.BOLD, 12));;;;
		
		jButton_frist = new JButton("l<");
		jButton_frist.setBounds(262, 409, 47, 21);
		panel_nhapDiem.add(jButton_frist);
		jButton_frist.setBackground(new Color(0, 0, 204));
		jButton_frist.addActionListener(actionListener);
		jButton_frist.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		jButton_prev = new JButton("<<");
		jButton_prev.setBounds(333, 410, 47, 21);
		panel_nhapDiem.add(jButton_prev);
		jButton_prev.setBackground(new Color(51, 102, 255));
		jButton_prev.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		jButton_next = new JButton(">>");
		jButton_next.setBounds(399, 409, 47, 21);
		panel_nhapDiem.add(jButton_next);
		jButton_next.setBackground(new Color(51, 102, 255));
		
		jButton_last = new JButton(">l");
		jButton_last.setBounds(464, 409, 47, 21);
		panel_nhapDiem.add(jButton_last);
		jButton_last.setBackground(new Color(0, 0, 204));
		jButton_last.addActionListener(actionListener);
		jButton_last.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(0, 397, 841, 2);
		panel_nhapDiem.add(separator_1_1_1);
		jButton_next.addActionListener(actionListener);
		jButton_prev.addActionListener(actionListener);
		
		this.setVisible(true);
	}
	
	public void xoaForm() {
		textField_maSinhVien.setText("");
		textField_monHoc.setText("");
		textField_hoVaTen.setText("");
		textField_chuyenCan.setText("");
		textField_giuaKy.setText("");
		textField_cuoiKy.setText("");
		textField_he4.setText("");
		textField_hang.setText("");
	}
	
	public void themDiemVaoTable(SinhVien sv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] {sv.getMaSinhVien() + "", sv.getHoVaTen(), 
										 sv.getMonHoc(), sv.getChuyenCan() + "", 
										 sv.getGiuaKy() + "", sv.getCuoiKy() + "",
										 sv.getHe4(), sv.getHang()});
	}
	
	public void themHoacCapNhatDiem(SinhVien sv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(sv)) {
			this.model.insert(sv);
			this.themDiemVaoTable(sv);
		} else {
			this.model.update(sv);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(sv.getMaSinhVien() + "")) {
					model_table.setValueAt(sv.getMaSinhVien() + "", i, 0);
					model_table.setValueAt(sv.getHoVaTen() + "", i, 1);
					model_table.setValueAt(sv.getMonHoc() + "", i, 2);
					model_table.setValueAt(sv.getChuyenCan() + "", i, 3);
					model_table.setValueAt(sv.getGiuaKy() + "", i, 4);
					model_table.setValueAt(sv.getCuoiKy() + "", i, 5); 
					model_table.setValueAt(sv.getHe4() + "", i, 6);
					model_table.setValueAt(sv.getHang() + "", i, 7);					
				}
			}
		}
	}
	
	public SinhVien getDiemDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
	
		int maSinhVien = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String hoVaTen = model_table.getValueAt(i_row, 1) + "";
		String monHoc = model_table.getValueAt(i_row, 2) + "";
		float chuyenCan = Float.valueOf(model_table.getValueAt(i_row, 3) + "");
		float giuaKy = Float.valueOf(model_table.getValueAt(i_row, 4) + "");
		float cuoiKy = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		float he4 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		String hang = model_table.getValueAt(i_row, 7) + "";
	
		SinhVien sv = new SinhVien(maSinhVien, hoVaTen, chuyenCan, giuaKy, cuoiKy, he4, hang, monHoc);
		return sv;
	}
	
	public void hienThiDiemDaChon() {
		SinhVien sv = getDiemDangChon();
		this.textField_maSinhVien.setText(sv.getMaSinhVien() + "");
		this.textField_hoVaTen.setText(sv.getHoVaTen() + "");
		this.textField_monHoc.setToolTipText(sv.getMonHoc() + "");
		this.textField_chuyenCan.setText(sv.getChuyenCan() + "");
		this.textField_giuaKy.setText(sv.getGiuaKy() + "");
		this.textField_cuoiKy.setText(sv.getCuoiKy() + "");
		this.textField_he4.setText(sv.getHe4() + "");
		this.textField_hang.setText(sv.getHang() + "");
	}
	
	public void thucHienThemDiem() throws ParseException {
////////----Lấy dữ liệu
		int maSinhVien = Integer.valueOf(this.textField_maSinhVien.getText());
		String hoVaTen = this.textField_hoVaTen.getText();
		String monHoc = this.textField_monHoc.getText();
		float chuyenCan = Float.valueOf(this.textField_chuyenCan.getText());
		float giuaKy = Float.valueOf(this.textField_giuaKy.getText());
		float cuoiKy = Float.valueOf(this.textField_cuoiKy.getText());		
		float he4 = model.he4(chuyenCan, giuaKy, cuoiKy);
		textField_he4.setText(he4+"");					
		String hang = model.hang(he4);
		textField_hang.setText(hang);
		
		SinhVien sv = new SinhVien(maSinhVien, hoVaTen, chuyenCan, giuaKy, cuoiKy, he4, hang, monHoc);
		this.themHoacCapNhatDiem(sv);
	}
	
	public void thucHienTaiLaiDuLieu() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0)
				break;
			else
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (SinhVien sv : this.model.getDsSinhVien()) {
			this.themDiemVaoTable(sv);
		}
	}	

////////////////----- File
	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (SinhVien sv : this.model.getDsSinhVien()) {
				oos.writeObject(sv);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void thucHienSaveFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			} 
		}
		hienThiSave();
	}
	
	public void openFile(File file) {
		ArrayList<SinhVien> ds = new ArrayList<SinhVien>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			SinhVien sv = null;
			while((sv = (SinhVien) ois.readObject())!=null) {
				ds.add(sv);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsSinhVien(ds);
	}
	
	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		} 
	}
	
////////////////-----Cảnh báo	
	public void hienThiSave() {
		JOptionPane.showMessageDialog(this, "Lưu thành công!");
	}
	
	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn thoát?",
			    "Thoát",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			this.dispose();
			new PhanCapView();
		}
	}
	
	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không ?",
													"Xóa", JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			SinhVien sv = getDiemDangChon();
			this.model.delete(sv);
			model_table.removeRow(i_row);
		}
	}
	
	public void first() {
		if(this.model.getDsSinhVien().size() == 0) {
			JOptionPane.showMessageDialog(this, "Lỗi");
			
		}else {
			currentDiem = this.model.getDsSinhVien().get(0);
			currentIdx = 0;
			displayDiem();
		}
		
	}
	
	public void prev() {
		if(this.model.getDsSinhVien().size() == 0) {
			JOptionPane.showMessageDialog(this, "Lỗi");
			
	     } else if((currentIdx <= this.model.getDsSinhVien().size() - 1) && (currentIdx > 0) ) {
	    	 currentIdx -=1;
	    	 currentDiem = this.model.getDsSinhVien().get(currentIdx);
	    	 displayDiem();
	     }else{
	    	 currentDiem = this.model.getDsSinhVien().get(this.model.getDsSinhVien().size() - 1);
	    	 currentIdx = this.model.getDsSinhVien().size()-1;
	    	 displayDiem();
	     }
	}
	
	public void next() {
		if(this.model.getDsSinhVien().size() == 0) {
			JOptionPane.showMessageDialog(this, "Lỗi");
			
		}else if(currentIdx < this.model.getDsSinhVien().size() - 1){
			currentIdx += 1;
			currentDiem = this.model.getDsSinhVien().get(currentIdx);
			displayDiem();
		}else { 
			currentDiem = this.model.getDsSinhVien().get(0);
			currentIdx = 0;
			displayDiem();
			
		}
	}
	
	public void last() {
		if(this.model.getDsSinhVien().size() == 0) {
			JOptionPane.showMessageDialog(this, "Lỗi");
			
		}else {
			currentDiem = this.model.getDsSinhVien().get(this.model.getDsSinhVien().size() - 1);
			currentIdx = 0;
			displayDiem();
		}	
	}
	
	private void displayDiem() {
		this.textField_maSinhVien.setText(this.currentDiem.getMaSinhVien()+ "");
		this.textField_hoVaTen.setText(this.currentDiem.getHoVaTen());
		this.textField_monHoc.setText(this.currentDiem.getMonHoc());
		this.textField_chuyenCan.setText(this.currentDiem.getChuyenCan()+ "");
		this.textField_chuyenCan.setText(this.currentDiem.getChuyenCan()+ "");
		this.textField_giuaKy.setText(this.currentDiem.getGiuaKy()+ "");
		this.textField_cuoiKy.setText(this.currentDiem.getCuoiKy()+ "");
		this.textField_he4.setText(this.currentDiem.getHe4()+ "");
		this.textField_hang.setText(this.currentDiem.getHang()+ "");
		
	}
	
	private static final long serialVersionUID = 1L;
	private SinhVien currentDiem;
	private int currentIdx;
	private JButton jButton_frist;
	private JButton jButton_prev;
	private JButton jButton_next;
	private JButton jButton_last;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField_maSinhVien;
	private JTextField textField_hoVaTen;
	private JTextField textField_monHoc;
	private JTextField textField_chuyenCan;
	private JTextField textField_cuoiKy;
	private JTextField textField_giuaKy;
	private JTextField textField_hang;
	private JTextField textField_he4;	
	public SinhVienModel model;
	private JButton jButton_them;
	private JButton jButton_xoa;
	private JButton jButton_capNhat;
	private JButton jButton_huyBo;
	private JButton jButton_save;
	private JButton jButton_thoat;
	private JPanel panel_nhapDiem;
	private JLabel lblNewLabel;
	private JLabel jLabel_maSinhVien;
	private JLabel jLabel_hoVaTen;
	private JLabel jlabel_chuyenCan;
	private JLabel jLabel_giuaKy;
	private JLabel jLabel_CuoiKy;
	private JLabel jLabel_maSinhVien_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JPanel panel_1;
	public NhapDiemModel model_nd;
}