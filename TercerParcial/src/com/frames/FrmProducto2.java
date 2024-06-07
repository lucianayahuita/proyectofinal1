package com.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class FrmProducto2 extends JFrame {

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
					FrmProducto2 frame = new FrmProducto2();
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
	public FrmProducto2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Producto");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Poppins", Font.BOLD, 24));
		lblTitulo.setBounds(296, 42, 112, 23);
		contentPane.add(lblTitulo);
		
		table = new JTable();
		table.setFont(new Font("Poppins", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Producto", null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.setBounds(160, 103, 379, 71);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnNewButton.setBounds(160, 238, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnNewButton_1.setBounds(296, 238, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modificar");
		btnNewButton_2.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnNewButton_2.setBounds(428, 238, 111, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\NAHIR\\Universidaad\\Tercer Semestre\\Programación\\eclipse uwu\\TercerParcial\\src\\com\\imagenes\\pexels-matvalina-20184915.jpg"));
		lblNewLabel.setBounds(0, 0, 744, 401);
		contentPane.add(lblNewLabel);
	}
}