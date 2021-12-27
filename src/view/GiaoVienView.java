package view;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.GiangVienController;
import model.GiangVien;
import model.GiangVienModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
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
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Toolkit;

public class GiaoVienView extends JFrame {

	private static final long serialVersionUID = 1L;
	private ButtonGroup btn_hocVi2;

	public GiaoVienView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CodeJava\\App\\Img\\10218-man-teacher-icon.png"));
		init();
	}
	
	public void init() {
		this.model = new GiangVienModel();
		this.setSize(880, 617);
		this.setTitle("GIÁO VIÊN");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener actionListener = new GiangVienController(this);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Giáo VIên");
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
		
		panel_giangVien = new JPanel();
		panel_giangVien.setBackground(new Color(255, 204, 153));
		panel_giangVien.setBounds(10, 67, 846, 503);
		contentPane.add(panel_giangVien);
		panel_giangVien.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 38, 22);
		panel_giangVien.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu.setForeground(Color.BLUE);
		menuBar.add(mnNewMenu);
		
		JMenuItem jMenuItem_open = new JMenuItem("Open");
		jMenuItem_open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		jMenuItem_open.setForeground(Color.BLUE);
		jMenuItem_open.addActionListener(actionListener);
		mnNewMenu.add(jMenuItem_open);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"HỌ VÀ TÊN", "NĂM SINH", "EMAIL", "HỌC HÀM/HỌC VỊ", "LƯƠNG"
			}
		));
		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 32, 826, 267);
		panel_giangVien.add(scrollPane);
		
		jButton_them = new JButton("Thêm");
		jButton_them.setBackground(Color.GREEN);
		jButton_them.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\add.png"));
		jButton_them.addActionListener(actionListener);
		jButton_them.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_them.setBounds(390, 455, 105, 35);
		panel_giangVien.add(jButton_them);
		
		jButton_xoa = new JButton("Xóa");
		jButton_xoa.setBackground(Color.RED);
		jButton_xoa.setOpaque(true);
		jButton_xoa.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\exit.png"));
		jButton_xoa.addActionListener(actionListener);
		jButton_xoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_xoa.setBounds(66, 455, 105, 35);
		panel_giangVien.add(jButton_xoa);
		
		jButton_capNhat = new JButton("Cập nhật");
		jButton_capNhat.setBackground(Color.GREEN);
		jButton_capNhat.setOpaque(true);
		jButton_capNhat.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\update.png"));
		jButton_capNhat.addActionListener(actionListener);
		jButton_capNhat.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_capNhat.setBounds(226, 455, 105, 35);
		panel_giangVien.add(jButton_capNhat);
		
		jButton_huyBo = new JButton("Hủy bỏ");
		jButton_huyBo.setBackground(Color.RED);
		jButton_huyBo.setOpaque(true);
		jButton_huyBo.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\broom.png"));
		jButton_huyBo.addActionListener(actionListener);
		jButton_huyBo.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_huyBo.setBounds(561, 455, 101, 35);
		panel_giangVien.add(jButton_huyBo);
		
		jButton_save = new JButton("Save");
		jButton_save.setBackground(Color.CYAN);
		jButton_save.setOpaque(true);
		jButton_save.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\Save.png"));
		jButton_save.addActionListener(actionListener);
		jButton_save.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_save.setBounds(708, 455, 85, 35);
		panel_giangVien.add(jButton_save);
		
		JLabel lbl = new JLabel("Họ và tên");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl.setBounds(51, 325, 76, 22);
		panel_giangVien.add(lbl);
		
		lblNewLabel_1 = new JLabel("Năm Sinh");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(51, 370, 76, 22);
		panel_giangVien.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Lương");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(450, 370, 64, 22);
		panel_giangVien.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(450, 325, 45, 22);
		panel_giangVien.add(lblNewLabel_3);
		
		textField_hoVaTen = new JTextField();
		textField_hoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_hoVaTen.setBounds(164, 327, 242, 24);
		panel_giangVien.add(textField_hoVaTen);
		textField_hoVaTen.setColumns(10);
		
		textField_namSinh = new JTextField();
		textField_namSinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_namSinh.setBounds(164, 370, 242, 24);
		panel_giangVien.add(textField_namSinh);
		textField_namSinh.setColumns(10);
		
		textField_luong = new JTextField();
		textField_luong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_luong.setBounds(527, 370, 242, 24);
		panel_giangVien.add(textField_luong);
		textField_luong.setColumns(10);
		
		textField_email = new JTextField();
		textField_email.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_email.setBounds(527, 327, 242, 24);
		panel_giangVien.add(textField_email);
		textField_email.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Học hàm/Học vị");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(51, 404, 101, 22);
		panel_giangVien.add(lblNewLabel_4);
		
		rd_PGSTS = new JRadioButton("PGS.TS");
		rd_PGSTS.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rd_PGSTS.setBounds(193, 405, 76, 21);
		panel_giangVien.add(rd_PGSTS);
		
		rd_TS = new JRadioButton("TS");
		rd_TS.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rd_TS.setBounds(289, 405, 52, 21);
		panel_giangVien.add(rd_TS);
		
		btn_hocVi = new ButtonGroup();
		btn_hocVi.add(rd_TS);
		btn_hocVi.add(rd_PGSTS);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 446, 836, -1);
		panel_giangVien.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 455, 85, -12);
		panel_giangVien.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 440, 836, 5);
		panel_giangVien.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 309, 846, 6);
		panel_giangVien.add(separator_3);
		
		this.setVisible(true);
	}
	
	public void xoaForm() {
		textField_hoVaTen.setText("");
		textField_namSinh.setText("");
		textField_email.setText("");
		textField_luong.setText("");
	}
	
	SimpleDateFormat date_Format = new SimpleDateFormat("dd/MM/yyyy");
	
	public void themGiangVienVaoTable(GiangVien gv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] {gv.getHoVaTen(), 										
										 date_Format.format(gv.getNgaySinh()),
										 gv.getEmail(), (gv.isHocVi() ? "TS" : "PGS.TS"),
										 gv.getLuong()+""});
	}
	
	public void thucHienThemGiangVien() throws ParseException {
		////////----Lấy dữ liệu
			String hoVaTen = this.textField_hoVaTen.getText();
			Date ngaySinh = date_Format.parse(textField_namSinh.getText());
			String email = this.textField_email.getText();
		
			boolean hocVi = true;
			if(this.rd_TS.isSelected()) {
				hocVi = true;
			} else if(this.rd_PGSTS.isSelected()) {
				hocVi = false;
			}
			
			float luong = Float.valueOf(this.textField_luong.getText());
			
			GiangVien gv = new GiangVien(hoVaTen, ngaySinh, email, hocVi, luong);
			this.themHoacCapNhatGiangVien(gv);
		}
	
	public void themHoacCapNhatGiangVien(GiangVien gv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(gv)) {
			this.model.insert(gv);
			this.themGiangVienVaoTable(gv);
		} else {
			this.model.update(gv);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(gv.getHoVaTen() + "")) {
					model_table.setValueAt(gv.getHoVaTen() + "", i, 0);
					model_table.setValueAt(date_Format.format(gv.getNgaySinh()) + "", i, 1);
					model_table.setValueAt(gv.getEmail() + "", i, 2);
					model_table.setValueAt((gv.isHocVi() ? "TS" : "PGS.TS"), i, 3);
					model_table.setValueAt(gv.getLuong()+ "", i, 4);					
				}
			}
		}
	}
	
	public GiangVien getGiangVienDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
	
		String hoVaTen = model_table.getValueAt(i_row, 0) + "";
		String s_ngaySinh = model_table.getValueAt(i_row, 1) + "";
		Date ngaySinh = new Date(s_ngaySinh);
		String email = model_table.getValueAt(i_row, 2) + "";
		String textHocVi = model_table.getValueAt(i_row, 3) + "";
		boolean hocVi = textHocVi.equals("TS");
		float luong = Float.valueOf(model_table.getValueAt(i_row, 4) + "");
		
		GiangVien gv = new GiangVien(hoVaTen, ngaySinh, email, hocVi, luong);
		return gv;
	}
	
	public void hienThiThongTinGiangVienDaChon() {
		GiangVien gv = getGiangVienDangChon();
		this.textField_hoVaTen.setText(gv.getHoVaTen() + "");		
		String s_ngaySinh = date_Format.format(gv.getNgaySinh());
		this.textField_namSinh.setText(s_ngaySinh + "");
		this.textField_email.setText(gv.getEmail());
		
		if (gv.isHocVi()) {
			rd_TS.setSelected(true);			
		} else {
			rd_PGSTS.setSelected(true);			
		}
		
		this.textField_luong.setText(gv.getLuong() + "");
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
		for (GiangVien gv : this.model.getDsGiangVien()) {
			this.themGiangVienVaoTable(gv);
		}
	}	

