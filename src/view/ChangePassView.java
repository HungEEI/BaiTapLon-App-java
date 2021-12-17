package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public JTextField textField_tenDangNhap;
	public JTextField textField_xacNhan;
	public JTextField textField_matKhauMoi;
	public JTextField textField_matKhauHienTai;
	
	public ChangePassView() {
		
		setSize(450, 300);
		setTitle("ĐỔI MẬT KHẨU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đổi mật khẩu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 142, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(32, 51, 120, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mật khẩu hiện tại");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(32, 141, 120, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mật khẩu mới");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(250, 51, 125, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Xác nhận mật khẩu mới");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(250, 144, 142, 22);
		contentPane.add(lblNewLabel_4);
		
		textField_tenDangNhap = new JTextField();
		textField_tenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_tenDangNhap.setBounds(32, 85, 163, 25);
		contentPane.add(textField_tenDangNhap);
		textField_tenDangNhap.setColumns(10);
		
		textField_xacNhan = new JTextField();
		textField_xacNhan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_xacNhan.setBounds(247, 173, 163, 25);
		contentPane.add(textField_xacNhan);
		textField_xacNhan.setColumns(10);
		
		textField_matKhauMoi = new JTextField();
		textField_matKhauMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_matKhauMoi.setBounds(247, 85, 163, 25);
		contentPane.add(textField_matKhauMoi);
		textField_matKhauMoi.setColumns(10);
		
		textField_matKhauHienTai = new JTextField();
		textField_matKhauHienTai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_matKhauHienTai.setBounds(32, 173, 163, 26);
		contentPane.add(textField_matKhauHienTai);
		textField_matKhauHienTai.setColumns(10);
		
		JButton jButton_dongY = new JButton("Đồng ý");
		jButton_dongY.setBackground(Color.GREEN);
		jButton_dongY.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_dongY.setBounds(209, 221, 85, 32);
		contentPane.add(jButton_dongY);
		
		JButton jButton_huyBo = new JButton("Hủy bỏ");
		jButton_huyBo.setBackground(Color.RED);
		jButton_huyBo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassView.this.dispose();
			}
		});
		jButton_huyBo.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_huyBo.setBounds(325, 221, 85, 32);
		contentPane.add(jButton_huyBo);
		
		this.setVisible(true);
	}			
}