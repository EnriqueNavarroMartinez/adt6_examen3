package org.simarro.adt6_examen3.service;

import jakarta.transaction.Transactional;
import jakarta.websocket.ClientEndpoint;
import org.modelmapper.ModelMapper;
import org.simarro.adt6_examen3.model.*;
import org.simarro.adt6_examen3.repository.IPaqueteRepository;
import org.simarro.adt6_examen3.repository.IUsuarioRepository;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaqueteServiceImpl implements IPaqueteService{

    @Autowired
    private IPaqueteRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IUsuarioRepository repository;


    @Override
    public Paquete registrar(PaqueteRequestDTO paqueteDTO) {

        if(paqueteDTO.getFechaEntrega().isAfter(paqueteDTO.getFechaPedido())){
            throw new IllegalArgumentException("Las fechas estan mal");

        }

        Usuario usuario = repository.listarPorEmail(paqueteDTO.getEmailCliente());
        if(usuario==null){
            throw new IllegalArgumentException("Usuario no existe");

        }

        Paquete paquete1 = new Paquete();
        paquete1.setFechaPedido(paqueteDTO.getFechaPedido());
        paquete1.setFechaEntrega(paqueteDTO.getFechaEntrega());
        paquete1.setPrecioTotal(paqueteDTO.getPrecioTotal());
        paquete1.setEntregado(false);
        paquete1.setUsuario(usuario);

        return repo.save(paquete1);
    }

    @Override
    @Transactional
    public Integer eliminarPorEmail(String email) {
        return repo.eliminarPorEmail(email);
    }

    @Override
    public Integer sumarPorNombre(String nombre) {
        return repo.sumarPorNombre(nombre);
    }

    @Override
    public Integer sumarPorId(Integer id) {
        return repo.sumarPorId(id);
    }

    @Override
    public List<PaqueteResponseDTO> buscarPorFecha(LocalDate fechaBuscar) {
        return repo.buscarPorFecha(fechaBuscar).stream().map( paquete -> modelMapper.map(paquete, PaqueteResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ResumenDTO contarEstado() {

        List<Paquete> paquetes = repo.findAll();

        int entregados=0;
        int noEntregados=0;

        for(Paquete paquete: paquetes){
            if (paquete.isEntregado()){
                entregados++;
            }else{
                noEntregados++;
            }
        }
        return new ResumenDTO(entregados,noEntregados);
    }

    @Override
    @Transactional
    public Paquete cambiarEstado(LocalDate fechaEntrega, String nombre) {

        Paquete paquete = repo.cambiarEstado(fechaEntrega,nombre);

        if (paquete == null) {
            throw new RuntimeException("No se encontró un paquete para el usuario '" + nombre + "' con la fecha de entrega '" + fechaEntrega + "'");
        }

        paquete.setEntregado(true);

        return repo.save(paquete);
    }

    @Override
    public List<Paquete> buscarParametros(String direccion, String nombre) {


        return repo.buscarParametros(direccion,nombre);
    }


}
