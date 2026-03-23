package org.manoamano.ecommerce.controller;

import java.math.BigDecimal;
import java.util.List;

import org.manoamano.ecommerce.model.OrdenProducto;
import org.manoamano.ecommerce.service.OrdenProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ecommerce/orden-productos/")
@CrossOrigin (origins="34.201.41.216", methods= {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class OrdenProductoController {

	private final OrdenProductoService ordenProductoService;

	@Autowired
	public OrdenProductoController(OrdenProductoService ordenProductoService) {
		this.ordenProductoService = ordenProductoService;
	}// OrdenProductoController Constructor

	@GetMapping
	public List<OrdenProducto> getOrdenProductos() {
		return ordenProductoService.getOrdenProductos();
	}// getOrdenProductos

	@GetMapping(path = "{ordenProductoId}")
	public OrdenProducto getOrdenProducto(@PathVariable("ordenProductoId") Long id) {
		return ordenProductoService.getOrdenProducto(id);
	}// getOrdenProducto

	@DeleteMapping(path = "{ordenProductoId}")
	public OrdenProducto deleteOrdenProducto(@PathVariable("ordenProductoId") Long id) {
		return ordenProductoService.deleteOrdenProducto(id);
	}// deleteOrdenProducto

	@PostMapping
	public OrdenProducto addOrdenProducto(@RequestBody OrdenProducto ordenProducto) {
		return ordenProductoService.addOrdenProducto(ordenProducto);
	}// addOrdenProducto

	@PutMapping(path = "{ordenProductoId}")
	public OrdenProducto updateOrdenProducto(@PathVariable("ordenProductoId") Long id,
			@RequestParam(value = "cantidad", required = false) Integer cantidad,
			@RequestParam(value = "precioUnitario", required = false) BigDecimal precioUnitario,
			@RequestParam(value = "subtotal", required = false) BigDecimal subtotal) {

		return ordenProductoService.updateOrdenProducto(id, cantidad, precioUnitario, subtotal);
	}// updateOrdenProducto

}// OrdenProductoController