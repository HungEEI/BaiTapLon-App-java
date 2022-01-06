package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.LogInSinhVienController;
import model.UserDAO;

public class LogInSinhVien extends JFrame {

	public LogInSinhVien() {
		
		this.userDAO = new UserDAO();
		this.setSize(450, 300);
		this.setTitle("LOG IN");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CodeJava\\App\\Img\\Home.png"));
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener action = new LogInSinhVienController(this);
		
		JLabel jLabel = new JLabel("ĐĂNG NHẬP SINH VIÊN");
		jLabel.setBounds(115, 10, 249, 37);
		jLabel.setForeground(Color.BLUE);
		jLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(jLabel);
		
		JLabel jLabel_dangNhap = new JLabel("Tên đăng nhập");
		jLabel_dangNhap.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel_dangNhap.setBounds(36, 70, 101, 28);
		contentPane.add(jLabel_dangNhap);
		
		JLabel jLabel_matKhau = new JLabel("Mật khẩu");
		jLabel_matKhau.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel_matKhau.setBounds(36, 126, 70, 28);
		contentPane.add(jLabel_matKhau);
		
		jButton_dangNhap = new JButton("Đăng nhập");
		jButton_dangNhap.setBackground(Color.GREEN);
		jButton_dangNhap.setOpaque(true);
		jButton_dangNhap.addActionListener(action);
		jButton_dangNhap.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_dangNhap.setBounds(81, 194, 95, 37);
		contentPane.add(jButton_dangNhap);
		
		jButton_huy = new JButton("Hủy");
		jButton_huy.addActionListener(action);
		jButton_huy.setBackground(Color.RED);
		jButton_huy.setOpaque(true);
		jButton_huy.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_huy.setBounds(277, 194, 95, 37);
		contentPane.add(jButton_huy);
		
		textField_dangNhap2 = new JTextField();
		textField_dangNhap2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_dangNhap2.setBounds(163, 70, 184, 28);
		contentPane.add(textField_dangNhap2);
		textField_dangNhap2.setColumns(10);
		
		textField_matKhau2 = new JPasswordField();
		textField_matKhau2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_matKhau2.setBounds(163, 126, 184, 28);
		contentPane.add(textField_matKhau2);
		
		this.setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	public boolean checkForm() {		
		if(textField_dangNhap2.getText().isEmpty() || textField_matKhau2.getText().isEmpty()){
			return false;
		}		
		return true;
	}
	
	public void giaoDien() {
		if(checkForm()) {
			String name = textField_dangNhap2.getText();
			String pass = new String(textField_matKhau2.getPassword());
			UserDAO dao = new UserDAO();
			if(dao.checkLogIn2(name, pass)) {
				new ChucNangSinhVien();
				this.dispose();					
			}else {
				hienThiLoiNhap();			
			}
			
		}else {
			hienThiChuaNhap();
		}
	}
	
	public void hienThiChuaNhap() {
		JOptionPane.showMessageDialog(this, "Bạn chưa nhập");
	}
	
	public void hienThiLoiNhap() {
		JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không đúng");
	}
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton jButton_dangNhap;
	private JButton jButton_huy;
	private JTextField textField_dangNhap2;
	private JPasswordField textField_matKhau2;
	public UserDAO userDAO;
}