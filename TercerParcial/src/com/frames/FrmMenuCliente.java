package com.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.models.Producto;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Panel;

import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.AdjustmentListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.AdjustmentEvent;
import com.models.Producto;
import com.conexionbd.conexionbd;
import javax.swing.JTextField;
public class FrmMenuCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private JTextField textField;
	/*public int idProducto;
	public double precio;
*/
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenuCliente frame = new FrmMenuCliente();
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
	public FrmMenuCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmInicio inicio = null;
				try {
					inicio = new FrmInicio();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				inicio.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNewButton.setBounds(28, 21, 64, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblTitulo = new JLabel("Menú");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Poppins", Font.BOLD, 24));
		lblTitulo.setBounds(331, 28, 73, 29);
		contentPane.add(lblTitulo);
		setPreferredSize(getPreferredSize());
		
		JPanel panelPostres = new JPanel();
		panelPostres.setBounds(370, 83, 374, 1580);
		contentPane.add(panelPostres);
		panelPostres.setLayout(null);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				panel.setLocation(panelPostres.getX(), -e.getValue());
			}
		});
		scrollBar_1.setBounds(347, 36, 17, 1409);
		panelPostres.add(scrollBar_1);
		
		JLabel lblTítuloTirN = new JLabel("<html>Tiramisú de cafe");
		lblTítuloTirN.setFont(new Font("Poppins", Font.BOLD, 24));
		lblTítuloTirN.setBounds(189, 35, 132, 62);
		panelPostres.add(lblTítuloTirN);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Prueba el increible sabor de nuestro tiramisu de café, un deleite imperdible,");
		lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(189, 108, 132, 110);
		panelPostres.add(lblNewLabel_1);
		
		JButton btnCarritoPostres = new JButton("Añadir al carrito");
		btnCarritoPostres.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnCarritoPostres.setBounds(189, 252, 145, 23);
		btnCarritoPostres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarproducto2();
			}
		});
		panelPostres.add(btnCarritoPostres);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\NAHIR\\Pictures\\Javita\\tiramusi.jpg"));
		lblNewLabel_2.setBounds(21, 27, 158, 252);
		panelPostres.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setBounds(21, 341, 158, 252);
		panelPostres.add(lblNewLabel_2_1);
		
		JLabel lblTítuloTirN_1 = new JLabel("<html>Tiramisú de cafe");
		lblTítuloTirN_1.setFont(new Font("Poppins", Font.BOLD, 24));
		lblTítuloTirN_1.setBounds(189, 349, 132, 62);
		panelPostres.add(lblTítuloTirN_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("<html>Prueba el increible sabor de nuestro tiramisu de café, un deleite imperdible,");
		lblNewLabel_1_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(189, 422, 132, 110);
		panelPostres.add(lblNewLabel_1_1);
		
		JButton btnCarritoPostres_1 = new JButton("Añadir al carrito");
		btnCarritoPostres_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnCarritoPostres_1.setBounds(189, 566, 145, 23);
		panelPostres.add(btnCarritoPostres_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("New label");
		lblNewLabel_2_2.setBounds(21, 615, 158, 252);
		panelPostres.add(lblNewLabel_2_2);
		
		JLabel lblTítuloTirN_2 = new JLabel("<html>Tiramisú de cafe");
		lblTítuloTirN_2.setFont(new Font("Poppins", Font.BOLD, 24));
		lblTítuloTirN_2.setBounds(189, 623, 132, 62);
		panelPostres.add(lblTítuloTirN_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("<html>Prueba el increible sabor de nuestro tiramisu de café, un deleite imperdible,");
		lblNewLabel_1_2.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(189, 696, 132, 110);
		panelPostres.add(lblNewLabel_1_2);
		
		JButton btnCarritoPostres_2 = new JButton("Añadir al carrito");
		btnCarritoPostres_2.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnCarritoPostres_2.setBounds(189, 840, 145, 23);
		panelPostres.add(btnCarritoPostres_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("New label");
		lblNewLabel_2_3.setBounds(21, 891, 158, 252);
		panelPostres.add(lblNewLabel_2_3);
		
		JLabel lblTítuloTirN_3 = new JLabel("<html>Tiramisú de cafe");
		lblTítuloTirN_3.setFont(new Font("Poppins", Font.BOLD, 24));
		lblTítuloTirN_3.setBounds(189, 899, 132, 62);
		panelPostres.add(lblTítuloTirN_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("<html>Prueba el increible sabor de nuestro tiramisu de café, un deleite imperdible,");
		lblNewLabel_1_3.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(189, 972, 132, 110);
		panelPostres.add(lblNewLabel_1_3);
		
		JButton btnCarritoPostres_3 = new JButton("Añadir al carrito");
		btnCarritoPostres_3.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnCarritoPostres_3.setBounds(189, 1116, 145, 23);
		panelPostres.add(btnCarritoPostres_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("New label");
		lblNewLabel_2_4.setBounds(31, 1167, 158, 252);
		panelPostres.add(lblNewLabel_2_4);
		
		JLabel lblTítuloTirN_4 = new JLabel("<html>Tiramisú de cafe");
		lblTítuloTirN_4.setFont(new Font("Poppins", Font.BOLD, 24));
		lblTítuloTirN_4.setBounds(199, 1175, 132, 62);
		panelPostres.add(lblTítuloTirN_4);
		
		JLabel lblNewLabel_1_4 = new JLabel("<html>Prueba el increible sabor de nuestro tiramisu de café, un deleite imperdible,");
		lblNewLabel_1_4.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(199, 1248, 132, 110);
		panelPostres.add(lblNewLabel_1_4);
		
		JButton btnCarritoPostres_4 = new JButton("Añadir al carrito");
		btnCarritoPostres_4.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnCarritoPostres_4.setBounds(199, 1392, 145, 23);
		panelPostres.add(btnCarritoPostres_4);
		setPreferredSize(new Dimension (371,1580));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-47, -239, 820, 458);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\NAHIR\\Downloads\\pexels-matvalina-20184915.jpg"));
		panel.setBounds(0, 83, 744, 318);
		contentPane.add(panel);
		panel.setLayout(null);
		scrollPane.setBounds(0, 0, 371, 318);
		panel.add(scrollPane);
		
		JPanel panelBebida = new JPanel();
		scrollPane.setViewportView(panelBebida);
		panelBebida.setLayout(null);
		
		JLabel lblTextoInfFR = new JLabel("<html> Disfruta una deliciosa infución con la frescura de sus ingredientes forestales. ");
		lblTextoInfFR.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblTextoInfFR.setBounds(193, 104, 148, 118);
		panelBebida.add(lblTextoInfFR);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\NAHIR\\Pictures\\Javita\\terojo.jpg"));
		lblNewLabel_3.setBounds(21, 20, 145, 267);
		panelBebida.add(lblNewLabel_3);
		
		JLabel lblTítuloFR = new JLabel("<html>Té de frutos fojos");
		lblTítuloFR.setFont(new Font("Poppins", Font.BOLD, 24));
		lblTítuloFR.setBounds(193, 20, 145, 87);
		panelBebida.add(lblTítuloFR);
		
		JButton btnCarritoBebidas = new JButton("Añadir al carrito");
		btnCarritoBebidas.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnCarritoBebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarProducto1();
			}
		});
		btnCarritoBebidas.setBounds(193, 251, 145, 23);
		panelBebida.add(btnCarritoBebidas);
		
		JButton btnCarritoBebidas_1 = new JButton("Añadir al carrito");
		btnCarritoBebidas_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnCarritoBebidas_1.setBounds(193, 569, 145, 23);
		panelBebida.add(btnCarritoBebidas_1);
		
		JButton btnCarritoBebidas_2 = new JButton("Añadir al carrito");
		btnCarritoBebidas_2.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnCarritoBebidas_2.setBounds(193, 887, 145, 23);
		panelBebida.add(btnCarritoBebidas_2);
		
		JButton btnCarritoBebidas_3 = new JButton("Añadir al carrito");
		btnCarritoBebidas_3.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnCarritoBebidas_3.setBounds(193, 1205, 145, 23);
		panelBebida.add(btnCarritoBebidas_3);
		
		JButton btnCarritoBebidas_4 = new JButton("Añadir al carrito");
		btnCarritoBebidas_4.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnCarritoBebidas_4.setBounds(193, 1523, 145, 23);
		panelBebida.add(btnCarritoBebidas_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("New label");
		lblNewLabel_3_1.setBounds(10, 338, 145, 267);
		panelBebida.add(lblNewLabel_3_1);
		
		JLabel lblTítuloFR_1 = new JLabel("<html>Té de frutos fojos");
		lblTítuloFR_1.setFont(new Font("Poppins", Font.BOLD, 24));
		lblTítuloFR_1.setBounds(182, 338, 145, 87);
		panelBebida.add(lblTítuloFR_1);
		
		JLabel lblTextoInfFR_1 = new JLabel("<html> Disfruta una deliciosa infución con la frescura de sus ingredientes forestales. ");
		lblTextoInfFR_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblTextoInfFR_1.setBounds(182, 422, 148, 118);
		panelBebida.add(lblTextoInfFR_1);
		
		JLabel lblTextId = new JLabel("Ingrese el id del producto");
		lblTextId.setBounds(122, 58, 141, 14);
		contentPane.add(lblTextId);
		
		textField = new JTextField();
		textField.setBounds(414, 55, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		try {
			cargarProducto1();
			cargarProducto2();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void cargarProducto2() {
	    List<Producto> lista1 = new ArrayList<Producto>();
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    try {
	        con = conexionbd.getInstance().getConnection();
	        String consulta1 = "SELECT idProducto, nombre_pastel, precio_pastel FROM productos";
	        ps = con.prepareStatement(consulta1);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            Producto pr = new Producto();
	            pr.setid_producto(rs.getInt("idProducto"));
	            pr.setnombre_pastel(rs.getString("nombre_pastel"));
	            pr.setprecio_pastel(rs.getDouble("precio_pastel"));
	            lista1.add(pr);
	        }
	        for (Producto product : lista1) {
	            System.out.println("Producto ID: " + product.getid_producto() + ", Nombre Pastel: " + product.getnombre_pastel() + ", Precio Pastel: " +product.getprecio_pastel());
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error al cargar los productos: " + e.getMessage());
	    } finally {
	        // Cerrar recursos
	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (ps != null) {
	            try {
	                ps.close();
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

	private void insertarproducto2() {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = conexionbd.getInstance().getConnection();
			String consulta1 = "INSERT INTO productos (idProducto, nombre_pastel, precio_pastel) VALUES (?, ?, ?)";
			pst = con.prepareStatement(consulta1);
			int idProducto = Integer.parseInt(textField.getText());
			String nombre_pastel = "tiramisu de cafe";
			double precio_pastel = 12.0;
			// Establece los parámetros en el PreparedStatement
			pst.setInt(1, idProducto);
			pst.setString(2, nombre_pastel);
			pst.setDouble(3, precio_pastel);
			int rowsAffected = pst.executeUpdate();
			System.out.println(pst.toString());
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(this, "Pastel insertado exitosamente.");
				cargarProducto1();
				FrmCarritoCompras carritoCompras = new FrmCarritoCompras(idProducto);
				carritoCompras.idProducto=idProducto;
	            carritoCompras.setVisible(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error al insertar el producto: " + e.getMessage());
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
	private void insertarProducto1() {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = conexionbd.getInstance().getConnection();
			String consulta = "INSERT INTO productos (idProducto, nombre_bebida, precio_bebida) VALUES (?, ?, ?)";
			pst = con.prepareStatement(consulta);
			int idProducto = Integer.parseInt(textField.getText());
			String nombre_bebida = "té de frutos rojos";
			double precio_bebida = 14.0;
			// Establece los parámetros en el PreparedStatement
			pst.setInt(1, idProducto);
			pst.setString(2, nombre_bebida);
			pst.setDouble(3, precio_bebida);
			int rowsAffected = pst.executeUpdate();
			System.out.println(pst.toString());
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(this, "Bebida insertado exitosamente.");
				cargarProducto1();
				FrmCarritoCompras carritoCompras = new FrmCarritoCompras(idProducto);
				carritoCompras.idProducto=idProducto;
	            carritoCompras.setVisible(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error al insertar el producto: " + e.getMessage());
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
	private void cargarProducto1() throws SQLException {
		List<Producto> lista = new ArrayList<Producto>();
		Connection con = conexionbd.getInstance().getConnection();
		String consulta = "SELECT idProducto, nombre_bebida, precio_bebida FROM productos";
		PreparedStatement pst = con.prepareStatement(consulta);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Producto p = new Producto();
			p.setid_producto(rs.getInt("idProducto"));
			p.setnombre_bebida(rs.getString("nombre_bebida"));
			p.setprecio_bebida(rs.getDouble("precio_bebida"));
			lista.add(p);
		}
		for (Producto producto : lista) {
			System.out.println("Producto ID: " + producto.getid_producto() + ", Nombre Bebida: " + producto.getnombre_bebida() + "Precio Bebida" + producto.getprecio_bebida());
		}
}
	}