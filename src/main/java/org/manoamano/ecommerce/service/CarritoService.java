package org.manoamano.ecommerce.service;

import java.util.List;

import org.manoamano.ecommerce.model.Carrito;
import org.manoamano.ecommerce.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoService {

	private final CarritoRepository carritoRepository;

	@Autowired
	public CarritoService(CarritoRepository carritoRepository) {
		this.carritoRepository = carritoRepository;
	}// CarritoService Constructor

	public List<Carrito> getAllCarritoItems() {
		return carritoRepository.findAll();
	}// getAllCarritoItems

	public Carrito getCarritoItem(Long id) {
		return carritoRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("El item de carrito con el id [" + id + "] no existe."));
	}// getCarritoItem

	public Carrito deleteCarritoItem(Long id) {
		Carrito tmpCarritoItem = null;

		if (carritoRepository.existsById(id)) {
			tmpCarritoItem = carritoRepository.findById(id).get();
			carritoRepository.deleteById(id);
		}

		return tmpCarritoItem;
	}// deleteCarritoItem

	public Carrito addCarritoItem(Carrito carritoItem) {
		return carritoRepository.save(carritoItem);
	}// addCarritoItem

	public Carrito updateCarritoItem(Long id, Integer cantidad) {
		Carrito tmpCarrito = null;

		if (carritoRepository.existsById(id)) {
			Carrito cart = carritoRepository.findById(id).get();

			if (cantidad != null) {

				if (cantidad <= 0) {
					carritoRepository.deleteById(id);
					return null;
				}

				cart.setCantidad(cantidad);
				tmpCarrito = carritoRepository.save(cart);
			}
		}

		return tmpCarrito;
	}// updateCarritoItem

}// CarritoService