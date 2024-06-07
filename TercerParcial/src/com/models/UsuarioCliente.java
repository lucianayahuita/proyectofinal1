package com.models;

public class UsuarioCliente extends Usuario{
	int id_cliente;
	int nit;
	
	public UsuarioCliente() {
	}
	
	public int getid_cliente(){
		return id_cliente;
	}
	
	public void setid_cliente(int i) {
		id_cliente = i;
	}
	
	public int getnit(){
		return nit;
	}
	
	public void setnit(int i) {
		nit= i;
	}
	
	public void verificar_cliente () {
		
	}
}
