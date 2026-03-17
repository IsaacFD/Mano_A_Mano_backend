package org.manoamano.ecommerce.service;

import java.math.BigDecimal;
import java.util.List;

import org.manoamano.ecommerce.model.OrdenProducto;
import org.manoamano.ecommerce.repository.OrdenProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenProductoService {

	private final OrdenProductosRepository ordenProductosRepository;

	@Autowired
	public OrdenProductoService(OrdenProductosRepository ordenProductosRepository) {
		this.ordenProductosRepository = ordenProductosRepository;
	}// Constructor

	public List<OrdenProducto> getOrdenProductos() {
		return ordenProductosRepository.findAll();
	}// getOrdenProductos

	public OrdenProducto getOrdenProducto(Long id) {
		return ordenProductosRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("El producto de la orden con el id [" + id + "] no existe."));
	}// getOrdenProducto

	public OrdenProducto deleteOrdenProducto(Long id) {
		OrdenProducto tmpOrdenProducto = null;

		if (ordenProductosRepository.existsById(id)) {
			tmpOrdenProducto = ordenProductosRepository.findById(id).get();
			ordenProductosRepository.deleteById(id);
		}

		return tmpOrdenProducto;
	}// deleteOrdenProducto

	public OrdenProducto addOrdenProducto(OrdenProducto ordenProducto) {
		return ordenProductosRepository.save(ordenProducto);
	}// addOrdenProducto

	public OrdenProducto updateOrdenProducto(Long id, Integer cantidad, BigDecimal precioUnitario,
			BigDecimal subtotal) {
		OrdenProducto tmpOrdenProducto = null;

		if (ordenProductosRepository.existsById(id)) {
			OrdenProducto ordProd = ordenProductosRepository.findById(id).get();

			if (cantidad != null)
				ordProd.setCantidad(cantidad);
			if (precioUnitario != null)
				ordProd.setPrecioUnitario(precioUnitario);
			if (subtotal != null)
				ordProd.setSubtotal(subtotal);

			tmpOrdenProducto = ordenProductosRepository.save(ordProd);
		}

		return tmpOrdenProducto;
	}// updateOrdenProducto

}// OrdenProductoService