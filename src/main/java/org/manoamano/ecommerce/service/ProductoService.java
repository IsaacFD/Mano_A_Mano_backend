package org.manoamano.ecommerce.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.manoamano.ecommerce.model.Producto;
import org.manoamano.ecommerce.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

	private final ProductosRepository productosRepository;

	@Autowired
	public ProductoService(ProductosRepository productosRepository) {
		this.productosRepository = productosRepository;
	}// Constructor

	public List<Producto> getProductos() {
		return productosRepository.findAll();
	}// getProductos

	public Producto getProducto(Long id) {
		return productosRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("El producto con el id [" + id + "] no existe."));
	}// getProducto

	public Producto deleteProducto(Long id) {
		Producto tmpProducto = null;

		if (productosRepository.existsById(id)) {
			tmpProducto = productosRepository.findById(id).get();
			productosRepository.deleteById(id);
		}

		return tmpProducto;
	}// deleteProducto

	public Producto addProducto(Producto producto) {
		Optional<Producto> prod = productosRepository.findByNombre(producto.getNombre());

		if (prod.isEmpty()) {
			productosRepository.save(producto);
		} else {
			producto = null;
		}

		return producto;
	}// addProducto

	public Producto updateProducto(Long id, String nombre, String descripcion, BigDecimal precio,
			Integer cantidadDisponible, String imagenUrl, String marca, BigDecimal peso, BigDecimal volumen,
			BigDecimal largo, BigDecimal ancho, BigDecimal alto, String tags, String colores, String talla,
			Boolean activo) {
		Producto tmpProducto = null;

		if (productosRepository.existsById(id)) {
			Producto prod = productosRepository.findById(id).get();

			if (nombre != null)
				prod.setNombre(nombre);
			if (descripcion != null)
				prod.setDescripcion(descripcion);
			if (precio != null)
				prod.setPrecio(precio);
			if (cantidadDisponible != null)
				prod.setCantidadDisponible(cantidadDisponible);
			if (imagenUrl != null)
				prod.setImagenUrl(imagenUrl);
			if (marca != null)
				prod.setMarca(marca);
			if (peso != null)
				prod.setPeso(peso);
			if (volumen != null)
				prod.setVolumen(volumen);
			if (largo != null)
				prod.setLargo(largo);
			if (ancho != null)
				prod.setAncho(ancho);
			if (alto != null)
				prod.setAlto(alto);
			if (tags != null)
				prod.setTags(tags);
			if (colores != null)
				prod.setColores(colores);
			if (talla != null)
				prod.setTalla(talla);
			if (activo != null)
				prod.setActivo(activo);

			tmpProducto = productosRepository.save(prod);
		}

		return tmpProducto;
	}// updateProducto

}// ProductoService