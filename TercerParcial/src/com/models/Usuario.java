package com.models;

public class Usuario {
	private int id_persona;
	private String nombre;
	private int celular;
	private String ap_paterno;
	private String ap_materno;
	private String nombre_usuario;
	private String contrasena;
	
	public Usuario() {
		
	}
	
	// Getters y Setters
	
	public int getIdPersona(){
		return id_persona;
	}
	
	public void setIdPersona(int id_persona) {
		this.id_persona = id_persona;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCelular(){
		return celular;
	}
	
	public void setCelular(int celular) {
		this.celular = celular;
	}
	
	public String getApPaterno(){
		return ap_paterno;
	}
	
	public void setApPaterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}
	
	public String getApMaterno(){
		return ap_materno;
	}
	
	public void setApMaterno(String ap_materno) {
		this.ap_materno = ap_materno;
	}
	
	public String getNombreUsuario(){
		return nombre_usuario;
	}
	
	public void setNombreUsuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	
	public String getContrasena(){
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	// Métodos
	
	public void registrarPersona(int id, String nombre, int celular, String ap_paterno, String ap_materno, String nombre_usuario, String contrasena) {
		this.id_persona = id;
		this.nombre = nombre;
		this.celular = celular;
		this.ap_paterno = ap_paterno;
		this.ap_materno = ap_materno;
		this.nombre_usuario = nombre_usuario;
		this.contrasena = contrasena;
	}

	public void registrarPersona(int id, String nombre2, int celular2, String apPaterno, String apMaterno, String user,
			String contrasena2, String tipoUsuario) {
	}
	public void verificarusuario(String nombre_usuario, String contrasena) {
		this.nombre_usuario = nombre_usuario;
		this.contrasena = contrasena;
	}
}