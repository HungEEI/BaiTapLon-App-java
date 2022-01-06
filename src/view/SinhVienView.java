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
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CodeJava\\App\\Img\\student.png"));
		this.setSize(1236, 602);
		setResizable(false);
		this.setLocationRelativeTo(null);
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
		lblNewLabel.setBounds(498, 10, 308, 38);
		contentPane.add(lblNewLabel);

		jButton_thoat = new JButton("Đóng");
		jButton_thoat.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\Logout.png"));
		jButton_thoat.addActionListener(actionListener);
		jButton_thoat.setForeground(Color.RED);
		jButton_thoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		jButton_thoat.setBounds(10, 10, 103, 44);
		contentPane.add(jButton_thoat);

		panel_sinhVien = new JPanel();
		panel_sinhVien.setBounds(10, 65, 1212, 499);
		panel_sinhVien.setBackground(new Color(255, 228, 181));
		contentPane.add(panel_sinhVien);
		panel_sinhVien.setLayout(null);

		lblNewLabel_1 = new JLabel("Quê Quán");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(374, 12, 85, 18);
		panel_sinhVien.add(lblNewLabel_1);

		comboBox_queQuan_timKiem = new JComboBox();
		ArrayList<QueQuan> listTinh = QueQuan.getDSTinh();
		comboBox_queQuan_timKiem.addItem("");
		for (QueQuan tinh : listTinh) {
			comboBox_queQuan_timKiem.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_queQuan_timKiem.setBounds(485, 11, 157, 22);
		panel_sinhVien.add(comboBox_queQuan_timKiem);

		textField_timKiem = new JTextField();
		textField_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_timKiem.setBounds(675, 11, 172, 22);
		panel_sinhVien.add(textField_timKiem);
		textField_timKiem.setColumns(10);

		jButton_timKiem = new JButton("Tìm kiếm");
		jButton_timKiem.addActionListener(actionListener);
		jButton_timKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_timKiem.setBounds(891, 10, 92, 22);
		panel_sinhVien.add(jButton_timKiem);

		jButton_huyTim = new JButton("Hủy tìm");
		jButton_huyTim.addActionListener(actionListener);
		jButton_huyTim.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_huyTim.setBounds(1025, 10, 85, 22);
		panel_sinhVien.add(jButton_huyTim);

		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.setBounds(0, 0, 62, 27);
		panel_sinhVien.add(menuBar);

		mnNewMenu = new JMenu("File");
		mnNewMenu.setForeground(Color.BLUE);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 16));
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

		btn_gioiTinh = new ButtonGroup();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(326, 37, 886, 386);
		panel_sinhVien.add(panel);
		panel.setLayout(null);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 SINH VI\u00CAN", " H\u1ECC V\u00C0 T\u00CAN", " QU\u00CA QU\u00C1N", " NG\u00C0Y SINH", "  GI\u1EDAI T\u00CDNH", "MÔN HỌC", "CHUY\u00CAN C\u1EA6N", "  GI\u1EEEA K\u1EF2", "  CU\u1ED0I K\u1EF2", "  H\u1EC6 10", "  H\u1EA0NG", "  H\u1EC7 4"
			}
		));
		table.setRowHeight(25);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 10, 886, 366);
		panel.add(scrollPane);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 37, 306, 448);
		panel_sinhVien.add(panel_1);
		panel_1.setLayout(null);

		jLabel_maSinhVien = new JLabel("Mã sinh viên");
		jLabel_maSinhVien.setBounds(10, 10, 92, 18);
		panel_1.add(jLabel_maSinhVien);
		jLabel_maSinhVien.setFont(new Font("Tahoma", Font.BOLD, 12));

		jLabel_hoVaTen = new JLabel("Họ và tên");
		jLabel_hoVaTen.setBounds(10, 38, 73, 18);
		panel_1.add(jLabel_hoVaTen);
		jLabel_hoVaTen.setFont(new Font("Tahoma", Font.BOLD, 12));

		lblNewLabel_4 = new JLabel("Ngày sinh");
		lblNewLabel_4.setBounds(10, 66, 73, 18);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));

		jLabel_queQuan = new JLabel("Quê quán");
		jLabel_queQuan.setBounds(10, 94, 73, 18);
		panel_1.add(jLabel_queQuan);
		jLabel_queQuan.setFont(new Font("Tahoma", Font.BOLD, 12));

		textField_maSinhVien = new JTextField();
		textField_maSinhVien.setBounds(125, 9, 156, 22);
		panel_1.add(textField_maSinhVien);
		textField_maSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_maSinhVien.setColumns(10);

		textField_hoVaTen = new JTextField();
		textField_hoVaTen.setBounds(125, 37, 156, 22);
		panel_1.add(textField_hoVaTen);
		textField_hoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_hoVaTen.setColumns(10);

		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setBounds(125, 65, 156, 22);
		panel_1.add(textField_ngaySinh);
		textField_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_ngaySinh.setColumns(10);

		comboBox_queQuan = new JComboBox();
		comboBox_queQuan.setBounds(125, 92, 156, 22);
		comboBox_queQuan.addItem("");
		for (QueQuan tinh : listTinh) {
			comboBox_queQuan.addItem(tinh.getTenTinh());
		}
		panel_1.add(comboBox_queQuan);
		comboBox_queQuan.addItem("");
		comboBox_queQuan.setFont(new Font("Tahoma", Font.PLAIN, 12));

		jLabel_gioiTinh = new JLabel("Giới tính");
		jLabel_gioiTinh.setBounds(10, 132, 66, 18);
		panel_1.add(jLabel_gioiTinh);
		jLabel_gioiTinh.setFont(new Font("Tahoma", Font.BOLD, 12));

		jlabel_chuyenCan = new JLabel("Chuyên Cần");
		jlabel_chuyenCan.setBounds(10, 258, 73, 17);
		panel_1.add(jlabel_chuyenCan);
		jlabel_chuyenCan.setFont(new Font("Tahoma", Font.BOLD, 12));

		jLabel_giuaKy = new JLabel("Giữa kỳ");
		jLabel_giuaKy.setBounds(10, 202, 66, 18);
		panel_1.add(jLabel_giuaKy);
		jLabel_giuaKy.setFont(new Font("Tahoma", Font.BOLD, 12));

		jLabel_CuoiKy = new JLabel("Cuối kỳ");
		jLabel_CuoiKy.setBounds(10, 230, 66, 18);
		panel_1.add(jLabel_CuoiKy);
		jLabel_CuoiKy.setFont(new Font("Tahoma", Font.BOLD, 12));

		radioButton_nam = new JRadioButton("Nam");
		radioButton_nam.setBounds(124, 130, 60, 22);
		panel_1.add(radioButton_nam);
		radioButton_nam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_gioiTinh.add(radioButton_nam);

		radioButton_nu = new JRadioButton("Nữ");
		radioButton_nu.setBounds(227, 130, 54, 22);
		panel_1.add(radioButton_nu);
		radioButton_nu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_gioiTinh.add(radioButton_nu);

		textField_chuyenCan = new JTextField();
		textField_chuyenCan.setBounds(125, 256, 156, 22);
		panel_1.add(textField_chuyenCan);
		textField_chuyenCan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_chuyenCan.setColumns(10);

		textField_giuaKy = new JTextField();
		textField_giuaKy.setBounds(125, 201, 156, 22);
		panel_1.add(textField_giuaKy);
		textField_giuaKy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_giuaKy.setColumns(10);

		textField_cuoiKy = new JTextField();
		textField_cuoiKy.setBounds(125, 229, 156, 22);
		panel_1.add(textField_cuoiKy);
		textField_cuoiKy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_cuoiKy.setColumns(10);

		jLabel_he10 = new JLabel("Hệ 10");
		jLabel_he10.setBounds(10, 350, 45, 27);
		panel_1.add(jLabel_he10);
		jLabel_he10.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel_2 = new JLabel("Hệ 4\r\n");
		lblNewLabel_2.setBounds(10, 295, 45, 22);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));

		jLabel_hang = new JLabel("Hạng");
		jLabel_hang.setBounds(10, 317, 45, 27);
		panel_1.add(jLabel_hang);
		jLabel_hang.setFont(new Font("Tahoma", Font.BOLD, 12));

		textField_he4 = new JTextField();
		textField_he4.setBounds(153, 296, 85, 22);
		panel_1.add(textField_he4);
		textField_he4.setEditable(false);
		textField_he4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_he4.setColumns(10);

		textField_he10 = new JTextField();
		textField_he10.setBounds(153, 321, 85, 22);
		panel_1.add(textField_he10);
		textField_he10.setEditable(false);
		textField_he10.setColumns(10);

		textField_hang = new JTextField();
		textField_hang.setBounds(153, 353, 85, 22);
		panel_1.add(textField_hang);
		textField_hang.setEditable(false);
		textField_hang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_hang.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(64, 224, 208));
		panel_3.setBounds(0, 385, 306, 53);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		btn_first = new JButton("l<");
		btn_first.addActionListener(actionListener);
		btn_first.setForeground(Color.BLACK);
		btn_first.setBackground(new Color(0, 191, 255));
		btn_first.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_first.setBounds(10, 10, 59, 33);
		panel_3.add(btn_first);
		
		btn_prev = new JButton("<<");
		btn_prev.addActionListener(actionListener);
		btn_prev.setBackground(new Color(0, 191, 255));
		btn_prev.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_prev.setBounds(92, 10, 53, 33);
		panel_3.add(btn_prev);
		
		btn_next = new JButton(">>");
		btn_next.addActionListener(actionListener);
		btn_next.setBackground(new Color(0, 191, 255));
		btn_next.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_next.setBounds(165, 10, 53, 33);
		panel_3.add(btn_next);
		
		btn_last = new JButton(">l");
		btn_last.addActionListener(actionListener);
		btn_last.setBackground(new Color(0, 191, 255));
		btn_last.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_last.setBounds(243, 10, 53, 33);
		panel_3.add(btn_last);
		
		JLabel jLabel_monHoc = new JLabel("Môn học");
		jLabel_monHoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel_monHoc.setForeground(Color.BLACK);
		jLabel_monHoc.setBounds(10, 174, 66, 18);
		panel_1.add(jLabel_monHoc);
		
		textField_monHoc = new JTextField();
		textField_monHoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_monHoc.setBounds(125, 170, 156, 22);
		panel_1.add(textField_monHoc);
		textField_monHoc.setColumns(10);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(222, 184, 135));
		panel_2.setBounds(326, 433, 860, 52);
		panel_sinhVien.add(panel_2);
		panel_2.setLayout(null);

		jButton_xoa = new JButton("Xóa");
		jButton_xoa.addActionListener(actionListener);
		jButton_xoa.setBounds(10, 10, 105, 35);
		panel_2.add(jButton_xoa);
		jButton_xoa.setBackground(Color.RED);
		jButton_xoa.setOpaque(true);
		jButton_xoa.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\exit.png"));
		jButton_xoa.setFont(new Font("Tahoma", Font.BOLD, 12));

		jButton_capNhat = new JButton("Cập nhật");
		jButton_capNhat.addActionListener(actionListener);
		jButton_capNhat.setBounds(203, 10, 105, 35);
		panel_2.add(jButton_capNhat);
		jButton_capNhat.setBackground(Color.GREEN);
		jButton_capNhat.setOpaque(true);
		jButton_capNhat.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\update.png"));
		jButton_capNhat.setFont(new Font("Tahoma", Font.BOLD, 12));

		jButton_them = new JButton("Thêm");
		jButton_them.addActionListener(actionListener);
		jButton_them.setBounds(379, 10, 105, 35);
		panel_2.add(jButton_them);
		jButton_them.setBackground(Color.GREEN);
		jButton_them.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\add.png"));
		jButton_them.setFont(new Font("Tahoma", Font.BOLD, 12));

		jButton_huyBo = new JButton("Hủy bỏ");
		jButton_huyBo.addActionListener(actionListener);
		jButton_huyBo.setBounds(572, 10, 101, 35);
		panel_2.add(jButton_huyBo);
		jButton_huyBo.setBackground(Color.RED);
		jButton_huyBo.setOpaque(true);
		jButton_huyBo.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\broom.png"));
		jButton_huyBo.setFont(new Font("Tahoma", Font.BOLD, 12));

		jButton_save = new JButton("Save");
		jButton_save.addActionListener(actionListener);
		jButton_save.setBounds(765, 10, 85, 35);
		panel_2.add(jButton_save);
		jButton_save.setBackground(Color.CYAN);
		jButton_save.setOpaque(true);
		jButton_save.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\Save.png"));
		jButton_save.setFont(new Font("Tahoma", Font.BOLD, 12));

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
		textField_he10.setText("");
		textField_monHoc.setText("");
		comboBox_queQuan.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
	}

	SimpleDateFormat date_Format = new SimpleDateFormat("dd/MM/yyyy");

	public void themSinhVienVaoTable(SinhVien sv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { sv.getMaSinhVien() + "", sv.getHoVaTen(), sv.getQueQuan().getTenTinh(),
				date_Format.format(sv.getNgaySinh(null)), (sv.isGioiTinh() ? "Nam" : "Nữ"), sv.getMonHoc(), sv.getChuyenCan() + "",
				sv.getGiuaKy() + "", sv.getCuoiKy() + "", sv.getHe4(), sv.getHang(), sv.getHe10() });
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
					model_table.setValueAt(sv.getMonHoc() + "", i, 5);
					model_table.setValueAt(sv.getChuyenCan() + "", i, 6);
					model_table.setValueAt(sv.getGiuaKy() + "", i, 7);
					model_table.setValueAt(sv.getCuoiKy() + "", i, 8);
					model_table.setValueAt(sv.getHe4() + "", i, 9);
					model_table.setValueAt(sv.getHang() + "", i, 10);
					model_table.setValueAt(sv.getHe10() + "", i, 11);
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
		String monHoc = this.textField_monHoc.getText();
		float chuyenCan = Float.valueOf(this.textField_chuyenCan.getText());
		float giuaKy = Float.valueOf(this.textField_giuaKy.getText());
		float cuoiKy = Float.valueOf(this.textField_cuoiKy.getText());
		float he4 = model.he4(chuyenCan, giuaKy, cuoiKy);
		textField_he4.setText(he4 + "");
		String hang = model.hang(he4);
		textField_hang.setText(hang);
		double he10 = model.he10(hang);
		textField_he10.setText(he10 + "");

		SinhVien sv = new SinhVien(maSinhVien, hoVaTen, tinh, ngaySinh, monHoc, gioiTinh, chuyenCan, giuaKy, cuoiKy, he4, hang, he10);
		this.themHoacCapNhatSinhVien(sv);
	}

	public SinhVien getSinhVienDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		int maSinhVien = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String hoVaTen = model_table.getValueAt(i_row, 1) + "";
		QueQuan tinh = QueQuan.getTinhByTen(model_table.getValueAt(i_row, 2) + "");

		Date ngaySinh = null;
		try {
			ngaySinh = date_Format.parse(model_table.getValueAt(i_row, 3) + "");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		String monHoc = model_table.getValueAt(i_row, 5) + "";
		float chuyenCan = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		float giuaKy = Float.valueOf(model_table.getValueAt(i_row, 7) + "");
		float cuoiKy = Float.valueOf(model_table.getValueAt(i_row, 8) + "");
		float he4 = Float.valueOf(model_table.getValueAt(i_row, 9) + "");
		String hang = model_table.getValueAt(i_row, 10) + "";
		double he10 = Double.valueOf(model_table.getValueAt(i_row, 11) + "");

		SinhVien sv = new SinhVien(maSinhVien, hoVaTen, tinh, ngaySinh, monHoc, gioiTinh, chuyenCan, giuaKy, cuoiKy, he4, hang, he10);

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
		this.textField_monHoc.setText(sv.getMonHoc()+ "");
		this.textField_chuyenCan.setText(sv.getChuyenCan() + "");
		this.textField_giuaKy.setText(sv.getGiuaKy() + "");
		this.textField_cuoiKy.setText(sv.getCuoiKy() + "");
		this.textField_he4.setText(sv.getHe4() + "");
		this.textField_hang.setText(sv.getHang() + "");
		this.textField_he10.setText(sv.getHe10() + "");
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
			if (soLuongDong == 0)
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
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void thucHienSaveFile() {
		if (this.model.getTenFile().length() > 0) {
			saveFile(this.model.getTenFile());
		} else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
		JOptionPane.showMessageDialog(this, "Lưu thành công!");
	}

////// CSV
	public void fileCSV() {
		try {
			FileWriter writer = new FileWriter("DanhSachSinhVien.csv");
			for (SinhVien sinhVien : this.model.getDsSinhVien()) {
				writer.write(sinhVien.toString() + "\n");
			}
			writer.close();
		} catch (IOException e) {
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
			while ((sv = (SinhVien) ois.readObject()) != null) {
				ds.add(sv);
			}
			ois.close();
			fis.close();
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

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không ?", "Xóa", JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			SinhVien sv = getSinhVienDangChon();
			this.model.delete(sv);
			model_table.removeRow(i_row);
		}
	}
	
	public void first() {
		if(this.model.getDsSinhVien().size() == 0) {
			JOptionPane.showMessageDialog(this, "Lỗi");
			
		}else {
			currentSinhVien = this.model.getDsSinhVien().get(0);
			currentIdx = 0;
			displayKhoaHoc();
		}
		
	}
	
	public void prev() {
		if(this.model.getDsSinhVien().size() == 0) {
			JOptionPane.showMessageDialog(this, "Lỗi");
			
	     } else if((currentIdx <= this.model.getDsSinhVien().size() - 1) && (currentIdx > 0) ) {
	    	 currentIdx -=1;
	    	 currentSinhVien = this.model.getDsSinhVien().get(currentIdx);
	    	 displayKhoaHoc();
	     }else{
	    	 currentSinhVien = this.model.getDsSinhVien().get(this.model.getDsSinhVien().size() - 1);
	    	 currentIdx = this.model.getDsSinhVien().size()-1;
	    	 displayKhoaHoc();
	     }
	}
	
	public void next() {
		if(this.model.getDsSinhVien().size() == 0) {
			JOptionPane.showMessageDialog(this, "Lỗi");
			
		}else if(currentIdx < this.model.getDsSinhVien().size() - 1){
			currentIdx += 1;
			currentSinhVien = this.model.getDsSinhVien().get(currentIdx);
			displayKhoaHoc();
		}else { 
			currentSinhVien = this.model.getDsSinhVien().get(0);
			currentIdx = 0;
			displayKhoaHoc();
			
		}
	}
	
	public void last() {
		if(this.model.getDsSinhVien().size() == 0) {
			JOptionPane.showMessageDialog(this, "Lỗi");
			
		}else {
			currentSinhVien = this.model.getDsSinhVien().get(this.model.getDsSinhVien().size() - 1);
			currentIdx = 0;
			displayKhoaHoc();
		}	
	}
	
	private void displayKhoaHoc() {
		this.textField_maSinhVien.setText(this.currentSinhVien.getMaSinhVien()+ "");
		this.textField_hoVaTen.setText(this.currentSinhVien.getHoVaTen());
		this.textField_ngaySinh.setText(date_Format.format(this.currentSinhVien.getNgaySinh(null)));
		this.textField_monHoc.setText(this.currentSinhVien.getMonHoc()+"");
		this.textField_chuyenCan.setText(this.currentSinhVien.getChuyenCan()+"");
		this.textField_giuaKy.setText(this.currentSinhVien.getGiuaKy()+"");
		this.textField_cuoiKy.setText(this.currentSinhVien.getCuoiKy()+"");
		this.textField_hang.setText(this.currentSinhVien.getHang()+"");
		this.textField_he4.setText(this.currentSinhVien.getHe4()+"");
		this.textField_he10.setText(this.currentSinhVien.getHe10()+"");
		this.comboBox_queQuan.setSelectedItem(this.currentSinhVien.getQueQuan()+"");
	}
	
	private SinhVien currentSinhVien;
	private int currentIdx;
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
	private JTextField textField_he10;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btn_first;
	private JButton btn_prev;
	private JButton btn_next;
	private JButton btn_last;
	private JTextField textField_monHoc;
}