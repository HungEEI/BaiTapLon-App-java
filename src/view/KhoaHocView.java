package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.KhoaHocController;
import model.KhoaHoc;
import model.KhoaHocModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;

public class KhoaHocView extends JFrame {

	private static final long serialVersionUID = 1L;

	public KhoaHocView() {
		init();
	}
	
	public void init() {
		this.model_kh = new KhoaHocModel();
		this.setSize(1148, 452);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener ac = new KhoaHocController(this);
		
		lblNewLabel = new JLabel("KHÓA HỌC");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(539, 0, 138, 41);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 48, 1124, 2);
		contentPane.add(separator);
		
		jButton_them = new JButton("Thêm");
		jButton_them.setBackground(Color.GREEN);
		jButton_them.addActionListener(ac);
		jButton_them.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_them.setBounds(444, 121, 85, 30);
		contentPane.add(jButton_them);
		
		jButton_sua = new JButton("Sửa");
		jButton_sua.addActionListener(ac);
		jButton_sua.setFont(new Font("Tahoma", Font.BOLD, 11));
		jButton_sua.setBounds(444, 161, 85, 30);
		contentPane.add(jButton_sua);
		
		jButton_xoa = new JButton("Xóa");
		jButton_xoa.setBackground(Color.RED);
		jButton_xoa.addActionListener(ac);
		jButton_xoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_xoa.setBounds(444, 201, 85, 30);
		contentPane.add(jButton_xoa);
		
		jButton_huy = new JButton("Mới");
		jButton_huy.addActionListener(ac);
		jButton_huy.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_huy.setBounds(444, 71, 85, 30);
		contentPane.add(jButton_huy);
		
		jButton_frist = new JButton("l<");
		jButton_frist.setBackground(new Color(0, 0, 204));
		jButton_frist.addActionListener(ac);
		jButton_frist.setFont(new Font("Tahoma", Font.BOLD, 13));
		jButton_frist.setBounds(96, 319, 47, 30);
		contentPane.add(jButton_frist);
		
		jButton_prev = new JButton("<<");
		jButton_prev.setBackground(new Color(51, 102, 255));
		jButton_prev.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jButton_prev.addActionListener(ac);
		jButton_prev.setBounds(156, 320, 47, 30);
		contentPane.add(jButton_prev);
		
		jButton_next = new JButton(">>");
		jButton_next.setBackground(new Color(51, 102, 255));
		jButton_next.addActionListener(ac);
		jButton_next.setBounds(228, 320, 47, 30);
		contentPane.add(jButton_next);
		
		jButton_last = new JButton(">l");
		jButton_last.setBackground(new Color(0, 0, 204));
		jButton_last.addActionListener(ac);
		jButton_last.setFont(new Font("Tahoma", Font.BOLD, 13));
		jButton_last.setBounds(287, 319, 47, 30);
		contentPane.add(jButton_last);
		
		jButton_dong = new JButton("Đóng");
		jButton_dong.setBackground(Color.CYAN);
		jButton_dong.setForeground(Color.RED);
		jButton_dong.addActionListener(ac);
		jButton_dong.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_dong.setBounds(10, 8, 85, 31);
		contentPane.add(jButton_dong);
		
		jButton_luu = new JButton("Lưu");
		jButton_luu.addActionListener(ac);
		jButton_luu.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_luu.setBounds(444, 241, 85, 30);
		contentPane.add(jButton_luu);
		
		panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(10, 71, 416, 232);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Mã học phần");
		lblNewLabel_2.setBounds(10, 10, 92, 26);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblNewLabel_1 = new JLabel("Môn học");
		lblNewLabel_1.setBounds(10, 73, 92, 24);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblNewLabel_3 = new JLabel("Số tín");
		lblNewLabel_3.setBounds(10, 132, 66, 26);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblNewLabel_4 = new JLabel("Học phí");
		lblNewLabel_4.setBounds(10, 186, 66, 24);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		textField_maHocPhan = new JTextField();
		textField_maHocPhan.setBounds(113, 11, 286, 25);
		panel.add(textField_maHocPhan);
		textField_maHocPhan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_maHocPhan.setColumns(10);
		
		textField_monHoc = new JTextField();
		textField_monHoc.setBounds(112, 73, 286, 25);
		panel.add(textField_monHoc);
		textField_monHoc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_monHoc.setColumns(10);
		
		textField_soTin = new JTextField();
		textField_soTin.setBounds(113, 133, 287, 25);
		panel.add(textField_soTin);
		textField_soTin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_soTin.setColumns(10);
		
