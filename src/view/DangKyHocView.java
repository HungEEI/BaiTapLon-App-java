package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.DangKyController;
import model.KhoaHoc;
import model.KhoaHocModel;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DangKyHocView extends JFrame {

	public DangKyHocView() {
		setTitle("ĐĂNG KÝ");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CodeJava\\App\\Img\\Courses.png"));
		this.model = new KhoaHocModel();
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(745, 590);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener abc = new DangKyController(this);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 49, 709, 494);
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
		tabbedPane.addTab("ĐĂNG KÝ MÔN", null, panel_ketQuaHoc, null);
		panel_ketQuaHoc.setLayout(null);
		
		table_kh = new JTable();
		table_kh.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_kh.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				" MÃ HỌC PHẦN", "   TÊN MÔN HỌC", "   SỐ TÍN","  HỌC PHÍ",
			}
		));
		table_kh.setRowHeight(25);
	
		JScrollPane scrollPane = new JScrollPane(table_kh);
		scrollPane.setBounds(10, 39, 684, 154);
		panel_ketQuaHoc.add(scrollPane);
		
		jButton_open = new JButton("Khóa Học");
		jButton_open.addActionListener(abc);
		jButton_open.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_open.setForeground(Color.BLUE);
		jButton_open.setBounds(10, 0, 135, 35);
		panel_ketQuaHoc.add(jButton_open);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 102));
		panel.setBounds(10, 203, 684, 254);
		panel_ketQuaHoc.add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("Đăng ký");
		btnNewButton.setBounds(10, 22, 85, 35);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(abc);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBackground(new Color(102, 205, 170));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					" MÃ HỌC PHẦN", "   TÊN MÔN HỌC", "   SỐ TÍN","  HỌC PHÍ",
			}
		));
		table.setRowHeight(23);
		
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(118, 50, 556, 158);
		panel.add(scrollPane_1);
		
		textArea = new JTextArea();
		textArea.setBounds(118, 10, 556, 30);
		panel.add(textArea);
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		
		jButton_huy = new JButton("Hủy môn học");
		jButton_huy.addActionListener(abc);
		jButton_huy.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_huy.setBackground(Color.RED);
		jButton_huy.setBounds(538, 218, 136, 25);
		panel.add(jButton_huy);
		
		jButton_dkh = new JButton("Lưu đăng kí học");
		jButton_dkh.addActionListener(abc);
		jButton_dkh.setBackground(Color.GREEN);
		jButton_dkh.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_dkh.setBounds(118, 218, 136, 25);
		panel.add(jButton_dkh);
		
		JButton btnNewButton_1 = new JButton("Xem đăng kí học");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new DangKi();
			}
		});
		btnNewButton_1.setBackground(new Color(0, 153, 204));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(328, 222, 136, 25);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Đăng Ký Môn Học");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(252, 10, 233, 40);
		contentPane.add(lblNewLabel);
		
		this.setVisible(true);
	}
	
	public void themDiemVaoTable_KH(KhoaHoc kh) {
		DefaultTableModel model_table = (DefaultTableModel) table_kh.getModel();
		model_table.addRow(new Object[] {kh.getMaHocPhan(), kh.getMonHoc(),
										kh.getSoTin()+ "", kh.getHocPhi()+ ""});
	}
	
	public void themDiemVaoTable_KH2(KhoaHoc kh) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] {kh.getMaHocPhan(), kh.getMonHoc(),
										kh.getSoTin()+ "", kh.getHocPhi()+ ""});
	}
	
	public void thucHienTaiLaiDuLieu_KH() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table_kh.getModel();
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
		for (KhoaHoc kh : this.model.getDsKhoaHoc()) {
			this.themDiemVaoTable_KH(kh);
		}
	}
	
	public void xem() {
		String filePath = "D:\\CodeJava\\App\\KhoaHoc.csv";
        File file = new File(filePath);
        try {
        	 FileReader fr = new FileReader(file);
             try (BufferedReader br = new BufferedReader(fr)) {
				DefaultTableModel model = (DefaultTableModel) table_kh.getModel();
				 Object[] lines = br.lines().toArray();            
				 for(int i = 0; i < lines.length; i++){
				     String[] row = lines[i].toString().split(",");
				     model.addRow(row);
				 }
			}
        } catch (IOException ex) {
        	
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
			new ChucNangSinhVien();
		}
	}
	
	public KhoaHoc getKhoaHocDangChon() {
		DefaultTableModel md_tb = (DefaultTableModel) table_kh.getModel();
		int row = table_kh.getSelectedRow();
		
		String maHocPhan = md_tb.getValueAt(row, 0) + "";
		String monHoc = md_tb.getValueAt(row, 1) + "";
		int soTin = Integer.valueOf(md_tb.getValueAt(row, 2) + "");
		float hocPhi = Float.valueOf(md_tb.getValueAt(row, 3) + "");
		
		KhoaHoc kh = new KhoaHoc(maHocPhan, monHoc, soTin, hocPhi);
		
		return kh;			
	}
	
	public void hienThiThongTinKhoaHocDaChon() {
		KhoaHoc kh = getKhoaHocDangChon();
		this.textArea.setText(kh.toString());
		this.themDiemVaoTable_KH2(kh);
	}
	
	public void thucHienXoa() {
		DefaultTableModel md_tb = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy môn học này?",
													"Xóa", JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			KhoaHoc kh = getKhoaHocDangChon();
			this.model.delete(kh);
			md_tb.removeRow(i_row);
		}
	}
	
	public void luuDangKiHoc() {
		String filepath = "D:\\CodeJava\\App\\MonHocDangKi.csv";
		File file = new File(filepath);
		 try {
	          FileWriter fw = new FileWriter(file);
	          BufferedWriter bw = new BufferedWriter(fw);	            
	          for(int i = 0; i < table.getRowCount(); i++){
	              for(int j = 0; j < table.getColumnCount(); j++){
	                  bw.write(table.getValueAt(i, j).toString()+",");
	              }
	              bw.newLine();
	          }	            
	          bw.close();
	          fw.close();	            
	        } catch (IOException ex) {
	    }  
		 JOptionPane.showMessageDialog(this ,"Lưu thành công");
	}
	
	private static final long serialVersionUID = 1L;	
	private JPanel contentPane;
	public KhoaHocModel model;
	private JButton jButton_dong;
	private JButton jButton_huy;
	private JButton jButton_dkh;
	private JTable table_kh;
	private JButton jButton_open;
	private JTextArea textArea;
	private JButton btnNewButton;
	private JTable table;
}