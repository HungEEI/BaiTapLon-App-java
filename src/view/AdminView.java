package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionListener;
import controller.AdminController;
import model.SinhVienModel;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;

public class AdminView extends JFrame {
	private static final long serialVersionUID = 1L;
	
	Thread th;

	public AdminView() {
		init();
	}
	
////////---Form	
	public void init() {
		
		this.model = new SinhVienModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CodeJava\\App\\Img\\student.png"));
		this.setSize(880, 655);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener actionListener = new AdminController(this);
		
		jButton_thoat = new JButton("Thoát");
		jButton_thoat.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\Logout.png"));
		jButton_thoat.addActionListener(actionListener);
		jButton_thoat.setForeground(Color.RED);
		jButton_thoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		jButton_thoat.setBounds(10, 10, 103, 44);
		contentPane.add(jButton_thoat);
		
		lblNewLabel = new JLabel("Quản Lý Trường học");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(281, 11, 308, 38);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 60, 866, 2);
		contentPane.add(separator);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 80, 846, 528);
		contentPane.add(tabbedPane);
		
		Font font = new Font("Arial", Font.BOLD, 12);
		
		panel_admins = new JPanel();
		tabbedPane.addTab("Admins", null, panel_admins, null);
		panel_admins.setLayout(null);
		
		menuBar_1 = new JMenuBar();
		menuBar_1.setBackground(Color.CYAN);
		menuBar_1.setBounds(0, 0, 841, 49);
		panel_admins.add(menuBar_1);
		
		jMenu_1 = new JMenu("Hệ thống");
		jMenu_1.setBackground(Color.CYAN);
		jMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		jMenu_1.setForeground(Color.RED);
		menuBar_1.add(jMenu_1);
		
		jMenuItem_heThong = new JMenuItem("Đăng xuất");
		jMenuItem_heThong.setForeground(Color.BLUE);
		jMenuItem_heThong.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\left-icon.png"));
		jMenuItem_heThong.addActionListener(actionListener);
		jMenu_1.add(jMenuItem_heThong);
		jMenu_1.addSeparator();
		
		jMenuItem_doiMatKhau = new JMenuItem("Đổi mật khẩu");
		jMenuItem_doiMatKhau.setForeground(Color.BLUE);
		jMenuItem_doiMatKhau.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\update-icon.png"));
		jMenuItem_doiMatKhau.addActionListener(actionListener);
		jMenu_1.add(jMenuItem_doiMatKhau);
		
		jMenu_2 = new JMenu("Quản lý");
		jMenu_2.setBackground(Color.CYAN);
		jMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		jMenu_2.setForeground(Color.RED);
		menuBar_1.add(jMenu_2);
		
		jMenuItem_nguoiHoc = new JMenuItem("Người học");
		jMenuItem_nguoiHoc.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\10206-man-student-icon.png"));
		jMenuItem_nguoiHoc.addActionListener(actionListener);
		jMenuItem_nguoiHoc.setForeground(Color.BLUE);
		jMenu_2.add(jMenuItem_nguoiHoc);
		jMenu_2.addSeparator();
				
		jMenuItem_khoaHoc = new JMenuItem("Khóa học");
		jMenuItem_khoaHoc.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\Courses.png"));
		jMenuItem_khoaHoc.addActionListener(actionListener);
		jMenuItem_khoaHoc.setForeground(Color.BLUE);
		jMenu_2.add(jMenuItem_khoaHoc);
		jMenu_2.addSeparator();
		
		jMenuItem_lopHoc = new JMenuItem("Lớp Học");
		jMenuItem_lopHoc.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\training.png"));
		jMenuItem_lopHoc.addActionListener(actionListener);
		jMenuItem_lopHoc.setForeground(Color.BLUE);
		jMenu_2.add(jMenuItem_lopHoc);
		jMenu_2.addSeparator();
		
		jMenuItem_giangVien = new JMenuItem("Quản lý giảng viên");
		jMenuItem_giangVien.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\10218-man-teacher-icon.png"));
		jMenuItem_giangVien.addActionListener(actionListener);		
		jMenuItem_giangVien.setForeground(Color.BLUE);
		jMenu_2.add(jMenuItem_giangVien);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\logoVNU.png"));
		lblNewLabel_2.setBounds(0, 50, 841, 450);
		panel_admins.add(lblNewLabel_2);
		
		tabbedPane.setFont(font);
	
		initTime();
		th.start();
		
		jLabel_time = new JLabel("");
		jLabel_time.setForeground(new Color(0, 128, 128));
		jLabel_time.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_time.setFont(new Font("Tahoma", Font.BOLD, 16));
		jLabel_time.setBounds(733, 10, 123, 32);
		contentPane.add(jLabel_time);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\clock-icon.png"));
		lblNewLabel_3.setBounds(705, 10, 49, 38);
		contentPane.add(lblNewLabel_3);
		
		this.setVisible(true);	
		
	}

////////---Đồng hồ
	public void initTime() {		
		th = new Thread() {
		@Override
		public void run() {
			while(true) {
				
				Calendar ca = new GregorianCalendar();				
				int hour = ca.get(Calendar.HOUR);
				int minute = ca.get(Calendar.MINUTE);
				int second = ca.get(Calendar.SECOND	);
				int PM_AM = ca.get(Calendar.AM_PM);
				
				String day;			
				if(PM_AM == 1) {
					day = "PM";					
				}else {
					day = "AM";
				}
				
				String time = hour +":"+ minute +":"+ second +" "+ day;
				jLabel_time.setText(time);
			}
		}
	};
	
	}		
	
////////---Cảnh báo		
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
			new PhanCapView();
			this.dispose();
		}
	}
	
	public void dangXuat() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn đăng xuất?",
			    "Đăng xuất",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			this.dispose();
			new LogInView();
		}
	}
	
	public SinhVienModel model;
	private JPanel contentPane;
	public ButtonGroup btn_gioiTinh;
	private JButton jButton_thoat;
	private JMenuBar menuBar_1;
	private JMenu jMenu_1;
	private JMenu jMenu_2;
	private JMenuItem jMenuItem_heThong;
	private JMenuItem jMenuItem_nguoiHoc;
	private JMenuItem jMenuItem_khoaHoc;
	private JMenuItem jMenuItem_giangVien;
	private JMenuItem jMenuItem_doiMatKhau;
	private JLabel jLabel_time;
	private JLabel lblNewLabel;
	private JPanel panel_admins;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTabbedPane tabbedPane;
	private JMenuItem jMenuItem_lopHoc;
}