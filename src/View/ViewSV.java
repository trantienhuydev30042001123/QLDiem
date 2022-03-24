package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.CTLsv;
import model.sinhvien;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class ViewSV extends JFrame {

	private JPanel contentPane;
	private JTextField txtMASV;
	private JTextField txtTENSV;
	private JTextField txtNGAYSINH;
	private JTextField txtQUEQUAN;
	private JTextField txtSDT;
	private JTextField txtMALOP;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSV frame = new ViewSV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewSV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1103, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sinh Vi\u00EAn");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(473, 10, 144, 47);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("M\u00E3 Sinh Vi\u00EAn");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 50, 121, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn Sinh Vi\u00EAn");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 100, 121, 25);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Gi\u1EDBi T\u00EDnh");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(10, 150, 121, 25);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Ng\u00E0y Sinh");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(10, 200, 121, 25);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Qu\u00EA Qu\u00E1n");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(603, 50, 121, 25);
		contentPane.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i");
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_5.setBounds(603, 100, 121, 25);
		contentPane.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("M\u00E3 L\u1EDBp");
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_6.setBounds(603, 150, 121, 25);
		contentPane.add(lblNewLabel_1_6);

		txtMASV = new JTextField();
		txtMASV.setBounds(173, 52, 292, 25);
		contentPane.add(txtMASV);
		txtMASV.setColumns(10);

		txtTENSV = new JTextField();
		txtTENSV.setColumns(10);
		txtTENSV.setBounds(173, 102, 292, 25);
		contentPane.add(txtTENSV);

		txtNGAYSINH = new JTextField();
		txtNGAYSINH.setColumns(10);
		txtNGAYSINH.setBounds(173, 202, 292, 25);
		contentPane.add(txtNGAYSINH);

		txtQUEQUAN = new JTextField();
		txtQUEQUAN.setColumns(10);
		txtQUEQUAN.setBounds(761, 50, 292, 25);
		contentPane.add(txtQUEQUAN);

		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(761, 100, 292, 25);
		contentPane.add(txtSDT);

		txtMALOP = new JTextField();
		txtMALOP.setColumns(10);
		txtMALOP.setBounds(761, 150, 292, 25);
		contentPane.add(txtMALOP);

		JComboBox CBGIOITINH = new JComboBox();
		CBGIOITINH.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		CBGIOITINH.setModel(new DefaultComboBoxModel(new String[] {"Nam", "N\u1EEF"}));
		CBGIOITINH.setBounds(173, 150, 292, 25);
		contentPane.add(CBGIOITINH);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 235, 1069, 199);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
				},
				new String[] {
						"M\u00E3 Sinh Vi\u00EAn", "T\u00EAn Sinh vi\u00EAn", " Gi\u1EDBi T\u00EDnh", "Ng\u00E0y Sinh", "\u0110\u1ECBa Ch\u1EC9 ", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i", "M\u00E3 L\u1EDBp "
				}
				));
		table.getColumnModel().getColumn(0).setPreferredWidth(71);
		table.getColumnModel().getColumn(1).setPreferredWidth(91);
		table.getColumnModel().getColumn(2).setPreferredWidth(58);
		table.getColumnModel().getColumn(3).setPreferredWidth(59);
		table.getColumnModel().getColumn(4).setPreferredWidth(119);
		table.getColumnModel().getColumn(6).setPreferredWidth(51);
		scrollPane.setViewportView(table);
		showData(CTLsv.findAll());

		JButton btnNewButton = new JButton("Th\u00EAm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sinhvien sv = new sinhvien();
				sv.setMASV(txtMASV.getText());
				sv.setTENSV(txtTENSV.getText());
				sv.setGIOITINH(CBGIOITINH.getSelectedIndex());
				sv.setNGAYSINH(txtNGAYSINH.getText());
				sv.setQUEQUAN(txtQUEQUAN.getText());
				sv.setSDT(txtSDT.getText());
				sv.setMALOP(txtMALOP.getText());
				CTLsv.insert(sv);
				JOptionPane.showMessageDialog(null, "them thanh cong");
				showData(CTLsv.findAll());
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBounds(30, 470, 144, 43);
		contentPane.add(btnNewButton);

		JButton btnSa = new JButton("S\u1EEDa ");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sinhvien sv = new sinhvien();
				sv.setMASV(txtMASV.getText());
				sv.setTENSV(txtTENSV.getText());
				sv.setGIOITINH(CBGIOITINH.getSelectedIndex());
				sv.setNGAYSINH(txtNGAYSINH.getText());
				sv.setQUEQUAN(txtQUEQUAN.getText());
				sv.setSDT(txtSDT.getText());
				sv.setMALOP(txtMALOP.getText());
				CTLsv.update(sv);
				JOptionPane.showMessageDialog(null, "Sua thanh cong");
				showData(CTLsv.findAll());
			}
		});
		btnSa.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnSa.setBounds(248, 470, 144, 43);
		contentPane.add(btnSa);

		JButton btnXa = new JButton("X\u00F3a");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sinhvien sv = new sinhvien();
				sv.setMASV(txtMASV.getText());
				CTLsv.delete(sv);
				JOptionPane.showMessageDialog(null, "Xoa thanh cong");
				showData(CTLsv.findAll());
			}
		});
		btnXa.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnXa.setBounds(473, 470, 144, 43);
		contentPane.add(btnXa);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMASV.setText("");
				txtTENSV.setText("");
				txtNGAYSINH.setText("");
				txtQUEQUAN.setText("");
				txtSDT.setText("");
				txtMALOP.setText("");
			}
		});
		btnRefresh.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnRefresh.setBounds(909, 470, 144, 43);
		contentPane.add(btnRefresh);
		
		JButton btnTim = new JButton("Tìm Kiếm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sinhvien sv = new sinhvien();
				sv.setMASV(txtMASV.getText());
				showData(CTLsv.findbyMASV(sv));
			}
		});
		btnTim.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnTim.setBounds(694, 470, 144, 43);
		contentPane.add(btnTim);
	} 
	public void showData(List<sinhvien>sinhvienlt) {
		List<sinhvien>listsinhvien = new ArrayList<>();
		listsinhvien = sinhvienlt;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		listsinhvien.forEach((sinhvien) -> {
			String GIOITINH;
			if(sinhvien.getGIOITINH()==0)GIOITINH="Nam";
			else {GIOITINH="Nữ";}
			tableModel.addRow(new Object [] {
					sinhvien.getMASV(),sinhvien.getTENSV(),GIOITINH,sinhvien.getNGAYSINH(),sinhvien.getQUEQUAN(),sinhvien.getSDT(),sinhvien.getMALOP()
			});
		});

	}
}
