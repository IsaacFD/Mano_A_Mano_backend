package org.manoamano.ecommerce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.manoamano.ecommerce.model.Orden;
import org.manoamano.ecommerce.repository.OrdenesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenService {

	private final OrdenesRepository ordenesRepository;

	@Autowired
	public OrdenService(OrdenesRepository ordenesRepository) {
		this.ordenesRepository = ordenesRepository;
	}// Constructor

	public List<Orden> getOrdenes() {
		return ordenesRepository.findAll();
	}// getOrdenes

	public Orden getOrden(Long id) {
		return ordenesRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("La orden con el id [" + id + "] no existe."));
	}// getOrden

	public Orden deleteOrden(Long id) {
		Orden tmpOrden = null;

		if (ordenesRepository.existsById(id)) {
			tmpOrden = ordenesRepository.findById(id).get();
			ordenesRepository.deleteById(id);
		}

		return tmpOrden;
	}// deleteOrden

	public Orden addOrden(Orden orden) {
		return ordenesRepository.save(orden);
	}// addOrden

	public Orden updateOrden(Long id, String estado, BigDecimal total) {
		Orden tmpOrden = null;

		if (ordenesRepository.existsById(id)) {
			Orden order = ordenesRepository.findById(id).get();

			if (estado != null)
				order.setEstado(estado);
			if (total != null)
				order.setTotal(total);

			order.setFechaActualizacion(LocalDateTime.now());

			tmpOrden = ordenesRepository.save(order);
		}

		return tmpOrden;
	}// updateOrden

}// OrdenService