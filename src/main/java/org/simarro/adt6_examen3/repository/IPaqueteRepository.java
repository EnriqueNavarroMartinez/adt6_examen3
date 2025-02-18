package org.simarro.adt6_examen3.repository;


import jakarta.transaction.Transactional;
import org.simarro.adt6_examen3.model.Paquete;
import org.simarro.adt6_examen3.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IPaqueteRepository extends JpaRepository<Paquete, Integer> {

    @Modifying
    @Transactional
    @Query("delete FROM Paquete p WHERE LOWER(p.Usuario.email) LIKE %:email%")
    Integer eliminarPorEmail(@Param("email") String email);

    @Query("select sum(p.precioTotal) FROM Paquete p WHERE LOWER(p.Usuario.nombre) LIKE %:nombre%")
    Integer sumarPorNombre(@Param("nombre") String nombre);

    @Query("select sum(p.precioTotal) FROM Paquete p WHERE (p.Usuario.id) = :id")
    Integer sumarPorId(@Param("id") Integer id);

    @Query("select p FROM Paquete p WHERE (p.entregado=false) and (p.fechaEntrega >= :fechaBuscar)")
    List<Paquete> buscarPorFecha(@Param("fechaBuscar") LocalDate fechaBuscar);

    @Query("select p FROM Paquete p WHERE (p.entregado=false) and (p.fechaEntrega >= :fechaEntrega)and (p.Usuario.nombre = :nombre)")
    Paquete cambiarEstado(@Param("fechaEntrega") LocalDate fechaEntrega,@Param("nombre") String nombre );

    @Query("select p FROM Paquete p WHERE (p.Usuario.direccion = :direccion or :direccion is null ) and  (p.Usuario.nombre = :nombre or :nombre is null )")
    List<Paquete> buscarParametros(@Param("direccion") String direccion,@Param("nombre") String nombre );
}
