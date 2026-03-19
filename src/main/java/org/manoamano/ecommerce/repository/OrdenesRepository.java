package org.manoamano.ecommerce.repository;

import org.manoamano.ecommerce.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenesRepository extends JpaRepository<Orden, Long> {

}// interface OrdenRepository