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

import Controller.CTLlop;
import model.lop;
import model.sinhvien;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewLop extends JFrame {

	private JPanel contentPane;
	private JTextField txtMALOP;
	private JTextField txtTENLOP;
	private JTextField txtMAK;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLop frame = new ViewLop();
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
	public ViewLop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1036, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("L\u1EDBp");
		lblNewLabel.setBounds(477, 10, 108, 39);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 L\u1EDBp");
		lblNewLabel_1.setBounds(10, 60, 92, 27);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn L\u1EDBp");
		lblNewLabel_1_1.setBounds(10, 120, 92, 27);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("M\u00E3 Khoa");
		lblNewLabel_1_2.setBounds(10, 180, 92, 27);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1_2);
		
		txtMALOP = new JTextField();
		txtMALOP.setBounds(148, 60, 311, 27);
		contentPane.add(txtMALOP);
		txtMALOP.setColumns(10);
		
		txtTENLOP = new JTextField();
		txtTENLOP.setBounds(148, 120, 311, 27);
		txtTENLOP.setColumns(10);
		contentPane.add(txtTENLOP);
		
		txtMAK = new JTextField();
		txtMAK.setBounds(148, 180, 311, 27);
		txtMAK.setColumns(10);
		contentPane.add(txtMAK);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 217, 1002, 201);
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
				"M\u00E3 L\u1EDBp", "T\u1EBFn L\u1EDBp", "M\u00E3 Khoa"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(134);
		table.getColumnModel().getColumn(2).setPreferredWidth(121);
		scrollPane.setViewportView(table);
		showData(CTLlop.findAll());
		
		JButton btnNewButton = new JButton("Th\u00EAm ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lop l = new lop();
				l.setMALOP(txtMALOP.getText());
				l.setTENLOP(txtTENLOP.getText());
				l.setMAK(txtMAK.getText());
				CTLlop.insert(l);
				JOptionPane.showMessageDialog(null, "Them thanh cong");
				showData(CTLlop.findAll());
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBounds(60, 461, 124, 39);
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("S\u1EEDa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lop l = new lop();
				l.setMALOP(txtMALOP.getText());
				l.setTENLOP(txtTENLOP.getText());
				l.setMAK(txtMAK.getText());
				CTLlop.update(l);
				JOptionPane.showMessageDialog(null, "Sua thanh cong");
				showData(CTLlop.findAll());
			}
		});
		btnSa.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnSa.setBounds(437, 461, 124, 39);
		contentPane.add(btnSa);
		
		JButton btnXa = new JButton("X\u00F3a");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lop l = new lop();
				l.setMALOP(txtMALOP.getText());
				CTLlop.delete(l);
				JOptionPane.showMessageDialog(null, "Xoa thanh cong");
				showData(CTLlop.findAll());
			}
		});
		btnXa.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnXa.setBounds(828, 461, 124, 39);
		contentPane.add(btnXa);
	}
	public void showData(List<lop>loplt) {
		List<lop>listlop = new ArrayList<>();
		listlop = loplt;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		listlop.forEach((lop) -> {
			tableModel.addRow(new Object [] {
					lop.getMALOP(),lop.getTENLOP(),lop.getMAK()
			});
		});
	}
}
