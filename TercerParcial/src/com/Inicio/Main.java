package com.Inicio;
import java.sql.SQLException;

import com.frames.FrmInicio;

public class Main {
	public static void main (String...args) {
		try {
            FrmInicio frm = new FrmInicio();
            frm.setVisible(true);
        } catch (SQLException ex) {
            System.err.println("Error al iniciar la aplicación: " + ex.getMessage());
            ex.printStackTrace();
        }
	}
}
