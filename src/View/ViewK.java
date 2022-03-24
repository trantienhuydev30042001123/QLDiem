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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.CTLkhoa;
import model.khoa;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewK extends JFrame {

	private JPanel contentPane;
	private JTextField txtMAK;
	private JTextField txtTENK;
	private JTextField txtSDT;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewK frame = new ViewK();
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
	public ViewK() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1102, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Khoa");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(498, 10, 96, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 Khoa");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 60, 116, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn Khoa");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 130, 116, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(10, 200, 116, 30);
		contentPane.add(lblNewLabel_1_2);
		
		txtMAK = new JTextField();
		txtMAK.setBounds(227, 60, 295, 30);
		contentPane.add(txtMAK);
		txtMAK.setColumns(10);
		
		txtTENK = new JTextField();
		txtTENK.setColumns(10);
		txtTENK.setBounds(227, 130, 295, 30);
		contentPane.add(txtTENK);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(227, 200, 295, 30);
		contentPane.add(txtSDT);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 240, 1068, 200);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"M\u00E3 Khoa", "T\u00EAn khoa", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(101);
		table.getColumnModel().getColumn(1).setPreferredWidth(184);
		table.getColumnModel().getColumn(2).setPreferredWidth(186);
		scrollPane.setViewportView(table);
		ShowData(CTLkhoa.findAll());
		
		JButton btnNewButton = new JButton("Th\u00EAm ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khoa k = new khoa();
				k.setMAK(txtMAK.getText());
				k.setTENK(txtTENK.getText());
				k.setSDT(txtSDT.getText());
				CTLkhoa.insert(k);
				JOptionPane.showMessageDialog(null, "Them thanh cong");
				ShowData(CTLkhoa.findAll());
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setBounds(60, 467, 150, 44);
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("S\u1EEDa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					khoa k = new khoa();
					k.setMAK(txtMAK.getText());
					k.setTENK(txtTENK.getText());
					k.setSDT(txtSDT.getText());
					CTLkhoa.update(k);
					JOptionPane.showMessageDialog(null, "Sua thanh cong");
					ShowData(CTLkhoa.findAll());
			}
		});
		btnSa.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnSa.setBounds(465, 467, 150, 44);
		contentPane.add(btnSa);
		
		JButton btnXa = new JButton("X\u00F3a");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					khoa k = new khoa();
					k.setMAK(txtMAK.getText());
					CTLkhoa.delete(k);
					JOptionPane.showMessageDialog(null, "Xoa thanh cong");
					ShowData(CTLkhoa.findAll());
				}
		});
		btnXa.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnXa.setBounds(878, 467, 150, 44);
		contentPane.add(btnXa);
	}
	public void ShowData(List<khoa>khoalt) {
		List<khoa>listkhoa = new ArrayList<>();
		listkhoa =khoalt;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		listkhoa.forEach((khoa)->{
			tableModel.addRow(new Object [] {
					khoa.getMAK(),khoa.getTENK(),khoa.getSDT()
			});
		});
	}

}
