package org.manoamano.ecommerce.controller;

import java.util.List;

import org.manoamano.ecommerce.model.Carrito;
import org.manoamano.ecommerce.service.CarritoService;
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
@RequestMapping(path = "/ecommerce/carrito/")
@CrossOrigin (origins="34.201.41.216")
public class CarritoController {

	private final CarritoService carritoService;

	@Autowired
	public CarritoController(CarritoService carritoService) {
		this.carritoService = carritoService;
	}// CarritoController Constructor

	@GetMapping
	public List<Carrito> getAllCarritoItems() {
		return carritoService.getAllCarritoItems();
	}// getAllCarritoItems

	@GetMapping(path = "{carritoId}")
	public Carrito getCarritoItem(@PathVariable("carritoId") Long id) {
		return carritoService.getCarritoItem(id);
	}// getCarritoItem

	@DeleteMapping(path = "{carritoId}")
	public Carrito deleteCarritoItem(@PathVariable("carritoId") Long id) {
		return carritoService.deleteCarritoItem(id);
	}// deleteCarritoItem

	@PostMapping
	public Carrito addCarritoItem(@RequestBody Carrito carrito) {
		return carritoService.addCarritoItem(carrito);
	}// addCarritoItem

	@PutMapping(path = "{carritoId}")
	public Carrito updateCarritoItem(@PathVariable("carritoId") Long id,
			@RequestParam(value = "cantidad", required = false) Integer cantidad) {

		return carritoService.updateCarritoItem(id, cantidad);
	}// updateCarritoItem

}// CarritoController