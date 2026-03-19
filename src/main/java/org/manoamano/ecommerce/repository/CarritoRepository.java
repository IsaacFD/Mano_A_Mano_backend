package org.manoamano.ecommerce.repository;

import org.manoamano.ecommerce.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {

}// interface CarritoRepository