package com.models;

import java.util.Date;

public class CarritoCompras {
	int id_carrito;
	int cantidad;
	String fecha_adicion;
	int idProducto;
	double precio;
	public int getid_carrito() {
		return id_carrito;
	}
	
	public void setid_carrito(int i) {
		id_carrito = i;
	}
	
	public int getcantidad() {
		return cantidad;
	}
	
	public void setcantidad(int i) {
		cantidad = i;
	}
	
	public String getfecha_adicion() {
		return fecha_adicion;
	}
	
	public void setfecha_adicion(String fecha_adicion) {
		this.fecha_adicion=fecha_adicion;
	}
	public int getid_producto() {
		return idProducto;
	}
	public void setid_producto(int i) {
		idProducto = i;
	}
	public Double getprecio() {
		return precio;
	}
	public void setprecio(Double s) {
		precio=s;
	}
	public void calcular_precio() {
	}
}