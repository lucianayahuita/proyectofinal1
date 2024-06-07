package com.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;

public class FrmPago extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPago frame = new FrmPago();
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
	public FrmPago() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(171, 0, 404, 401);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Método de pago");
		lblTitulo.setFont(new Font("Poppins", Font.BOLD, 24));
		lblTitulo.setBounds(104, 50, 199, 30);
		panel.add(lblTitulo);
		
		JToggleButton tglbtnEfectivo = new JToggleButton("Efectivo");
		tglbtnEfectivo.setFont(new Font("Poppins", Font.PLAIN, 14));
		tglbtnEfectivo.setBounds(62, 115, 121, 23);
		panel.add(tglbtnEfectivo);
		
		JToggleButton tglbtnTarjeta = new JToggleButton("Tarjeta");
		tglbtnTarjeta.setFont(new Font("Poppins", Font.PLAIN, 14));
		tglbtnTarjeta.setBounds(224, 115, 121, 23);
		panel.add(tglbtnTarjeta);
		
		JLabel lblNewLabel_1 = new JLabel("Si elegiste efectivo");
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_1.setBounds(62, 170, 139, 14);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(206, 189, 139, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Monto del efectivo:");
		lblNewLabel_2.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(62, 192, 139, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Pin:");
		lblNewLabel_2_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(62, 248, 111, 14);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Si elegiste tarjeta");
		lblNewLabel_1_1.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(62, 226, 139, 14);
		panel.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(104, 245, 176, 14);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Finalizar");
		btnNewButton.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnNewButton.setBounds(282, 299, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\NAHIR\\Universidaad\\Tercer Semestre\\Programación\\eclipse uwu\\TercerParcial\\src\\com\\imagenes\\pexels-matvalina-20184915.jpg"));
		lblNewLabel.setBounds(0, 0, 744, 401);
		contentPane.add(lblNewLabel);
	}
}