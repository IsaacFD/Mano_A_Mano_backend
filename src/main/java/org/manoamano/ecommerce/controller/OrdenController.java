package org.manoamano.ecommerce.controller;

import java.math.BigDecimal;
import java.util.List;

import org.manoamano.ecommerce.model.Orden;
import org.manoamano.ecommerce.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(path = "/ecommerce/ordenes/")
public class OrdenController {

	private final OrdenService ordenService;

	@Autowired
	public OrdenController(OrdenService ordenService) {
		this.ordenService = ordenService;
	}// OrdenController Constructor

	@GetMapping
	public List<Orden> getOrdenes() {
		return ordenService.getOrdenes();
	}// getOrdenes

	@GetMapping(path = "{ordenId}")
	public Orden getOrden(@PathVariable("ordenId") Long id) {
		return ordenService.getOrden(id);
	}// getOrden

	@DeleteMapping(path = "{ordenId}")
	public Orden deleteOrden(@PathVariable("ordenId") Long id) {
		return ordenService.deleteOrden(id);
	}// deleteOrden

	@PostMapping
	public Orden addOrden(@RequestBody Orden orden) {
		return ordenService.addOrden(orden);
	}// addOrden

	@PutMapping(path = "{ordenId}")
	public Orden updateOrden(@PathVariable("ordenId") Long id,
			@RequestParam(value = "estado", required = false) String estado,
			@RequestParam(value = "total", required = false) BigDecimal total) {

		return ordenService.updateOrden(id, estado, total);
	}// updateOrden

}// OrdenController