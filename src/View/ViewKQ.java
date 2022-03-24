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

import Controller.CTLdiem;

import javax.swing.JButton;
import model.ketqua;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewKQ extends JFrame {

	private JPanel contentPane;
	private JTextField txtMASV;
	private JTextField txtMAMH;
	private JTextField txtDIEM;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewKQ frame = new ViewKQ();
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
	public ViewKQ() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1087, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0110i\u1EC3m");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(507, 10, 110, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 Sinh Vi\u00EAn");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 60, 144, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("M\u00E3 M\u00F4n H\u1ECDc");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 120, 144, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u0110i\u1EC3m Thi");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(10, 180, 144, 30);
		contentPane.add(lblNewLabel_1_2);
		
		txtMASV = new JTextField();
		txtMASV.setBounds(217, 60, 381, 30);
		contentPane.add(txtMASV);
		txtMASV.setColumns(10);
		
		txtMAMH = new JTextField();
		txtMAMH.setColumns(10);
		txtMAMH.setBounds(217, 120, 381, 30);
		contentPane.add(txtMAMH);
		
		txtDIEM = new JTextField();
		txtDIEM.setColumns(10);
		txtDIEM.setBounds(217, 180, 381, 30);
		contentPane.add(txtDIEM);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 220, 1053, 217);
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
				"M\u00E3 Sinh Vi\u00EAn", "M\u00E3 M\u00F4n H\u1ECDc", " \u0110i\u1EC3m Thi"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(153);
		table.getColumnModel().getColumn(1).setPreferredWidth(156);
		table.getColumnModel().getColumn(2).setPreferredWidth(134);
		scrollPane.setViewportView(table);
		showData(CTLdiem.findAll());
		
		JButton btnNewButton = new JButton("Th\u00EAm ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ketqua kq = new ketqua();
				kq.setMASV(txtMASV.getText());
				kq.setMAMH(txtMAMH.getText());
				kq.setDIEMTHI(Integer.parseInt(txtDIEM.getText()));
				CTLdiem.insert(kq);
				JOptionPane.showMessageDialog(null, "them Thanh cong ");
				showData(CTLdiem.findAll());
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setBounds(60, 476, 122, 38);
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("S\u1EEDa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ketqua kq = new ketqua();
				kq.setMASV(txtMASV.getText());
				kq.setMAMH(txtMAMH.getText());
				kq.setDIEMTHI(Integer.parseInt(txtDIEM.getText()));
				CTLdiem.update(kq);
				JOptionPane.showMessageDialog(null, "Sua Thanh cong ");
				showData(CTLdiem.findAll());
			}
		});
		btnSa.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnSa.setBounds(453, 476, 122, 38);
		contentPane.add(btnSa);
		
		JButton btnXa = new JButton("X\u00F3a");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ketqua kq = new ketqua();
				kq.setMASV(txtMASV.getText());
				kq.setMAMH(txtMAMH.getText());
				CTLdiem.delete(kq);
				JOptionPane.showMessageDialog(null, "Xoa Thanh cong ");
				showData(CTLdiem.findAll());
			}
		});
		btnXa.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnXa.setBounds(881, 476, 122, 38);
		contentPane.add(btnXa);
	}
	public void showData(List<ketqua>diemlt) {
		List<ketqua>Listketqua = new ArrayList<>();
		Listketqua = diemlt;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		Listketqua.forEach((ketqua)->{
			tableModel.addRow(new Object[] {
					ketqua.getMASV(),ketqua.getMAMH(),ketqua.getDIEMTHI()
			});
		});
		
	}
	
}