//////---File
	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (GiangVien gv : this.model.getDsGiangVien()) {
				oos.writeObject(gv);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//////---FileCSV
	public void FileCSV() {
		try {
			FileWriter 	writer = new FileWriter("DanhSachGiangVien.csv");
			for (GiangVien giangVien : this.model.getDsGiangVien()) {
				writer.write(giangVien.toString() + "\n");
			}
			writer.close();
		} catch (IOException e) {
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
		ArrayList<GiangVien> ds = new ArrayList<GiangVien>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			GiangVien gv = null;
			while((gv = (GiangVien) ois.readObject())!=null) {
				ds.add(gv);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsGiangVien(ds);
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
	
///////---Cảnh báo		
	public void hienThiSave() {
		JOptionPane.showMessageDialog(this, "Lưu thành công!");
	}
	
	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn thoát khỏi chương trình?",
			    "Thoát",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không ?",
													"Xóa", JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			GiangVien gv =getGiangVienDangChon();
			this.model.delete(gv);
			model_table.removeRow(i_row);
		}
	}
	
	private JPanel contentPane;
	private JTable table;
	private JTextField textField_hoVaTen;
	private JTextField textField_namSinh;
	private JTextField textField_luong;
	private JTextField textField_email;	
	public GiangVienModel model;
	private ButtonGroup btn_hocVi;
	private JRadioButton rd_PGSTS;
	private JRadioButton rd_TS;
	private JButton jButton_thoat;
	private JButton jButton_them;
	private JButton jButton_xoa;
	private JButton jButton_capNhat;
	private JButton jButton_huyBo;
	private JButton jButton_save;
	private JPanel panel_giangVien;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
}