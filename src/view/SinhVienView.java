package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.SinhVienController;
import model.QueQuan;
import model.SinhVien;
import model.SinhVienModel;

public class SinhVienView extends JFrame {

	private static final long serialVersionUID = 1L;

	public SinhVienView() {
		init();	
	}
	
///////---Form
	public void init() {
		this.model = new SinhVienModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CodeJava\\App\\Img\\student.png"));
		this.setSize(880, 617);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener actionListener = new SinhVienController(this);
		
		lblNewLabel = new JLabel("Quản Lý Sinh Viên");
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
		
		panel_sinhVien = new JPanel();
		panel_sinhVien.setBounds(10, 65, 846, 512);
		panel_sinhVien.setBackground(new Color(255, 228, 181));
		contentPane.add(panel_sinhVien);
		panel_sinhVien.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Quê Quán");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(141, 5, 73, 18);
		panel_sinhVien.add(lblNewLabel_1);
		
		comboBox_queQuan_timKiem = new JComboBox();
		ArrayList<QueQuan> listTinh = QueQuan.getDSTinh();
		comboBox_queQuan_timKiem.addItem("");
		for (QueQuan tinh : listTinh) {
			comboBox_queQuan_timKiem.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_queQuan_timKiem.setBounds(224, 6, 157, 22);
		panel_sinhVien.add(comboBox_queQuan_timKiem);
		
		textField_timKiem = new JTextField();
		textField_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_timKiem.setBounds(423, 7, 172, 22);
		panel_sinhVien.add(textField_timKiem);
		textField_timKiem.setColumns(10);
		
		jButton_timKiem = new JButton("Tìm kiếm");
		jButton_timKiem.addActionListener(actionListener);
		jButton_timKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_timKiem.setBounds(628, 6, 92, 22);
		panel_sinhVien.add(jButton_timKiem);
		
		jButton_huyTim = new JButton("Hủy tìm");
		jButton_huyTim.addActionListener(actionListener);
		jButton_huyTim.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_huyTim.setBounds(746, 6, 85, 22);
		panel_sinhVien.add(jButton_huyTim);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 45, 27);
		panel_sinhVien.add(menuBar);
		
		mnNewMenu = new JMenu("File");
		mnNewMenu.setForeground(Color.BLUE);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnNewMenu);
		
		jMenuItem_open = new JMenuItem("Open");
		jMenuItem_open.setForeground(Color.BLUE);
		jMenuItem_open.setBackground(Color.WHITE);
		jMenuItem_open.addActionListener(actionListener);
		jMenuItem_open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		jMenuItem_open.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnNewMenu.add(jMenuItem_open);
		
