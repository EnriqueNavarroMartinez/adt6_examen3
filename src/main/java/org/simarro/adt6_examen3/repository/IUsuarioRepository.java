package org.simarro.adt6_examen3.repository;

import org.simarro.adt6_examen3.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository  extends JpaRepository<Usuario, Integer> {

    @Query("FROM Usuario u WHERE LOWER(u.nombre) LIKE %:nombre%")
    Usuario listarPorNombre(@Param("nombre") String nombre);


    @Query("FROM Usuario u WHERE LOWER(u.email) LIKE %:email%")
    Usuario listarPorEmail(@Param("email") String email);


}
