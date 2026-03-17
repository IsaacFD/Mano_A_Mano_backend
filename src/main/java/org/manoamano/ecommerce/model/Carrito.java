package org.manoamano.ecommerce.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrito")
public class Carrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "producto_id", nullable = false)
	private Producto producto;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	@Column(name = "fecha_agregado")
	private LocalDateTime fechaAgregado;

	public Carrito(Usuario usuario, Producto producto, Integer cantidad, LocalDateTime fechaAgregado) {
		super();
		this.usuario = usuario;
		this.producto = producto;
		this.cantidad = cantidad;
		this.fechaAgregado = fechaAgregado;
	}// Carrito - constructor

	public Carrito() {
		this.fechaAgregado = LocalDateTime.now();
	}// Carrito - Constructor vacío

	// Getters and Setters
	public Long getId() {
		return id;
	}// getId

	public void setId(Long id) {
		this.id = id;
	}// setId

	public Usuario getUsuario() {
		return usuario;
	}// getUsuario

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}// setUsuario

	public Producto getProducto() {
		return producto;
	}// getProducto

	public void setProducto(Producto producto) {
		this.producto = producto;
	}// setProducto

	public Integer getCantidad() {
		return cantidad;
	}// getCantidad

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}// setCantidad

	public LocalDateTime getFechaAgregado() {
		return fechaAgregado;
	}// getFechaAgregado

	public void setFechaAgregado(LocalDateTime fechaAgregado) {
		this.fechaAgregado = fechaAgregado;
	}// setFechaAgregado

	@Override
	public String toString() {
		return "Carrito [id=" + id + ", usuario=" + usuario.getId() + ", producto=" + producto.getId() + ", cantidad="
				+ cantidad + ", fechaAgregado=" + fechaAgregado + "]";
	}// toString

}// Carrito