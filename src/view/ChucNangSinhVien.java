package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChucNangSinhVien extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ChucNangSinhVien() {
		this.setTitle("Sinh Viên");
		setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(0, 0, 436, 263);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton jButton_xemDiem = new JButton("Xem điểm");
		jButton_xemDiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
			}
		});
		jButton_xemDiem.setBackground(Color.GREEN);
		jButton_xemDiem.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_xemDiem.setBounds(259, 95, 109, 25);
		panel.add(jButton_xemDiem);
		
		JButton jButton_DangKyHoc = new JButton("Đăng ký học");
		jButton_DangKyHoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dangKy();
			}
		});
		jButton_DangKyHoc.setBackground(Color.BLUE);
		jButton_DangKyHoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_DangKyHoc.setBounds(259, 173, 109, 25);
		panel.add(jButton_DangKyHoc);
		
		JButton jButton_thoat = new JButton("Thoát");
		jButton_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thoat();
			}
		});
		jButton_thoat.setBackground(Color.RED);
		jButton_thoat.setBounds(341, 10, 85, 25);
		panel.add(jButton_thoat);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\10207-man-student-light-skin-tone-icon.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 237, 263);
		panel.add(lblNewLabel);
		
		this.setVisible(true);
	}
	
	public void input() {
		new DangKyKhocHoc();
		this.dispose();
	}
	
	public void dangKy() {
		new DangKyHocView();
		this.dispose();
	}
	
	public void thoat() {
		this.dispose();
		new PhanCapView();
	}
}
