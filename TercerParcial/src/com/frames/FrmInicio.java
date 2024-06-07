package com.frames;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.conexionbd.conexionbd;
import com.frames.*;
import com.models.Usuario;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class FrmInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmInicio frame = new FrmInicio();
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
	public FrmInicio() throws SQLException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInicioSesion = new JLabel("Iniciar sesión:");
		lblInicioSesion.setForeground(new Color(255, 255, 255));
		lblInicioSesion.setFont(new Font("Poppins", Font.BOLD, 22));
		lblInicioSesion.setBounds(293, 91, 180, 20);
		contentPane.add(lblInicioSesion);
		
		textUser = new JTextField();
		textUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				//if(!(Character.isLetter(c)) || (c== KeyEvent.VK_BACK_SPACE) || (c== KeyEvent.VK_DELETE)) {
					//e.consume();
				//}
			}
		});
		textUser.setBounds(235, 166, 262, 20);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		JLabel lblUser = new JLabel("Nombre de usuario:");
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setFont(new Font("Poppins", Font.BOLD, 14));
		lblUser.setBounds(235, 141, 160, 14);
		contentPane.add(lblUser);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setForeground(new Color(255, 255, 255));
		lblContraseña.setFont(new Font("Poppins", Font.BOLD, 14));
		lblContraseña.setBounds(235, 191, 111, 20);
		contentPane.add(lblContraseña);
		
		textContraseña = new JTextField();
		textContraseña.setBounds(235, 214, 262, 20);
		contentPane.add(textContraseña);
		textContraseña.setColumns(10);
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificarusuario(" ", " ");
			}
			//verificar usuarioooooooo
			private void verificarusuario(String nombre_usuario, String contrasena_usuario) {
				Connection con = conexionbd.getInstance().getConnection();
				String usuariocorrecto=textUser.getText();
				String contracorrecta=textContraseña.getText();
				try {
					PreparedStatement pst =con.prepareStatement("SELECT nombre_usuario, contrasena_usuario FROM usuario"
							+ " WHERE nombre_usuario=? AND contrasena_usuario=?");
					pst.setString(1,usuariocorrecto);
					pst.setString(2,contracorrecta);
					System.out.println(pst.toString());
					ResultSet rs=pst.executeQuery();
					if(rs.next()) {
						usuariocorrecto=rs.getString(1);
						contracorrecta=rs.getString(2);
					}
					if(textUser.getText().equals(usuariocorrecto) && textContraseña.getText().equals(contracorrecta)) {
						JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso, bienvenidx");
						FrmMenuCliente frmmenu = new FrmMenuCliente();
				        frmmenu.setVisible(true);
					}else{
						JOptionPane.showMessageDialog(null, "Usuario o contrasena incorrectos");
					}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "ERROR"+e);
				}
			}
		});
		btnAcceder.setFont(new Font("Poppins", Font.BOLD, 14));
		btnAcceder.setBounds(316, 267, 111, 23);
		contentPane.add(btnAcceder);
		
		JButton btnNuevaCuenta = new JButton("¿No tienes una cuenta?");
		btnNuevaCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmRegistro registrarse = null;
				try {
					registrarse = new FrmRegistro();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				registrarse.setVisible(true);
			}
		});
		btnNuevaCuenta.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNuevaCuenta.setBounds(263, 301, 220, 23);
		contentPane.add(btnNuevaCuenta);
		
		JLabel lblBienvenida = new JLabel("<html> Bienvenidx a Emociones líquidas!");
		lblBienvenida.setBounds(159, 33, 447, 37);
		contentPane.add(lblBienvenida);
		lblBienvenida.setBackground(new Color(139, 69, 19));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setForeground(new Color(255, 255, 255));
		lblBienvenida.setFont(new Font("Poppins", Font.BOLD, 24));
		
		JLabel lblFondo = new JLabel("New label");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\NAHIR\\Downloads\\pexels-matvalina-20184915.jpg"));
		lblFondo.setBounds(0, 0, 748, 405);
		contentPane.add(lblFondo);
	}
	}
