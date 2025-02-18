package org.simarro.adt6_examen3.service;

import jakarta.transaction.Transactional;
import org.simarro.adt6_examen3.model.Paquete;
import org.simarro.adt6_examen3.model.PaqueteRequestDTO;
import org.simarro.adt6_examen3.model.PaqueteResponseDTO;
import org.simarro.adt6_examen3.model.ResumenDTO;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IPaqueteService {

   Paquete registrar (PaqueteRequestDTO paqueteDTO);

    @Transactional
    Integer eliminarPorEmail( String email);

    Integer sumarPorNombre(String nombre);

    Integer sumarPorId(Integer id);

    List<PaqueteResponseDTO> buscarPorFecha(LocalDate fechaBuscar);

    ResumenDTO contarEstado();

    Paquete cambiarEstado( LocalDate fechaEntrega, String nombre );

    List<Paquete> buscarParametros( String direccion, String nombre );




}
