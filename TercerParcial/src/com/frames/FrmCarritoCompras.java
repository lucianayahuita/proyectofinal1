package com.frames;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.conexionbd.conexionbd;
import com.models.Producto;

import javax.swing.JScrollPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.frames.FrmFactura;

public class FrmCarritoCompras extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private List<Producto> carrito = new ArrayList<>();
    private JTextField txtCantidad;
	public int idProducto;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmCarritoCompras frame = new FrmCarritoCompras(-1);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void actualizarCantidadEnCarrito(int row, int cantidad) {
        Producto producto = carrito.get(row);
        if (producto != null) {
            producto.setCantidad(cantidad);
        }
    }
    public FrmCarritoCompras(int idProducto) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JLabel lblTitulo = new JLabel("Carrito de Compras");
        contentPane.add(lblTitulo, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        model = new DefaultTableModel(new Object[]{"ID Producto", "Nombre", "Cantidad", "Precio"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2; // Permite editar solo la columna de Cantidad
            }
        };
        table.setModel(model);
        model.addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 2) {
                    int row = e.getFirstRow();
                    int cantidad = (int) model.getValueAt(row, 2);
                    Producto producto = carrito.get(row);
                    double precio = producto.getnombre_bebida() != null ? producto.getprecio_bebida() : producto.getprecio_pastel();
                    model.setValueAt(precio * cantidad, row, 3);
                    // Llama al método para actualizar la cantidad en el carrito
                    actualizarCantidadEnCarrito(row, cantidad);
                }
            }
        });
        scrollPane.setViewportView(table);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JLabel lblIngrese_cantidad = new JLabel("Cantidad");
        panel.add(lblIngrese_cantidad);

        txtCantidad = new JTextField();
        panel.add(txtCantidad);
        txtCantidad.setColumns(10);

        JButton btnFinalizarCompra = new JButton("Finalizar Compra");
        btnFinalizarCompra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    finalizarCompra();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(btnFinalizarCompra);

        JButton btnCancelarCompra = new JButton("Cancelar Compra");
        btnCancelarCompra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(btnCancelarCompra);

        if (idProducto != -1) {
            try {
                agregarProductoAlCarrito(idProducto);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void agregarProductoAlCarrito(int idProducto) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = conexionbd.getInstance().getConnection();
            String consulta = "SELECT idProducto, nombre_bebida, nombre_pastel, precio_bebida, precio_pastel, cantidad_stock_bebida, cantidad_stock_pastel " +
                              "FROM productos WHERE idProducto = ?";
            pst = con.prepareStatement(consulta);
            pst.setInt(1, idProducto);
            rs = pst.executeQuery();
            if (rs.next()) {
                Producto producto = new Producto();
                producto.setid_producto(rs.getInt("idProducto"));
                producto.setnombre_bebida(rs.getString("nombre_bebida"));
                producto.setnombre_pastel(rs.getString("nombre_pastel"));
                producto.setprecio_bebida(rs.getDouble("precio_bebida"));
                producto.setprecio_pastel(rs.getDouble("precio_pastel"));
                producto.setcantidad_stock_bebida(rs.getInt("cantidad_stock_bebida"));
                producto.setcantidad_stock_pastel(rs.getInt("cantidad_stock_pastel"));
                carrito.add(producto);
                Object[] fila = {
                    producto.getid_producto(),
                    producto.getnombre_bebida() != null ? producto.getnombre_bebida() : producto.getnombre_pastel(),
                    1,
                    producto.getnombre_bebida() != null ? producto.getprecio_bebida() : producto.getprecio_pastel()
                };
                model.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al agregar el producto al carrito: " + e.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (con != null) con.close();
        }
    }
    private void finalizarCompra() throws SQLException {
        double precioTotal = 0.0;
        StringBuilder mensaje = new StringBuilder("Detalles de la compra:\n");
        for (int i = 0; i < model.getRowCount(); i++) {
            int idProducto = (int) model.getValueAt(i, 0);
            int cantidad = Integer.parseInt(txtCantidad.getText()); 
            double precioUnitario = (double) model.getValueAt(i, 3);
            double precio = cantidad * precioUnitario;
            precioTotal += precio;
            try (Connection con = conexionbd.getInstance().getConnection();
                 PreparedStatement pst = con.prepareStatement("SELECT nombre_bebida, nombre_pastel FROM productos WHERE idProducto = ?")) {
                pst.setInt(1, idProducto);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        String nombreBebida = rs.getString("nombre_bebida");
                        String nombrePastel = rs.getString("nombre_pastel");
                        mensaje.append("Producto: ").append(nombreBebida != null ? nombreBebida : nombrePastel)
                               .append(", Cantidad: ").append(cantidad)
                               .append(", Precio Total: $").append(precio).append("\n");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al realizar la consulta: " + e.getMessage());
            }
        }
        mensaje.append("Precio Total de la Compra: $").append(precioTotal);
        JOptionPane.showMessageDialog(this, mensaje.toString(), "Detalles de la Compra", JOptionPane.INFORMATION_MESSAGE);
        FrmFactura frmFactura = new FrmFactura(precioTotal, idProducto);
        frmFactura.setVisible(true);
    }
}

