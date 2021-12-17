package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class PhanCapView extends JFrame {

	private JPanel contentPane;

	public PhanCapView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CodeJava\\App\\Img\\Actions-system-search-icon.png"));
		
		this.setSize(469, 300);
		this.setTitle("CHỌN VỊ TRÍ");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 255, 255));
		panel.setBounds(0, 0, 150, 263);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton jButton_admin = new JButton("ADMINS");
		jButton_admin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dong();
			}
		});
		jButton_admin.setFont(new Font("Tahoma", Font.BOLD, 14));
		jButton_admin.setVerticalAlignment(SwingConstants.TOP);
		jButton_admin.setBounds(10, 10, 130, 243);
		panel.add(jButton_admin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 150, 263);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 255, 204));
		panel_1.setBounds(150, 0, 150, 263);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton jButton_giaoVien = new JButton("GIÁO VIÊN");
		jButton_giaoVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exit();
			}
		});
		jButton_giaoVien.setFont(new Font("Tahoma", Font.BOLD, 14));
		jButton_giaoVien.setVerticalAlignment(SwingConstants.TOP);
		jButton_giaoVien.setBounds(10, 10, 130, 243);
		panel_1.add(jButton_giaoVien);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 150, 263);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 255, 153));
		panel_2.setBounds(300, 0, 150, 263);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton jButton_sinhVien = new JButton("SINH VIÊN");
		jButton_sinhVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
		});
		jButton_sinhVien.setFont(new Font("Tahoma", Font.BOLD, 14));
		jButton_sinhVien.setVerticalAlignment(SwingConstants.TOP);
		jButton_sinhVien.setBounds(10, 10, 130, 243);
		panel_2.add(jButton_sinhVien);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 150, 263);
		panel_2.add(lblNewLabel_2);
		
		this.setVisible(true);
	}
	
	public void dong() {
		this.dispose();
		new LogInView();
	}
	
	public void close() {
		this.dispose();
		new LogInSinhVien();
	}
	
	public void exit() {
		this.dispose();
		new LogInGiaoVienView();
	}
}
