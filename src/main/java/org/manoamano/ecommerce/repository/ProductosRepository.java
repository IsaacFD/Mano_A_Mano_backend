package org.manoamano.ecommerce.repository;

import java.util.Optional;

import org.manoamano.ecommerce.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Producto, Long> {

	Optional<Producto> findByNombre(String nombre);

}// interface ProductosRepository