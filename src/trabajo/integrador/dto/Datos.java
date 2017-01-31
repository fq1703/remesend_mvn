package trabajo.integrador.dto;

import java.io.Serializable;

public class Datos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_datos; 
	private int id_usuario; 
	private String nombre; 
	private String correo; 
	private String pais; 
	private String ciudad; 
	private String direccion; 
	private String cod_post; 
	private int dni; 
	private int dnac; 
	private int mnac; 
	private int anac;
	private int telef;
	
	
	public Datos(){
		
		//Constructor
		
	}
	
	
	public int getId_datos() {
		return id_datos;
	}
	public void setId_datos(int id_datos) {
		this.id_datos = id_datos;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCod_post() {
		return cod_post;
	}
	public void setCod_post(String cod_post) {
		this.cod_post = cod_post;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getDnac() {
		return dnac;
	}
	public void setDnac(int dnac) {
		this.dnac = dnac;
	}
	public int getMnac() {
		return mnac;
	}
	public void setMnac(int mnac) {
		this.mnac = mnac;
	}
	public int getAnac() {
		return anac;
	}
	public void setAnac(int anac) {
		this.anac = anac;
	}
	public int getTelef() {
		return telef;
	}
	public void setTelef(int telef) {
		this.telef = telef;
	}
	
	
	
	
}