		jMenuItem_save = new JMenuItem("Save");
		jMenuItem_save.setForeground(Color.BLUE);
		jMenuItem_save.addActionListener(actionListener);
		jMenuItem_save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu.add(jMenuItem_save);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 33, 841, 2);
		panel_sinhVien.add(separator_1);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				" MÃ SINH VIÊN", "   HỌ VÀ TÊN", "   QUÊ QUÁN", "   NGÀY SINH", "   GIỚI TÍNH",
				"  CHUYÊN CẦN", "     GIỮA KỲ", "     CUỐI KỲ", "        HỆ 10", "       HẠNG"
			}
		));
		table.setRowHeight(25);
	
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 45, 821, 243);
		panel_sinhVien.add(scrollPane);
		
		jLabel_maSinhVien = new JLabel("Mã sinh viên");
		jLabel_maSinhVien.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel_maSinhVien.setBounds(28, 310, 92, 18);
		panel_sinhVien.add(jLabel_maSinhVien);
		
		jLabel_hoVaTen = new JLabel("Họ và tên");
		jLabel_hoVaTen.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel_hoVaTen.setBounds(28, 338, 73, 18);
		panel_sinhVien.add(jLabel_hoVaTen);
		
		lblNewLabel_4 = new JLabel("Ngày sinh");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(28, 366, 73, 18);
		panel_sinhVien.add(lblNewLabel_4);
		
		jLabel_queQuan = new JLabel("Quê quán");
		jLabel_queQuan.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel_queQuan.setBounds(28, 394, 73, 18);
		panel_sinhVien.add(jLabel_queQuan);
		
		jLabel_gioiTinh = new JLabel("Giới tính");
		jLabel_gioiTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel_gioiTinh.setBounds(362, 310, 66, 18);
		panel_sinhVien.add(jLabel_gioiTinh);
		
		jlabel_chuyenCan = new JLabel("Chuyên Cần");
		jlabel_chuyenCan.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabel_chuyenCan.setBounds(362, 339, 73, 17);
		panel_sinhVien.add(jlabel_chuyenCan);
		
		jLabel_giuaKy = new JLabel("Giữa kỳ");
		jLabel_giuaKy.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel_giuaKy.setBounds(362, 367, 66, 18);
		panel_sinhVien.add(jLabel_giuaKy);
		
		jLabel_CuoiKy = new JLabel("Cuối kỳ");
		jLabel_CuoiKy.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel_CuoiKy.setBounds(362, 394, 66, 18);
		panel_sinhVien.add(jLabel_CuoiKy);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 298, 841, 2);
		panel_sinhVien.add(separator_1_1);
		
		textField_maSinhVien = new JTextField();
		textField_maSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_maSinhVien.setBounds(154, 307, 142, 22);
		panel_sinhVien.add(textField_maSinhVien);
		textField_maSinhVien.setColumns(10);
		
		textField_hoVaTen = new JTextField();
		textField_hoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_hoVaTen.setBounds(154, 339, 142, 22);
		panel_sinhVien.add(textField_hoVaTen);
		textField_hoVaTen.setColumns(10);
		
		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_ngaySinh.setBounds(154, 367, 142, 22);
		panel_sinhVien.add(textField_ngaySinh);
		textField_ngaySinh.setColumns(10);
		
		comboBox_queQuan = new JComboBox();
		comboBox_queQuan.addItem("");
		for (QueQuan tinh : listTinh) {
			comboBox_queQuan.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_queQuan.setBounds(154, 394, 142, 22);
		panel_sinhVien.add(comboBox_queQuan);
		
		textField_chuyenCan = new JTextField();
		textField_chuyenCan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_chuyenCan.setBounds(463, 339, 142, 22);
		panel_sinhVien.add(textField_chuyenCan);
		textField_chuyenCan.setColumns(10);
		
		textField_giuaKy = new JTextField();
		textField_giuaKy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_giuaKy.setBounds(463, 367, 142, 22);
		panel_sinhVien.add(textField_giuaKy);
		textField_giuaKy.setColumns(10);
		
		textField_cuoiKy = new JTextField();
		textField_cuoiKy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_cuoiKy.setBounds(463, 395, 142, 22);
		panel_sinhVien.add(textField_cuoiKy);
		textField_cuoiKy.setColumns(10);
		
		radioButton_nam = new JRadioButton("Nam");
		radioButton_nam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radioButton_nam.setBounds(463, 306, 60, 22);
		panel_sinhVien.add(radioButton_nam);
		
		radioButton_nu = new JRadioButton("Nữ");
		radioButton_nu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radioButton_nu.setBounds(541, 306, 54, 22);
		panel_sinhVien.add(radioButton_nu);
		
		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(radioButton_nam);
		btn_gioiTinh.add(radioButton_nu);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(0, 437, 841, 2);
		panel_sinhVien.add(separator_1_1_1);
		
		jButton_them = new JButton("Thêm");
		jButton_them.setBackground(Color.GREEN);
		jButton_them.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\add.png"));
		jButton_them.addActionListener(actionListener);
		jButton_them.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_them.setBounds(418, 455, 105, 35);
		panel_sinhVien.add(jButton_them);
		
		jButton_xoa = new JButton("Xóa");
		jButton_xoa.setBackground(Color.RED);
		jButton_xoa.setOpaque(true);
		jButton_xoa.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\exit.png"));
		jButton_xoa.addActionListener(actionListener);
		jButton_xoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_xoa.setBounds(131, 455, 105, 35);
		panel_sinhVien.add(jButton_xoa);
		
		jButton_capNhat = new JButton("Cập nhật");
		jButton_capNhat.setBackground(Color.GREEN);
		jButton_capNhat.setOpaque(true);
		jButton_capNhat.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\update.png"));
		jButton_capNhat.addActionListener(actionListener);
		jButton_capNhat.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_capNhat.setBounds(276, 455, 105, 35);
		panel_sinhVien.add(jButton_capNhat);
		
		jButton_huyBo = new JButton("Hủy bỏ");
		jButton_huyBo.setBackground(Color.RED);
		jButton_huyBo.setOpaque(true);
		jButton_huyBo.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\broom.png"));
		jButton_huyBo.addActionListener(actionListener);
		jButton_huyBo.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_huyBo.setBounds(561, 455, 101, 35);
		panel_sinhVien.add(jButton_huyBo);
		
		jButton_save = new JButton("Save");
		jButton_save.setBackground(Color.CYAN);
		jButton_save.setOpaque(true);
		jButton_save.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\Save.png"));
		jButton_save.addActionListener(actionListener);
		jButton_save.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_save.setBounds(708, 455, 85, 35);
		panel_sinhVien.add(jButton_save);
		
		jLabel_he10 = new JLabel("Hệ 10");
		jLabel_he10.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel_he10.setBounds(653, 334, 45, 27);
		panel_sinhVien.add(jLabel_he10);
		
		textField_he4 = new JTextField();
		textField_he4.setEditable(false);
		textField_he4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_he4.setBounds(708, 339, 85, 22);
		panel_sinhVien.add(textField_he4);
		textField_he4.setColumns(10);
		
		jLabel_hang = new JLabel("Hạng");
		jLabel_hang.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel_hang.setBounds(653, 362, 45, 27);
		panel_sinhVien.add(jLabel_hang);
		
		textField_hang = new JTextField();
		textField_hang.setEditable(false);
		textField_hang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_hang.setBounds(708, 367, 85, 22);
		panel_sinhVien.add(textField_hang);
		textField_hang.setColumns(10);		
		
		this.setVisible(true);
	}
	
	public void xoaForm() {
		textField_maSinhVien.setText("");
		textField_hoVaTen.setText("");
		textField_timKiem.setText("");
		textField_ngaySinh.setText("");
		textField_chuyenCan.setText("");
		textField_giuaKy.setText("");
		textField_cuoiKy.setText("");
		textField_he4.setText("");
		textField_hang.setText("");
		comboBox_queQuan.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
	}
	
	SimpleDateFormat date_Format = new SimpleDateFormat("dd/MM/yyyy");
	
	public void themSinhVienVaoTable(SinhVien sv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] {sv.getMaSinhVien() + "", sv.getHoVaTen(), 
										 sv.getQueQuan().getTenTinh(),
										 date_Format.format(sv.getNgaySinh(null)),
										 (sv.isGioiTinh() ? "Nam" : "Nữ"), sv.getChuyenCan() + "", 
										 sv.getGiuaKy() + "", sv.getCuoiKy() + "",
										 sv.getHe4(), sv.getHang()});
	}
	
	public void themHoacCapNhatSinhVien(SinhVien sv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(sv)) {
			this.model.insert(sv);
			this.themSinhVienVaoTable(sv);
		} else {
			this.model.update(sv);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(sv.getMaSinhVien() + "")) {
					model_table.setValueAt(sv.getMaSinhVien() + "", i, 0);
					model_table.setValueAt(sv.getHoVaTen() + "", i, 1);
					model_table.setValueAt(sv.getQueQuan().getTenTinh() + "", i, 2);
					model_table.setValueAt(date_Format.format(sv.getNgaySinh(null)), i, 3);
					model_table.setValueAt((sv.isGioiTinh() ? "Nam" : "Nữ"), i, 4);
					model_table.setValueAt(sv.getChuyenCan() + "", i, 5);
					model_table.setValueAt(sv.getGiuaKy() + "", i, 6);
					model_table.setValueAt(sv.getCuoiKy() + "", i, 7);
					model_table.setValueAt(sv.getHe4() + "", i, 8);
					model_table.setValueAt(sv.getHang() + "", i, 9);
					
				}
			}
		}
	}
	
	public void thucHienThemSinhVien() throws ParseException {
////////----Lấy dữ liệu
		int maSinhVien = Integer.valueOf(this.textField_maSinhVien.getText());
		String hoVaTen = this.textField_hoVaTen.getText();
		int queQuan = this.comboBox_queQuan.getSelectedIndex() - 1;
		QueQuan tinh = QueQuan.getTinhById(queQuan);
		Date ngaySinh = date_Format.parse(textField_ngaySinh.getText());
	
		boolean gioiTinh = true;
		if (this.radioButton_nam.isSelected()) {
			gioiTinh = true;
		} else if (this.radioButton_nu.isSelected()) {
			gioiTinh = false;
		}
		
		float chuyenCan = Float.valueOf(this.textField_chuyenCan.getText());
		float giuaKy = Float.valueOf(this.textField_giuaKy.getText());
		float cuoiKy = Float.valueOf(this.textField_cuoiKy.getText());		
		float he4 = model.he4(chuyenCan, giuaKy, cuoiKy);
		textField_he4.setText(he4+"");					
		String hang = model.hang(he4);
		textField_hang.setText(hang);
		
		SinhVien sv = new SinhVien(maSinhVien, hoVaTen, tinh, ngaySinh, gioiTinh, chuyenCan, giuaKy, cuoiKy, he4, hang);
		this.themHoacCapNhatSinhVien(sv);
	}
	
	public SinhVien getSinhVienDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
	
		int maSinhVien = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String hoVaTen = model_table.getValueAt(i_row, 1) + "";
		QueQuan tinh = QueQuan.getTinhByTen(model_table.getValueAt(i_row, 2) + "");
