package org.manoamano.ecommerce.repository;

import org.manoamano.ecommerce.model.OrdenProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenProductosRepository extends JpaRepository<OrdenProducto, Long> {

}// interface OrdenProductosRepository