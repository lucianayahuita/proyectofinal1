package com.models;
public class Producto {
	int id_producto;
	String nombre_bebida;
	String nombre_pastel;
	Double precio_bebida;
	Double precio_pastel;
	int cantidad_stock_bebida;
	int cantidad_stock_pastel;
	
	//Getters y Setters
	
	public int getid_producto(){
		return id_producto;
	}
	
	public void setid_producto(int i) {
		id_producto = i;
	}
	
	public String getnombre_bebida(){
		return nombre_bebida;
	}
	
	public void setnombre_bebida(String s) {
		nombre_bebida = s;
	}
	
	public String getnombre_pastel(){
		return nombre_pastel;
	}
	
	public void setnombre_pastel(String s) {
		nombre_pastel = s;
	}
	
	public Double getprecio_bebida(){
		return precio_bebida;
	}
	
	public void setprecio_bebida(Double s) {
		precio_bebida = s;
	}
	
	public Double getprecio_pastel(){
		return precio_pastel;
	}
	
	public void setprecio_pastel(Double s) {
		precio_pastel = s;
	}
	
	public int getcantidad_stock_bebida(){
		return cantidad_stock_bebida;
	}
	
	public void setcantidad_stock_bebida(int i) {
		cantidad_stock_bebida = i;
	}
	
	public int getcantidad_stock_pastel(){
		return cantidad_stock_pastel;
	}
	
	public void setcantidad_stock_pastel(int i) {
		cantidad_stock_pastel = i;
	}

	public void setCantidad(int cantidad) {
		// TODO Auto-generated method stub
		
	}

	public int getCantidad() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
