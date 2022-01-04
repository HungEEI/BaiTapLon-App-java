package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.KetQuaController;
import model.SinhVien;
import model.SinhVienModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.Toolkit;

public class DangKyKhocHoc extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table_kq;	
	public SinhVienModel model;
	private JButton jButton_open;
	private JButton jButton_dong;
	
	public DangKyKhocHoc() {
		setTitle("ĐIỂM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CodeJava\\App\\Img\\Courses.png"));
		
		this.model = new SinhVienModel();
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(745, 500);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener abc = new KetQuaController(this);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 49, 709, 403);
		contentPane.add(tabbedPane);
		
		jButton_dong = new JButton("Đóng");
		jButton_dong.setBackground(Color.CYAN);
		jButton_dong.setForeground(Color.RED);
		jButton_dong.addActionListener(abc);
		jButton_dong.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_dong.setBounds(10, 8, 85, 31);
		contentPane.add(jButton_dong);
		
		JPanel panel_ketQuaHoc = new JPanel();
		panel_ketQuaHoc.setBackground(new Color(255, 225, 181));
		tabbedPane.addTab("Kết quả học tập", null, panel_ketQuaHoc, null);
		panel_ketQuaHoc.setLayout(null);
		
		table_kq = new JTable();
		table_kq.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_kq.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				" MÃ SINH VIÊN", "   HỌ VÀ TÊN", "   MÔN HỌC",
				"  CHUYÊN CẦN", "     GIỮA KỲ", "     CUỐI KỲ", "        HỆ 10", "       HẠNG"
			}
		));
		table_kq.setRowHeight(25);
	
		JScrollPane scrollPane = new JScrollPane(table_kq);
		scrollPane.setBounds(10, 39, 684, 327);
		panel_ketQuaHoc.add(scrollPane);
		
		jButton_open = new JButton("Mở File Điểm");
		jButton_open.addActionListener(abc);
		jButton_open.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_open.setForeground(Color.BLUE);
		jButton_open.setBounds(10, 0, 118, 35);
		panel_ketQuaHoc.add(jButton_open);
		
		JButton jButton_dk = new JButton("Đăng Ký học");
		jButton_dk.setFont(new Font("Tahoma", Font.BOLD, 10));
		jButton_dk.addActionListener(abc);
		jButton_dk.setForeground(Color.BLACK);
		jButton_dk.setBounds(162, 10, 97, 22);
		panel_ketQuaHoc.add(jButton_dk);
		
		JLabel lblNewLabel = new JLabel("Điểm");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(252, 10, 233, 40);
		contentPane.add(lblNewLabel);
		
		this.setVisible(true);
	}
	
	public void themDiemVaoTable_KQ(SinhVien sv) {
		DefaultTableModel model_table = (DefaultTableModel) table_kq.getModel();
		model_table.addRow(new Object[] {sv.getMaSinhVien() + "", sv.getHoVaTen(), 
										 sv.getMonHoc(), sv.getChuyenCan() + "", 
										 sv.getGiuaKy() + "", sv.getCuoiKy() + "",
										 sv.getHe4(), sv.getHang()});
	}
	
	public void thucHienTaiLaiDuLieu_KQ() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table_kq.getModel();
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
			this.themDiemVaoTable_KQ(sv);
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
			thucHienTaiLaiDuLieu_KQ();
		} 
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
}