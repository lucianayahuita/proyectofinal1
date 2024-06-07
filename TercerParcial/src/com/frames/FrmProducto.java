package com.frames;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;

public class FrmProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProducto frame = new FrmProducto();
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
	public FrmProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Modificar lista de productos");
		btnNewButton.setBounds(429, 285, 166, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver al incio");
		btnVolver.setBounds(141, 285, 113, 23);
		contentPane.add(btnVolver);
		
		JLabel lblTitulo = new JLabel("Producto");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Poppins", Font.BOLD, 24));
		lblTitulo.setBounds(310, 47, 119, 37);
		contentPane.add(lblTitulo);
		
		table = new JTable();
		table.setFont(new Font("Poppins", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Id Producto", null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(109);
		table.getColumnModel().getColumn(1).setPreferredWidth(209);
		table.setBounds(145, 136, 450, 66);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\NAHIR\\Universidaad\\Tercer Semestre\\Programación\\eclipse uwu\\TercerParcial\\src\\com\\imagenes\\pexels-matvalina-20184915.jpg"));
		lblNewLabel.setBounds(0, 0, 744, 401);
		contentPane.add(lblNewLabel);
	}
}