//		String s_ngaySinh = model_table.getValueAt(i_row, 3) + "";
//		Date ngaySinh = new Date(s_ngaySinh);
		
		Date ngaySinh = null;
		try {
			ngaySinh = date_Format.parse(model_table.getValueAt(i_row, 3) + "");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float chuyenCan = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		float giuaKy = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		float cuoiKy = Float.valueOf(model_table.getValueAt(i_row, 7) + "");
		float he4 = Float.valueOf(model_table.getValueAt(i_row, 8) + "");
		String hang = model_table.getValueAt(i_row, 9) + "";
	
		SinhVien sv = new SinhVien(maSinhVien, hoVaTen, tinh, ngaySinh, gioiTinh, 
									chuyenCan, giuaKy, cuoiKy, he4, hang);
		
		return sv;
	}
	
	public void hienThiThongTinSinhVienDaChon() {
		SinhVien sv = getSinhVienDangChon();
		this.textField_maSinhVien.setText(sv.getMaSinhVien() + "");
		this.textField_hoVaTen.setText(sv.getHoVaTen() + "");
		this.comboBox_queQuan.setSelectedItem(sv.getQueQuan().getTenTinh());		
		String s_ngaySinh = date_Format.format(sv.getNgaySinh(null));
		this.textField_ngaySinh.setText(s_ngaySinh + "");
		if (sv.isGioiTinh()) {
			radioButton_nam.setSelected(true);			
		} else {
			radioButton_nu.setSelected(true);			
		}
		this.textField_chuyenCan.setText(sv.getChuyenCan() + "");
		this.textField_giuaKy.setText(sv.getGiuaKy() + "");
		this.textField_cuoiKy.setText(sv.getCuoiKy() + "");
		this.textField_he4.setText(sv.getHe4() + "");
		this.textField_hang.setText(sv.getHang() + "");
	}
		
	public void thucHienTim() {
	
		this.thucHienTaiLaiDuLieu();
		
////////----Thực hiện tìm kiếm
		int queQuan = this.comboBox_queQuan_timKiem.getSelectedIndex() - 1;
		String maSinhVienTimKiem = this.textField_timKiem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
	
		Set<Integer> idCuaSinhVienCanXoa = new TreeSet<Integer>();
		if (queQuan >= 0) {
			QueQuan tinhDaChon = QueQuan.getTinhById(queQuan);
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 2) + "";
				String id = model_table.getValueAt(i, 0) + "";
				if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
					idCuaSinhVienCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if (maSinhVienTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (!id.equals(maSinhVienTimKiem)) {
					idCuaSinhVienCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer idCanXoa : idCuaSinhVienCanXoa) {
			System.out.println(idCanXoa);
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				System.out.println("idTrongTable: " + idTrongTable);
				if (idTrongTable.equals(idCanXoa.toString())) {
					System.out.println("Đã xóa: " + i);
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
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
			this.themSinhVienVaoTable(sv);
		}
	}	

//////---File
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

////// CSV
	public void fileCSV() {
		try {
			FileWriter writer = new FileWriter("test.csv");
				for(SinhVien sinhVien : this.model.getDsSinhVien()) {
				writer.write(sinhVien.toString()+ "\n");
			}
			writer.close();	
		}catch (IOException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
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
	
//////---Cảnh báo		
	public void hienThiSave() {
		JOptionPane.showMessageDialog(this, "Lưu thành công!");
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không ?",
													"Xóa", JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			SinhVien sv = getSinhVienDangChon();
			this.model.delete(sv);
			model_table.removeRow(i_row);
		}
	}

	public SinhVienModel model;
	private JPanel contentPane;
	private JComboBox comboBox_queQuan_timKiem;
	private JMenuItem jMenuItem_open;
	private JMenuItem jMenuItem_save;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JTable table;	
	private JTextField textField_timKiem;
	private JTextField textField_maSinhVien;
	private JTextField textField_hoVaTen;
	private JTextField textField_ngaySinh;
	private JComboBox comboBox_queQuan;
	private JTextField textField_chuyenCan;
	private JTextField textField_giuaKy;
	private JTextField textField_cuoiKy;
	private JTextField textField_he4;
	private JTextField textField_hang;
	private JRadioButton radioButton_nam;
	private JRadioButton radioButton_nu;
	private ButtonGroup btn_gioiTinh;
	private JButton jButton_thoat;
	private JButton jButton_timKiem;
	private JButton jButton_huyTim;
	private JButton jButton_them;
	private JButton jButton_xoa;
	private JButton jButton_capNhat;
	private JButton jButton_huyBo;
	private JButton jButton_save;
	private JPanel panel_sinhVien;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel jLabel_maSinhVien;
	private JLabel jLabel_hoVaTen;
	private JLabel lblNewLabel_4;
	private JLabel jLabel_queQuan;
	private JLabel jLabel_gioiTinh;
	private JLabel jlabel_chuyenCan;
	private JLabel jLabel_giuaKy;
	private JLabel jLabel_CuoiKy;
	private JLabel jLabel_he10;
	private JLabel jLabel_hang;
}