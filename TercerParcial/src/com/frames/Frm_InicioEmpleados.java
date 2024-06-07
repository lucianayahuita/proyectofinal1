package com.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;

public class Frm_InicioEmpleados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_InicioEmpleados frame = new Frm_InicioEmpleados();
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
	public Frm_InicioEmpleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(118, 0, 504, 401);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Cafeteria");
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 24));
		lblNewLabel_1.setBounds(198, 45, 125, 27);
		panel.add(lblNewLabel_1);
		
		JButton btnVolver = new JButton("Volver al inicio");
		btnVolver.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnVolver.setBounds(308, 296, 145, 23);
		panel.add(btnVolver);
		
		JLabel lblDirección = new JLabel("Dirección:");
		lblDirección.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblDirección.setBounds(113, 152, 71, 14);
		panel.add(lblDirección);
		
		JLabel lblCiuddad = new JLabel("Ciudad:");
		lblCiuddad.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblCiuddad.setBounds(113, 177, 71, 14);
		panel.add(lblCiuddad);
		
		JLabel lblPais = new JLabel("País:");
		lblPais.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblPais.setBounds(113, 202, 46, 14);
		panel.add(lblPais);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblId.setBounds(113, 127, 46, 14);
		panel.add(lblId);
		
		JLabel lblNewLabel_2 = new JLabel("Imprimir dato");
		lblNewLabel_2.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(198, 127, 216, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Imprimir dato");
		lblNewLabel_3.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(198, 152, 216, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Imprimir dato");
		lblNewLabel_4.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(198, 177, 216, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Imprimir dato");
		lblNewLabel_5.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(198, 202, 216, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Frm_InicioEmpleados.class.getResource("/com/imagenes/pexels-matvalina-20184915.jpg")));
		lblNewLabel.setBounds(0, 0, 744, 418);
		contentPane.add(lblNewLabel);
	}

}