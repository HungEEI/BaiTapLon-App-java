package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DangKi extends JFrame {

	public DangKi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 771, 383);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("kết quả đăng ký");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(176, 10, 418, 52);
		contentPane.add(lblNewLabel);
		
		jTable = new JTable();
		jTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã HỌC PHẦN", "MÔN HỌC", "SỐ TÍN", "HỌC PHÍ"
			}
		));
		jTable.setRowHeight(25);
		
		scrollPane = new JScrollPane(jTable);
		scrollPane.setBounds(48, 75, 668, 178);
		contentPane.add(scrollPane);
		
		jButton_capNhat = new JButton("Cập nhật");
		jButton_capNhat.setFont(new Font("Tahoma", Font.BOLD, 12));
		jButton_capNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xemDKHoc();
				getSum();
			}
		});
		jButton_capNhat.setBounds(305, 314, 85, 22);
		contentPane.add(jButton_capNhat);
		
		lblNewLabel_1 = new JLabel("Số tín chỉ đăng ký:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(63, 275, 117, 22);
		contentPane.add(lblNewLabel_1);
		
		jLabel_tinChi = new JLabel("");
		jLabel_tinChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel_tinChi.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_tinChi.setBounds(176, 275, 45, 22);
		contentPane.add(jLabel_tinChi);
		
		JLabel lblNewLabel_2 = new JLabel("Số môn học đăng kí:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(272, 275, 138, 22);
		contentPane.add(lblNewLabel_2);
		
		jLabel_mh = new JLabel("");
		jLabel_mh.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel_mh.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_mh.setBounds(404, 275, 45, 22);
		contentPane.add(jLabel_mh);
		
		JLabel lblNewLabel_3 = new JLabel("Tổng học phí:\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(526, 275, 92, 22);
		contentPane.add(lblNewLabel_3);
		
		jLabel_hocPhi = new JLabel("");
		jLabel_hocPhi.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_hocPhi.setFont(new Font("Tahoma", Font.BOLD, 12));
		jLabel_hocPhi.setBounds(607, 275, 109, 22);
		contentPane.add(jLabel_hocPhi);
		
		jButton_out = new JButton("Quay lại");
		jButton_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				out();
			}
		});
		jButton_out.setBackground(Color.RED);
		jButton_out.setFont(new Font("Tahoma", Font.BOLD, 14));
		jButton_out.setBounds(10, 10, 100, 30);
		contentPane.add(jButton_out);
		
		this.setVisible(true);
	}
	
	public void xemDKHoc() {
		String filePath = "D:\\CodeJava\\App\\MonHocDangKi.csv";
        File file = new File(filePath);
        try {
        	 FileReader fr = new FileReader(file);
             try (BufferedReader br = new BufferedReader(fr)) {
				DefaultTableModel model = (DefaultTableModel) jTable.getModel();
				 Object[] lines = br.lines().toArray();            
				 for(int i = 0; i < lines.length; i++){
				     String[] row = lines[i].toString().split(",");
				     model.addRow(row);
				 }
			}
        } catch (IOException ex) {
        	
        }
	}
	
	public void getSum()
    {
        int sum = 0;
        float tong = 0;
        int dong = 0;
        for(int i = 0; i < jTable.getRowCount(); i++)
        {
            sum = sum + Integer.parseInt(jTable.getValueAt(i, 2).toString());
            tong = tong + Float.parseFloat(jTable.getValueAt(i, 3).toString());
            dong++;
        }
        
        jLabel_tinChi.setText(Integer.toString(sum));
        jLabel_hocPhi.setText(Float.toString(tong));
        jLabel_mh.setText(Integer.toString(dong));
    }
	
	public void out() {
		this.dispose();
	}
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable jTable;
	private JScrollPane scrollPane;
	private JButton jButton_capNhat;
	private JLabel lblNewLabel_1;
	private JLabel jLabel_tinChi;
	private JLabel jLabel_mh;
	private JLabel jLabel_hocPhi;
	private JButton jButton_out;
}