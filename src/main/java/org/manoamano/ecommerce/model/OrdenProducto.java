package org.manoamano.ecommerce.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orden_productos")
public class OrdenProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "orden_id", nullable = false)
	private Orden orden;

	@ManyToOne
	@JoinColumn(name = "producto_id", nullable = false)
	private Producto producto;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	@Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
	private BigDecimal precioUnitario;

	@Column(name = "subtotal", nullable = false, precision = 10, scale = 2)
	private BigDecimal subtotal;

	public OrdenProducto(Orden orden, Producto producto, Integer cantidad, BigDecimal precioUnitario,
			BigDecimal subtotal) {
		super();
		this.orden = orden;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.subtotal = subtotal;
	}// OrdenProducto Constructor

	public OrdenProducto() {
	}// OrdenProducto Constructor vacío

	public Long getId() {
		return id;
	}// getId

	public void setId(Long id) {
		this.id = id;
	}// setId

	public Orden getOrden() {
		return orden;
	}// getOrden

	public void setOrden(Orden orden) {
		this.orden = orden;
	}// setOrden

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

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}// getPrecioUnitario

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}// setPrecioUnitario

	public BigDecimal getSubtotal() {
		return subtotal;
	}// getSubtotal

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}// setSubtotal

	@Override
	public String toString() {
		return "OrdenProducto [id=" + id + ", orden=" + orden.getId() + ", producto=" + producto.getId() + ", cantidad="
				+ cantidad + ", precioUnitario=" + precioUnitario + ", subtotal=" + subtotal + "]";
	}// toString

}// OrdenProducto