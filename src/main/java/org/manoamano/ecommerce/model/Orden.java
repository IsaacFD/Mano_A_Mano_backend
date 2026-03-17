package org.manoamano.ecommerce.model;

import java.math.BigDecimal;
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
@Table(name = "ordenes")
public class Orden {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	@Column(name = "total", nullable = false, precision = 10, scale = 2)
	private BigDecimal total;

	@Column(name = "estado", length = 20)
	private String estado;

	@Column(name = "fecha_orden")
	private LocalDateTime fechaOrden;

	@Column(name = "fecha_actualizacion")
	private LocalDateTime fechaActualizacion;

	public Orden(Usuario usuario, BigDecimal total, String estado, LocalDateTime fechaOrden,
			LocalDateTime fechaActualizacion) {
		super();
		this.usuario = usuario;
		this.total = total;
		this.estado = estado;
		this.fechaOrden = fechaOrden;
		this.fechaActualizacion = fechaActualizacion;
	}// Orden Constructor

	public Orden() {
		this.estado = "pendiente";
		this.fechaOrden = LocalDateTime.now();
		this.fechaActualizacion = LocalDateTime.now();
	}// Orden Constructor vacío

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

	public BigDecimal getTotal() {
		return total;
	}// getTotal

	public void setTotal(BigDecimal total) {
		this.total = total;
	}// setTotal

	public String getEstado() {
		return estado;
	}// getEstado

	public void setEstado(String estado) {
		this.estado = estado;
	}// setEstado

	public LocalDateTime getFechaOrden() {
		return fechaOrden;
	}// getFechaOrden

	public void setFechaOrden(LocalDateTime fechaOrden) {
		this.fechaOrden = fechaOrden;
	}// setFechaOrden

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}// getFechaActualizacion

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}// setFechaActualizacion

	@Override
	public String toString() {
		return "Orden [id=" + id + ", usuario=" + usuario.getId() + ", total=" + total + ", estado=" + estado
				+ ", fechaOrden=" + fechaOrden + ", fechaActualizacion=" + fechaActualizacion + "]";
	}// toString

}// Orden