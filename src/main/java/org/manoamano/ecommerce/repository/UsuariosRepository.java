package org.manoamano.ecommerce.repository;

import java.util.Optional;

import org.manoamano.ecommerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByCorreo(String correo);

}// interface UsuariosRepository