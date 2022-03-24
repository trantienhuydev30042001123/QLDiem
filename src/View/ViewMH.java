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

import Controller.CTLmh;
import model.monhoc;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewMH extends JFrame {

	private JPanel contentPane;
	private JTextField txtMAMH;
	private JTextField txtTENMH;
	private JTextField txtSOTINCHI;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMH frame = new ViewMH();
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
	public ViewMH() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1088, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00F4n H\u1ECDc ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(478, 10, 130, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 M\u00F4n H\u1ECDc ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 60, 130, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn M\u00F4n H\u1ECDc");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 120, 130, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("S\u1ED1 T\u00EDn Ch\u1EC9");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(10, 180, 130, 30);
		contentPane.add(lblNewLabel_1_2);
		
		txtMAMH = new JTextField();
		txtMAMH.setBounds(230, 60, 300, 30);
		contentPane.add(txtMAMH);
		txtMAMH.setColumns(10);
		
		txtTENMH = new JTextField();
		txtTENMH.setColumns(10);
		txtTENMH.setBounds(230, 120, 300, 30);
		contentPane.add(txtTENMH);
		
		txtSOTINCHI = new JTextField();
		txtSOTINCHI.setColumns(10);
		txtSOTINCHI.setBounds(230, 180, 300, 30);
		contentPane.add(txtSOTINCHI);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 232, 1054, 217);
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
				{null, null, null},
			},
			new String[] {
				"M\u00E3 M\u00F4n H\u1ECDc ", "T\u00EAn M\u00F4n H\u1ECDc", "S\u1ED1 T\u00EDn Ch\u1EC9"
			}
		));
		scrollPane.setViewportView(table);
		showData(CTLmh.findAll());
		
		JButton btnNewButton = new JButton("Th\u00EAm ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monhoc mh = new monhoc();
				mh.setMAMH(txtMAMH.getText());
				mh.setTENMH(txtTENMH.getText());
				mh.setSOTINCHI(Integer.parseInt(txtSOTINCHI.getText()));
				CTLmh.insert(mh);
				JOptionPane.showMessageDialog(null, "them thanh cong");
				showData(CTLmh.findAll());
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setBounds(55, 490, 130, 38);
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("S\u1EEDa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monhoc mh = new monhoc();
				mh.setMAMH(txtMAMH.getText());
				mh.setTENMH(txtTENMH.getText());
				mh.setSOTINCHI(Integer.parseInt(txtSOTINCHI.getText()));
				CTLmh.update(mh);
				JOptionPane.showMessageDialog(null, "Sua thanh cong");
				showData(CTLmh.findAll());
			}
		});
		btnSa.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnSa.setBounds(461, 490, 130, 38);
		contentPane.add(btnSa);
		
		JButton btnXa = new JButton("X\u00F3a");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monhoc mh = new monhoc();
				mh.setMAMH(txtMAMH.getText());
				CTLmh.delete(mh);
				JOptionPane.showMessageDialog(null, "xoa thanh cong");
				showData(CTLmh.findAll());
			}
		});
		btnXa.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnXa.setBounds(877, 490, 130, 38);
		contentPane.add(btnXa);
	}
	public void showData(List<monhoc>monhoclt) {
		List<monhoc>Listmonhoc = new ArrayList<>();
		Listmonhoc = monhoclt;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel=(DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		Listmonhoc.forEach((monhoc)->{
			tableModel.addRow(new Object[] {
					monhoc.getMAMH(),monhoc.getTENMH(),monhoc.getSOTINCHI()
			});
		});
	}
}
