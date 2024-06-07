package com.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.conexionbd.conexionbd;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class FrmFactura extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreFactura;
	private JTextField txtNIT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFactura frame = new FrmFactura(0.0, -1);
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
	public FrmFactura(double precioTotal, int idProducto) {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 760, 440);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);

	    JLabel lblFactura = new JLabel("Factura");
	    lblFactura.setFont(new Font("Poppins", Font.BOLD, 24));
	    lblFactura.setBounds(309, 34, 109, 29);
	    contentPane.add(lblFactura);

	    JLabel lblNombre = new JLabel("Nombre: ");
	    lblNombre.setFont(new Font("Poppins", Font.PLAIN, 14));
	    lblNombre.setBounds(184, 93, 94, 22);
	    contentPane.add(lblNombre);

	    JLabel lblFechaEmision = new JLabel("Fecha de emisión:");
	    lblFechaEmision.setFont(new Font("Poppins", Font.PLAIN, 14));
	    lblFechaEmision.setBounds(184, 136, 133, 14);
	    contentPane.add(lblFechaEmision);

	    JLabel lblFechaLimite = new JLabel("Fecha limite:");
	    lblFechaLimite.setFont(new Font("Poppins", Font.PLAIN, 14));
	    lblFechaLimite.setBounds(184, 175, 100, 14);
	    contentPane.add(lblFechaLimite);

	    JLabel lbl_NIT = new JLabel("NIT:");
	    lbl_NIT.setFont(new Font("Poppins", Font.PLAIN, 14));
	    lbl_NIT.setBounds(184, 208, 88, 14);
	    contentPane.add(lbl_NIT);

	    JLabel lblDetalle = new JLabel("Detalle del pedido");
	    lblDetalle.setFont(new Font("Poppins", Font.BOLD, 14));
	    lblDetalle.setBounds(184, 242, 146, 14);
	    contentPane.add(lblDetalle);

	    JLabel lblTotalPagar = new JLabel("Total a pagar:");
	    lblTotalPagar.setFont(new Font("Poppins", Font.BOLD, 14));
	    lblTotalPagar.setBounds(228, 303, 109, 29);
	    contentPane.add(lblTotalPagar);

	    JLabel lblNewLabel_6 = new JLabel("New label");
	    lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\NAHIR\\Downloads\\pexels-matvalina-20184915.jpg"));
	    lblNewLabel_6.setBounds(0, 0, 154, 401);
	    contentPane.add(lblNewLabel_6);

	    JLabel lblNewLabel_6_1 = new JLabel("New label");
	    lblNewLabel_6_1.setIcon(new ImageIcon("C:\\Users\\NAHIR\\Downloads\\pexels-matvalina-20184915.jpg"));
	    lblNewLabel_6_1.setBounds(579, 0, 165, 435);
	    contentPane.add(lblNewLabel_6_1);

	    JButton btnVolver = new JButton("Volver al inicio");
	    btnVolver.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            FrmInicio inicio;
	            try {
	                inicio = new FrmInicio();
	                inicio.setVisible(true);
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	        }
	    });
	    btnVolver.setFont(new Font("Poppins", Font.PLAIN, 14));
	    btnVolver.setBounds(164, 343, 154, 23);
	    contentPane.add(btnVolver);

	    JLabel lblImprimirFechaEmision = new JLabel("Imprimir Dato");
	    lblImprimirFechaEmision.setBounds(309, 138, 243, 14);
	    contentPane.add(lblImprimirFechaEmision);

	    JLabel lblImprimirFechaLimite = new JLabel("Imprimir Dato");
	    lblImprimirFechaLimite.setBounds(309, 177, 233, 14);
	    contentPane.add(lblImprimirFechaLimite);

	    JLabel lblTotalPagar1 = new JLabel("Imprimir Dato");
	    lblTotalPagar1.setBounds(370, 312, 74, 14);
	    contentPane.add(lblTotalPagar1);

	    JButton btnNewButton = new JButton("Siguiente");
	    btnNewButton.setFont(new Font("Poppins", Font.BOLD, 14));
	    btnNewButton.setBounds(398, 343, 115, 23);
	    contentPane.add(btnNewButton);

	    txtNombreFactura = new JTextField();
	    txtNombreFactura.setBounds(271, 96, 223, 20);
	    contentPane.add(txtNombreFactura);
	    txtNombreFactura.setColumns(10);

	    txtNIT = new JTextField();
	    txtNIT.setBounds(271, 207, 223, 20);
	    contentPane.add(txtNIT);
	    txtNIT.setColumns(10);
	    JLabel lblNombreBebida = new JLabel("Nombre bebida:");
        lblNombreBebida.setBounds(184, 267, 94, 14);
        contentPane.add(lblNombreBebida);
        
        JLabel lblImprimirNombreB = new JLabel("New label");
        lblImprimirNombreB.setBounds(342, 267, 125, 14);
        contentPane.add(lblImprimirNombreB);
        
        JLabel lblNombrePastel = new JLabel("Nombre Pastel");
        lblNombrePastel.setBounds(184, 292, 94, 14);
        contentPane.add(lblNombrePastel);
        
        JLabel lblImprimirNombreP = new JLabel("New label");
        lblImprimirNombreP.setBounds(348, 292, 46, 14);
        contentPane.add(lblImprimirNombreP);
	    // Para obtener la fecha de emision y la fecha limite
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    String fechaEmision = "07/06/2024";
	    Calendar calendar = Calendar.getInstance();
	    try {
	        Date emisionDate = dateFormat.parse(fechaEmision);
	        calendar.setTime(emisionDate);
	        calendar.add(Calendar.DAY_OF_YEAR, 7);
	        String fechaLimite = dateFormat.format(calendar.getTime());
	        lblImprimirFechaEmision.setText(fechaEmision);
	        lblImprimirFechaLimite.setText(fechaLimite);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    // Para obtener el precio total
	    lblTotalPagar1.setText(String.valueOf(precioTotal));
	    //Para obtener el nombre de la bebida o pastel
	 // Para obtener el nombre de la bebida o pastel
	    Connection con = conexionbd.getInstance().getConnection();
	    try {
	        // Obtener el nombre de la bebida y el pastel
	        PreparedStatement pstProducto = con.prepareStatement("SELECT nombre_bebida, nombre_pastel FROM productos WHERE idProducto=?");
	        pstProducto.setInt(1, idProducto);  // Establecer el valor del parámetro
	        ResultSet rsProducto = pstProducto.executeQuery();
	        if (rsProducto.next()) {
	            String nombreBebida = rsProducto.getString("nombre_bebida");
	            String nombrePastel = rsProducto.getString("nombre_pastel");
	            lblImprimirNombreB.setText(nombreBebida);
	            lblImprimirNombreP.setText(nombrePastel);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	}
}