		textField_hocPhi = new JTextField();
		textField_hocPhi.setBounds(113, 186, 286, 25);
		panel.add(textField_hocPhi);
		textField_hocPhi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_hocPhi.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 204, 153));
		panel_1.setBounds(539, 71, 580, 328);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		table_khoaHoc = new JTable();
		table_khoaHoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_khoaHoc.setModel(new DefaultTableModel(
			new Object[][] {
				{"PHY1112", "Tiếng anh B1", 5, 2500000},
				{"PHY1109", "Xác suất thống kê", 2, 600000},
				{"PHY1023", "Điện và từ", 4, 1750000},
				{"PHY2308", "THVL đại cương 1", 2, 900000},
				{"PHY1107", "Giải tích 1", 2, 1550000},
				{"PHY1106", "Giải tích 2", 2, 1550000},
				{"PHY1004", "Cơ học", 2, 1500000},
				{"PHY1204", "Nhiệt động học", 3, 200000},
				{"PHY1109", "Đại số tuyến tính", 2, 1550000},
				{"PHI1002", "CNXH và Khoa học", 2, 1400000},
				{"PHY2504", "Phương pháp số", 2, 750000},
				{"PHY1113", "Lập trình C", 2, 950000},
				{"PHY2011", "Lt hướng đối tượng", 2, 1000000},
				{"PHY1104", "THVL đại cương 2", 2, 900000},
				{"PHY1202", "Triết học", 2, 755000},
			},
			new String[] {
				"Mã học phần", "Tên môn học", "Số tín", "Học phí"
			}
		));
		table_khoaHoc.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table_khoaHoc);
		scrollPane.setBounds(17, 10, 553, 308);
		panel_1.add(scrollPane);
		
		this.setVisible(true);
	}
	
	public void clear() {		
		textField_maHocPhan.setText("");
		textField_soTin.setText("");
		textField_hocPhi.setText("");
		textField_monHoc.setText("");		
	}
	
	public void themMonHocVaoTable(KhoaHoc kh) {
		DefaultTableModel model_table = (DefaultTableModel) table_khoaHoc.getModel();
		model_table.addRow(new Object[] {kh.getMaHocPhan(), kh.getMonHoc(),
										kh.getSoTin()+ "", kh.getHocPhi()+ ""});
	}
	
	public void themHoacCapNhatKhoaHoc(KhoaHoc kh) {
		DefaultTableModel md_tb = (DefaultTableModel) table_khoaHoc.getModel();
		if (!this.model_kh.kiemTraTonTai(kh)) {
			this.model_kh.insert(kh);
			this.themMonHocVaoTable(kh);
		} else {
			this.model_kh.update(kh);
			int soDong = md_tb.getRowCount();
			for (int i = 0; i < soDong; i++) {
				String ID = md_tb.getValueAt(i, 0) + "";
				if (ID.equals(kh.getMaHocPhan())) {
					md_tb.setValueAt(kh.getMaHocPhan(), i, 0);
					md_tb.setValueAt(kh.getMonHoc(), i, 1);
					md_tb.setValueAt(kh.getSoTin() + "", i, 2);
					md_tb.setValueAt(kh.getHocPhi() + "", i, 3);					
				}
			}
		}
	}
	
	public void thucHienThemKhoaHoc() throws ParseException{
		String maHocPhan = this.textField_maHocPhan.getText();
		String monHoc = this.textField_monHoc.getText();
		int soTin = Integer.valueOf(this.textField_soTin.getText());
		float hocPhi = Float.valueOf(this.textField_hocPhi.getText());
		
		KhoaHoc kh = new KhoaHoc(maHocPhan, monHoc, soTin, hocPhi);
		this.themHoacCapNhatKhoaHoc(kh);
	}
	
	public KhoaHoc getKhoaHocDangChon() {
		DefaultTableModel md_tb = (DefaultTableModel) table_khoaHoc.getModel();
		int row = table_khoaHoc.getSelectedRow();
		
		String maHocPhan = md_tb.getValueAt(row, 0) + "";
		String monHoc = md_tb.getValueAt(row, 1) + "";
		int soTin = Integer.valueOf(md_tb.getValueAt(row, 2) + "");
		float hocPhi = Float.valueOf(md_tb.getValueAt(row, 3) + "");
		
		KhoaHoc kh = new KhoaHoc(maHocPhan, monHoc, soTin, hocPhi);
		
		return kh;			
	}
	
	public void hienThiThongTinKhoaHocDaChon() {
		KhoaHoc kh = getKhoaHocDangChon();
		this.textField_maHocPhan.setText(kh.getMaHocPhan());
		this.textField_monHoc.setText(kh.getMonHoc());
		this.textField_soTin.setText(kh.getSoTin() + "");
		this.textField_hocPhi.setText(kh.getHocPhi() + "");
	}
	
	public void thucHienXoa() {
		DefaultTableModel md_tb = (DefaultTableModel) table_khoaHoc.getModel();
		int i_row = table_khoaHoc.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không ?",
													"Xóa", JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			KhoaHoc kh = getKhoaHocDangChon();
			this.model_kh.delete(kh);
			md_tb.removeRow(i_row);
		}
	}
	
	public void saveFile(String path) {
		try {
			this.model_kh.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (KhoaHoc kh : this.model_kh.getDsKhoaHoc()) {
				oos.writeObject(kh);				
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void thucHienSaveFile() {
		if(this.model_kh.getTenFile().length()>0) {
			saveFile(this.model_kh.getTenFile());
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
	
	public void hienThiSave() {
		JOptionPane.showMessageDialog(this, "Lưu thành công");
	}
	
	public void first() {
		if(this.model_kh.getDsKhoaHoc().size() == 0) {
			JOptionPane.showMessageDialog(this, "Lỗi");
			
		}else {
			currentKhoaHoc = this.model_kh.getDsKhoaHoc().get(0);
			currentIdx = 0;
			displayKhoaHoc();
		}
		
	}
	
	public void prev() {
		if(this.model_kh.getDsKhoaHoc().size() == 0) {
			JOptionPane.showMessageDialog(this, "Lỗi");
			
	     } else if((currentIdx <= this.model_kh.getDsKhoaHoc().size() - 1) && (currentIdx > 0) ) {
	    	 currentIdx -=1;
	    	 currentKhoaHoc = this.model_kh.getDsKhoaHoc().get(currentIdx);
	    	 displayKhoaHoc();
	     }else{
	    	 currentKhoaHoc = this.model_kh.getDsKhoaHoc().get(this.model_kh.getDsKhoaHoc().size() - 1);
	    	 currentIdx = this.model_kh.getDsKhoaHoc().size()-1;
	    	 displayKhoaHoc();
	     }
	}
	
	public void next() {
		if(this.model_kh.getDsKhoaHoc().size() == 0) {
			JOptionPane.showMessageDialog(this, "Lỗi");
			
		}else if(currentIdx < this.model_kh.getDsKhoaHoc().size() - 1){
			currentIdx += 1;
			currentKhoaHoc = this.model_kh.getDsKhoaHoc().get(currentIdx);
			displayKhoaHoc();
		}else { 
			currentKhoaHoc = this.model_kh.getDsKhoaHoc().get(0);
			currentIdx = 0;
			displayKhoaHoc();
			
		}
	}
	
	public void last() {
		if(this.model_kh.getDsKhoaHoc().size() == 0) {
			JOptionPane.showMessageDialog(this, "Lỗi");
			
		}else {
			currentKhoaHoc = this.model_kh.getDsKhoaHoc().get(this.model_kh.getDsKhoaHoc().size() - 1);
			currentIdx = 0;
			displayKhoaHoc();
		}	
	}
	
	private void displayKhoaHoc() {
		this.textField_maHocPhan.setText(this.currentKhoaHoc.getMaHocPhan());
		this.textField_monHoc.setText(this.currentKhoaHoc.getMonHoc());
		this.textField_soTin.setText(this.currentKhoaHoc.getSoTin() + "");
		this.textField_hocPhi.setText(this.currentKhoaHoc.getHocPhi()+ "");
		
	}

	private KhoaHoc currentKhoaHoc;
	private int currentIdx;
	private JPanel contentPane;
	private JTable table_khoaHoc;
	public KhoaHocModel model_kh;
	private JTextField textField_maHocPhan;
	private JTextField textField_hocPhi;
	private JTextField textField_soTin;
	private JTextField textField_monHoc;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton jButton_them;
	private JButton jButton_sua;
	private JButton jButton_xoa;
	private JButton jButton_huy;
	private JButton jButton_frist;
	private JButton jButton_prev;
	private JButton jButton_next;
	private JButton jButton_last;
	private JButton jButton_dong;
	private JButton jButton_luu;
	private JPanel panel;
	private JPanel panel_1;
}