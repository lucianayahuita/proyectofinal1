package com.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.conexionbd.conexionbd;
import com.models.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.ToolTipManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseEvent;

public class FrmRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdPersona;
	private JTextField txtNombres;
	private JTextField txtApPaterno;
	private JTextField txtApMaterno;
	private JTextField txtCelular;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistro frame = new FrmRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public FrmRegistro() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtContraseña = new JPasswordField();
		ToolTipManager.sharedInstance().setInitialDelay(50);
		txtContraseña.setToolTipText("La contraseña debe tener más de 8 caracteres");
		txtContraseña.setBounds(211, 274, 301, 20);
		contentPane.add(txtContraseña);
		
		JLabel lblRegistrarse = new JLabel("REGISTRARSE");
		lblRegistrarse.setBounds(273, 22, 161, 24);
		lblRegistrarse.setForeground(new Color(255, 255, 255));
		lblRegistrarse.setFont(new Font("Poppins", Font.BOLD, 24));
		contentPane.add(lblRegistrarse);
		
		JLabel lbl_idPersona = new JLabel("ID/NIT");
		lbl_idPersona.setBounds(211, 162, 126, 14);
		lbl_idPersona.setForeground(new Color(255, 255, 255));
		lbl_idPersona.setFont(new Font("Poppins", Font.BOLD, 14));
		contentPane.add(lbl_idPersona);
		
		txtIdPersona = new JTextField();
		txtIdPersona.setBounds(211, 181, 143, 20);
		txtIdPersona.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || (c== KeyEvent.VK_BACK_SPACE) || (c== KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		txtIdPersona.setFont(new Font("Poppins", Font.PLAIN, 12));
		contentPane.add(txtIdPersona);
		txtIdPersona.setColumns(10);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(211, 66, 120, 14);
		lblNombres.setForeground(new Color(255, 255, 255));
		lblNombres.setFont(new Font("Poppins", Font.BOLD, 14));
		contentPane.add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(211, 85, 301, 20);
		txtNombres.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int backspaceCount = 0;
				char c = e.getKeyChar();
				if (!(Character.isLetter(c)) || backspaceCount == 2|| c == KeyEvent.VK_DELETE) {
		            e.consume(); 
		        }

		        if (c == KeyEvent.VK_BACK_SPACE) {
		            backspaceCount++;
		        }
			}
		});
		txtNombres.setFont(new Font("Poppins", Font.PLAIN, 11));
		contentPane.add(txtNombres);
		txtNombres.setColumns(10);
		
		JLabel lblApMaterno = new JLabel("Apellido materno:");
		lblApMaterno.setBounds(376, 111, 136, 14);
		lblApMaterno.setForeground(new Color(255, 255, 255));
		lblApMaterno.setFont(new Font("Poppins", Font.BOLD, 14));
		contentPane.add(lblApMaterno);
		
		txtApPaterno = new JTextField();
		txtApPaterno.setBounds(211, 136, 143, 20);
		txtApPaterno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isLetter(c)) || (c== KeyEvent.VK_BACK_SPACE) || (c== KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		txtApPaterno.setFont(new Font("Poppins", Font.PLAIN, 12));
		contentPane.add(txtApPaterno);
		txtApPaterno.setColumns(10);
		
		JLabel lblApPaterno = new JLabel("Apellido paterno:");
		lblApPaterno.setBounds(211, 111, 126, 14);
		lblApPaterno.setForeground(new Color(255, 255, 255));
		lblApPaterno.setFont(new Font("Poppins", Font.BOLD, 14));
		contentPane.add(lblApPaterno);
		
		txtApMaterno = new JTextField();
		txtApMaterno.setBounds(376, 136, 136, 20);
		txtApMaterno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isLetter(c)) || (c== KeyEvent.VK_BACK_SPACE) || (c== KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		txtApMaterno.setFont(new Font("Poppins", Font.PLAIN, 12));
		contentPane.add(txtApMaterno);
		txtApMaterno.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(376, 162, 58, 14);
		lblCelular.setForeground(new Color(255, 255, 255));
		lblCelular.setFont(new Font("Poppins", Font.BOLD, 14));
		contentPane.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(376, 181, 136, 20);
		txtCelular.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || (c== KeyEvent.VK_BACK_SPACE) || (c== KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		txtCelular.setFont(new Font("Poppins", Font.PLAIN, 12));
		contentPane.add(txtCelular);
		txtCelular.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Nombre de usuario:");
		lblUsuario.setBounds(211, 212, 161, 14);
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Poppins", Font.BOLD, 14));
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(211, 229, 301, 20);
		txtUsuario.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtUsuario.setText("El usuario debe tener más de 8 carcateres");
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setBounds(211, 253, 104, 20);
		lblContraseña.setForeground(new Color(255, 255, 255));
		lblContraseña.setFont(new Font("Poppins", Font.BOLD, 14));
		contentPane.add(lblContraseña);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(300, 305, 131, 23);
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario u = new Usuario();
				String nombre = txtNombres.getText();
				String apPaterno = txtApPaterno.getText();
				String apMaterno = txtApMaterno.getText();
				int id = Integer.parseInt(txtIdPersona.getText());
				int celular = Integer.parseInt(txtCelular.getText());
				String user = txtUsuario.getText();
				char[] contrasenaChar = txtContraseña.getPassword();
				String contrasena = new String (contrasenaChar);
				
				u.registrarPersona(id, nombre, celular, apPaterno, apMaterno, user, contrasena);
			}
		});
		btnRegistrarse.setFont(new Font("Poppins", Font.BOLD, 14));
		contentPane.add(btnRegistrarse);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, -9, 744, 422);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\NAHIR\\Downloads\\pexels-matvalina-20184915.jpg"));
		contentPane.add(lblNewLabel);
		//cargar datos prueba
		/*cargardatosprueba();*/
		// Acción de nuevo
		cargardatos(0);
		btnRegistrarse.addActionListener(e -> {
			insertarUsuario();
		});
	}

	private void cargardatos(int idUsuario)  throws SQLException{
		List<Usuario> lista = new ArrayList<Usuario>();
		Connection con = conexionbd.getInstance().getConnection();
		String consulta = "SELECT idUsuario, nombres, ap_paterno, ap_materno, celular, nombre_usuario, contrasena_usuario " + "FROM usuario " 
				+ "WHERE idUsuario>?";
		PreparedStatement pst = con.prepareStatement(consulta);
		pst.setInt(1, idUsuario);
		ResultSet rs = pst.executeQuery();
		System.out.println(pst.toString());

		while (rs.next()) {
			Usuario u = new Usuario();
			u.setIdPersona(rs.getInt("idUsuario"));
			u.setNombre(rs.getString("nombres"));
			u.setApPaterno(rs.getString("ap_paterno"));
			u.setApMaterno(rs.getString("ap_materno"));
			u.setCelular(rs.getInt("celular"));
			u.setNombreUsuario(rs.getString("nombre_usuario"));
			u.setContrasena(rs.getString("contrasena_usuario"));
			lista.add(u);
		}
		//no agreggue el setmodel row y eso
		
		// Agregar datos al modelo
		for (Usuario usuario : lista) {
			Object[] row = { usuario.getIdPersona(), usuario.getNombre(), usuario.getApPaterno(),usuario.getApMaterno(), usuario.getCelular(), usuario.getNombreUsuario(), usuario.getContrasena() };
		}
	}

	private void insertarUsuario() {
	    List<Usuario> lista = new ArrayList<Usuario>();

	    Connection con = null;
	    PreparedStatement pst = null;
	    try {
	        con = conexionbd.getInstance().getConnection();
	        String consulta = "INSERT INTO usuario (idUsuario, nombres, ap_paterno, ap_materno, celular, nombre_usuario, contrasena_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        pst = con.prepareStatement(consulta);

	        // Obtén los valores de los campos de texto
	        String idUsuario = txtIdPersona.getText();
	        String nombres = txtNombres.getText();
	        String ap_paterno = txtApPaterno.getText();
	        String ap_materno = txtApMaterno.getText();
	        String celular = txtCelular.getText();
	        String nombre_usuario = txtUsuario.getText();
	        String contrasena_usuario = new String(txtContraseña.getPassword());

	        // Establece los parámetros en el PreparedStatement
	        pst.setString(1, idUsuario);
	        pst.setString(2, nombres);
	        pst.setString(3, ap_paterno);
	        pst.setString(4, ap_materno);
	        pst.setString(5, celular);
	        pst.setString(6, nombre_usuario);
	        pst.setString(7, contrasena_usuario);

	        int rowsAffected = pst.executeUpdate();
	        System.out.println(pst.toString());

	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(this, "Usuario insertado exitosamente.");
	            cargardatos(0); // Asegúrate de que este método esté correctamente definido
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error al insertar el usuario: " + e.getMessage());
	    } finally {
	        // Cerrar recursos
	        if (pst != null) {
	            try {
	                pst.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (con != null) {
	            try {
	                con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

}
