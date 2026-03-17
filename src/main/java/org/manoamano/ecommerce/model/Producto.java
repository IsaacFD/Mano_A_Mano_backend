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
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "vendedor_id", nullable = false)
	private Usuario vendedor;

	@Column(name = "nombre", nullable = false, length = 70)
	private String nombre;

	@Column(name = "descripcion", length = 600)
	private String descripcion;

	@Column(name = "precio", nullable = false, precision = 10, scale = 2)
	private BigDecimal precio;

	@Column(name = "cantidad_disponible", nullable = false)
	private Integer cantidadDisponible;

	@Column(name = "imagen_url", length = 500)
	private String imagenUrl;

	@Column(name = "marca", length = 100)
	private String marca;

	@Column(name = "peso", precision = 8, scale = 2)
	private BigDecimal peso;

	@Column(name = "volumen", precision = 8, scale = 2)
	private BigDecimal volumen;

	@Column(name = "largo", precision = 8, scale = 2)
	private BigDecimal largo;

	@Column(name = "ancho", precision = 8, scale = 2)
	private BigDecimal ancho;

	@Column(name = "alto", precision = 8, scale = 2)
	private BigDecimal alto;

	@Column(name = "tags", length = 500)
	private String tags;

	@Column(name = "colores", length = 200)
	private String colores;

	@Column(name = "talla", length = 100)
	private String talla;

	@Column(name = "fecha_creacion")
	private LocalDateTime fechaCreacion;

	@Column(name = "activo")
	private Boolean activo;

	public Producto(Usuario vendedor, String nombre, String descripcion, BigDecimal precio, Integer cantidadDisponible,
			String imagenUrl, String marca, BigDecimal peso, BigDecimal volumen, BigDecimal largo, BigDecimal ancho,
			BigDecimal alto, String tags, String colores, String talla, LocalDateTime fechaCreacion, Boolean activo) {
		super();
		this.vendedor = vendedor;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadDisponible = cantidadDisponible;
		this.imagenUrl = imagenUrl;
		this.marca = marca;
		this.peso = peso;
		this.volumen = volumen;
		this.largo = largo;
		this.ancho = ancho;
		this.alto = alto;
		this.tags = tags;
		this.colores = colores;
		this.talla = talla;
		this.fechaCreacion = fechaCreacion;
		this.activo = activo;
	}// Producto Constructor

	public Producto() {
		this.fechaCreacion = LocalDateTime.now();
		this.activo = true;
	}// Producto Constructor vacío

	public Long getId() {
		return id;
	}// getId

	public void setId(Long id) {
		this.id = id;
	}// setId

	public Usuario getVendedor() {
		return vendedor;
	}// getVendedor

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}// setVendedor

	public String getNombre() {
		return nombre;
	}// getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}// setNombre

	public String getDescripcion() {
		return descripcion;
	} //getDescripcion

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}// setDescripcion

	public BigDecimal getPrecio() {
		return precio;
	}// getPrecio

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}// setPrecio

	public Integer getCantidadDisponible() {
		return cantidadDisponible;
	}// getCantidadDisponible

	public void setCantidadDisponible(Integer cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}// setCantidadDisponible

	public String getImagenUrl() {
		return imagenUrl;
	}// getImagenUrl

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}// setImagenUrl

	public String getMarca() {
		return marca;
	}// getMarca

	public void setMarca(String marca) {
		this.marca = marca;
	}// setMarca

	public BigDecimal getPeso() {
		return peso;
	}// getPeso

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}// setPeso

	public BigDecimal getVolumen() {
		return volumen;
	}// getVolumen

	public void setVolumen(BigDecimal volumen) {
		this.volumen = volumen;
	}// setVolumen

	public BigDecimal getLargo() {
		return largo;
	}// getLargo

	public void setLargo(BigDecimal largo) {
		this.largo = largo;
	}// setLargo

	public BigDecimal getAncho() {
		return ancho;
	}// getAncho

	public void setAncho(BigDecimal ancho) {
		this.ancho = ancho;
	}// setAncho

	public BigDecimal getAlto() {
		return alto;
	}// getAlto

	public void setAlto(BigDecimal alto) {
		this.alto = alto;
	}// setAlto

	public String getTags() {
		return tags;
	}// getTags

	public void setTags(String tags) {
		this.tags = tags;
	}// setTags

	public String getColores() {
		return colores;
	}// getColores

	public void setColores(String colores) {
		this.colores = colores;
	}// setColores

	public String getTalla() {
		return talla;
	}// getTalla

	public void setTalla(String talla) {
		this.talla = talla;
	}// setTalla

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}// getFechaCreacion

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}// getFechaCreacion

	public Boolean getActivo() {
		return activo;
	}// getActivo

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}// setActivo

	@Override
	public String toString() {
		return "Producto [id=" + id + ", vendedor=" + vendedor.getId() + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", precio=" + precio + ", cantidadDisponible=" + cantidadDisponible + ", imagenUrl="
				+ imagenUrl + ", marca=" + marca + ", peso=" + peso + ", volumen=" + volumen + ", largo=" + largo
				+ ", ancho=" + ancho + ", alto=" + alto + ", tags=" + tags + ", colores=" + colores + ", talla=" + talla
				+ ", fechaCreacion=" + fechaCreacion + ", activo=" + activo + "]";
	}// toString

}// Producto