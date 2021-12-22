package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.LopHocController;
import model.LopHoc;
import model.LopHocModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;

public class LopHocView extends JFrame {

	private static final long serialVersionUID = 1L;

	public LopHocView() {
		
		this.model = new LopHocModel();
		this.setSize(880, 617);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener actionListener = new LopHocController(this);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Lớp Học");
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 102));
		panel.setBounds(10, 64, 846, 506);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 255, 204));
		panel_1.setBounds(10, 10, 826, 134);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(34, 38, 45, 13);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên phòng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(34, 95, 73, 17);
		panel_1.add(lblNewLabel_2);
		
		comboBox = new JComboBox();
		ArrayList<LopHoc> listLopHoc = LopHoc.getDSLopHoc();
		comboBox.addItem("");
		for (LopHoc lop : listLopHoc) {
			comboBox.addItem(lop.getTen());
		}
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setBounds(140, 94, 152, 22);
		panel_1.add(comboBox);
		
		textField_id = new JTextField();
		textField_id.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_id.setBounds(140, 36, 152, 22);
		panel_1.add(textField_id);
		textField_id.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Trạng thái");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(436, 95, 76, 17);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Số lượng");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(436, 36, 76, 16);
		panel_1.add(lblNewLabel_4);
		
		rbn_tot = new JRadioButton("Tốt");
		rbn_tot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbn_tot.setBounds(545, 93, 58, 21);
		panel_1.add(rbn_tot);
		
		rbn_ban = new JRadioButton("Bận");
		rbn_ban.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbn_ban.setBounds(646, 93, 58, 21);
		panel_1.add(rbn_ban);
		
		btn_trangThai = new ButtonGroup();
		btn_trangThai.add(rbn_tot);
		btn_trangThai.add(rbn_ban);		
		
		textField_soLuong = new JTextField();
		textField_soLuong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_soLuong.setBounds(545, 36, 159, 22);
		panel_1.add(textField_soLuong);
		textField_soLuong.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.controlShadow);
		panel_2.setBounds(10, 154, 826, 292);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "TÊN PHÒNG", "SỐ LƯỢNG", "TRẠNG THÁI"
			}
		));
		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 806, 272);
		panel_2.add(scrollPane);
		
		jButton_xoa = new JButton("Xóa");
		jButton_xoa.setBounds(546, 456, 105, 35);
		panel.add(jButton_xoa);
		jButton_xoa.setBackground(Color.RED);
		jButton_xoa.setOpaque(true);
		jButton_xoa.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\exit.png"));
		jButton_xoa.addActionListener(actionListener);
		jButton_xoa.setFont(new Font("Tahoma", Font.BOLD, 12));
				
		jButton_capNhat = new JButton("Cập nhật");
		jButton_capNhat.setBounds(222, 456, 105, 35);
		panel.add(jButton_capNhat);
		jButton_capNhat.setBackground(Color.GREEN);
		jButton_capNhat.setOpaque(true);
		jButton_capNhat.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\update.png"));
		jButton_capNhat.addActionListener(actionListener);
		jButton_capNhat.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jButton_them = new JButton("Thêm");
		jButton_them.setBounds(378, 456, 105, 35);
		panel.add(jButton_them);
		jButton_them.setBackground(Color.GREEN);
		jButton_them.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\add.png"));
		jButton_them.addActionListener(actionListener);
		jButton_them.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jButton_huyBo = new JButton("Mới");
		jButton_huyBo.setBounds(60, 456, 101, 35);
		panel.add(jButton_huyBo);
		jButton_huyBo.setBackground(Color.RED);
		jButton_huyBo.setOpaque(true);
		jButton_huyBo.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\broom.png"));
		jButton_huyBo.addActionListener(actionListener);
		jButton_huyBo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jButton_save = new JButton("Save");
		jButton_save.setBounds(712, 456, 85, 35);
		panel.add(jButton_save);
		jButton_save.setBackground(Color.CYAN);
		jButton_save.setOpaque(true);
		jButton_save.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\Save.png"));
		jButton_save.addActionListener(actionListener);
		jButton_save.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		this.setVisible(true);
	}
	
	public void clear() {		
		textField_id.setText("");
		textField_soLuong.setText("");
		comboBox.setSelectedIndex(-1);
		btn_trangThai.clearSelection();		
	}
	
	public void themMonHocVaoTable(LopHoc lh) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] {lh.getId() + "", lh.getTenPhong().getTen() + "",
										lh.getSoLuong()+ "", (lh.isTrangThai() ? "Tốt" : "Bận")+ ""});
	}
	
	public void themHoacCapNhatKhoaHoc(LopHoc lh) {
		DefaultTableModel md_tb = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(lh)) {
			this.model.insert(lh); 
			this.themMonHocVaoTable(lh);
		} else {
			this.model.update(lh);
			int soDong = md_tb.getRowCount();
			for (int i = 0; i < soDong; i++) {
				String ID = md_tb.getValueAt(i, 0) + "";
				if (ID.equals(lh.getId() + "")) {
					md_tb.setValueAt(lh.getId(), i, 0);
					md_tb.setValueAt(lh.getTenPhong().getTen() + "", i, 1 );
					md_tb.setValueAt((lh.isTrangThai() ? "Tốt" : "Bận") + "", i, 3);
					md_tb.setValueAt(lh.getSoLuong() + "", i, 2);					
				}
			}
		}
	}
	
	public void thucHienThemKhoaHoc() throws ParseException{
		int id = Integer.valueOf(this.textField_id.getText());
		int lopHoc = this.comboBox.getSelectedIndex() - 1;
		LopHoc lop = LopHoc.getLopById(lopHoc);
		int soLuong = Integer.valueOf(this.textField_soLuong.getText());
		
		boolean trangThai = true;
		if (this.rbn_tot.isSelected()) {
			trangThai = true;
		} else if (this.rbn_ban.isSelected()) {
			trangThai = false;
		}
		
		LopHoc lh = new LopHoc(id, lop, soLuong, trangThai);
		this.themHoacCapNhatKhoaHoc(lh);
	}
	
	public LopHoc getKhoaHocDangChon() {
		DefaultTableModel md_tb = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		
		int id = Integer.valueOf(md_tb.getValueAt(row, 0)+ "");
		LopHoc lop = LopHoc.getLopByTen(md_tb.getValueAt(row, 1)+ "");
		int soLuong = Integer.valueOf(md_tb.getValueAt(row, 2) + "");
		String textLop = md_tb.getValueAt(row, 3) + "";
		boolean tenLop = textLop.equals("Tốt");
		
		LopHoc lh = new LopHoc(id, lop, soLuong, tenLop);
		return lh;			
	}
	
	public void hienThiThongTinKhoaHocDaChon() {
		LopHoc lh = getKhoaHocDangChon();
		this.textField_id.setText(lh.getId() + "");
		this.comboBox.setSelectedItem(lh.getTenPhong().getTen());
		this.textField_soLuong.setText(lh.getSoLuong() + "");
		if (lh.isTrangThai()) {
			rbn_tot.setSelected(true);			
		} else {
			rbn_ban.setSelected(true);			
		}
	}
	
	public void thucHienXoa() {
		DefaultTableModel md_tb = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không ?",
													"Xóa", JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			LopHoc lh = getKhoaHocDangChon();
			this.model.delete(lh);
			md_tb.removeRow(i_row);
		}
	}
	
	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (LopHoc lh : this.model.getDsLopHoc()) {
				oos.writeObject(lh);				
			}
			oos.close();
		} catch (Exception e) {
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
	
	public void hienThiSave() {
		JOptionPane.showMessageDialog(this, "Lưu thành công");
	}
	
	private JPanel contentPane;
	private JButton jButton_thoat;
	private JTextField textField_id;
	private JTextField textField_soLuong;
	private JTable table;
	private JButton jButton_save;
	private JButton jButton_huyBo;
	private JButton jButton_capNhat;
	private JButton jButton_xoa;
	private JButton jButton_them;
	public LopHocModel model;
	private JComboBox comboBox;
	private JRadioButton rbn_tot;
	private JRadioButton rbn_ban;
	private ButtonGroup btn_trangThai;
}