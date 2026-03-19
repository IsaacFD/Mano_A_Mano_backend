package org.manoamano.ecommerce.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "correo", nullable = false)
	private String correo;

	@Column(name = "telefono", nullable = false)
	private String telefono;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "tipo_usuario", nullable = false)
	private String tipo_usuario;

	@Column(name = "fecha_registro", nullable = false)
	private LocalDateTime fecha_registro;

	@Column(name = "activo", nullable = false)
	private Boolean activo;

	public Usuario(Long id_usuario, String nombre, String correo, String telefono, String password, String tipo_usuario,
			LocalDateTime fecha_registro, Boolean activo) {
		super();
		this.id = id_usuario;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.password = password;
		this.tipo_usuario = tipo_usuario;
		this.fecha_registro = fecha_registro;
		this.activo = activo;
	}

	public Usuario() {
		this.tipo_usuario = "comprador";
		this.fecha_registro = LocalDateTime.now();
		this.activo = true;
	}// Constructor vacío

	public Long getId() {
		return id;
	}// getId_usuario

	public void setId(Long id_usuario) {
		this.id = id_usuario;
	}// setId_usuario

	public String getNombre() {
		return nombre;
	}// getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}// setNombre

	public String getCorreo() {
		return correo;
	}// getCorreo

	public void setCorreo(String correo) {
		this.correo = correo;
	}// setCorreo

	public String getTelefono() {
		return telefono;
	}// getTelefono

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}// setTelefono

	public String getPassword() {
		return password;
	}// getPassword

	public void setPassword(String password) {
		this.password = password;
	}// setPassword

	public String getTipo_usuario() {
		return tipo_usuario;
	}// getTipo_usuario

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}// setTipo_usuario

	public LocalDateTime getFecha_registro() {
		return fecha_registro;
	}// getFecha_registro

	public void setFecha_registro(LocalDateTime fecha_registro) {
		this.fecha_registro = fecha_registro;
	}// setFecha_registro

	public Boolean getActivo() {
		return activo;
	}// getActivo

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}// setActivo

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono
				+ ", password=" + password + ", tipo_usuario=" + tipo_usuario + ", fecha_registro=" + fecha_registro
				+ ", activo=" + activo + "]";
	}// toString

}// Usuario