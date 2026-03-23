package org.manoamano.ecommerce.controller;

import java.math.BigDecimal;

import java.util.List;

import org.manoamano.ecommerce.model.Producto;
import org.manoamano.ecommerce.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ecommerce/productos/")
@CrossOrigin (origins="34.201.41.216")
public class ProductoController {

	private final ProductoService productoService;

	@Autowired
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}// Constructor

	@GetMapping
	public List<Producto> getProductos() {
		return productoService.getProductos();
	}// getProductos

	@GetMapping(path = "{productoId}")
	public Producto getProducto(@PathVariable("productoId") Long id) {
		return productoService.getProducto(id);
	}// getProducto

	@DeleteMapping(path = "{productoId}")
	public Producto deleteProducto(@PathVariable("productoId") Long id) {
		return productoService.deleteProducto(id);
	}// deleteProducto

	@PostMapping
	public Producto addProducto(@RequestBody Producto producto) {
		return productoService.addProducto(producto);
	}// addProducto

	@PutMapping(path = "{productoId}")
	public Producto updateProducto(@PathVariable("productoId") Long id,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "descripcion", required = false) String descripcion,
			@RequestParam(value = "precio", required = false) BigDecimal precio,
			@RequestParam(value = "cantidadDisponible", required = false) Integer cantidadDisponible,
			@RequestParam(value = "imagenUrl", required = false) String imagenUrl,
			@RequestParam(value = "marca", required = false) String marca,
			@RequestParam(value = "peso", required = false) BigDecimal peso,
			@RequestParam(value = "volumen", required = false) BigDecimal volumen,
			@RequestParam(value = "largo", required = false) BigDecimal largo,
			@RequestParam(value = "ancho", required = false) BigDecimal ancho,
			@RequestParam(value = "alto", required = false) BigDecimal alto,
			@RequestParam(value = "tags", required = false) String tags,
			@RequestParam(value = "colores", required = false) String colores,
			@RequestParam(value = "talla", required = false) String talla,
			@RequestParam(value = "activo", required = false) Boolean activo) {

		return productoService.updateProducto(id, nombre, descripcion, precio, cantidadDisponible, imagenUrl, marca,
				peso, volumen, largo, ancho, alto, tags, colores, talla, activo);
	}// updateProducto

}// ProductoController