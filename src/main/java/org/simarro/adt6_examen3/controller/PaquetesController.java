package org.simarro.adt6_examen3.controller;

import jakarta.validation.Valid;
import org.simarro.adt6_examen3.model.*;
import org.simarro.adt6_examen3.repository.IUsuarioRepository;
import org.simarro.adt6_examen3.service.IPaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paquetes")
public class PaquetesController {

    @Autowired
    private IPaqueteService service;

    @Autowired
    private IUsuarioRepository repository;

    @PostMapping
    public ResponseEntity<Paquete> registrar(@RequestBody PaqueteRequestDTO producto) {
        Paquete obj = service.registrar(producto);

        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }



    @DeleteMapping("/{email}")
    public ResponseEntity<Void> eliminarPorEmail(@PathVariable("email") String email){

        Usuario usuario = repository.listarPorEmail(email);
        if(usuario == null){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        service.eliminarPorEmail(email);
// Código 204 NOT CONTENT para delete
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/calcular")
    public ResponseEntity<Integer> sumarPorNombre(@RequestParam("nombre") String nombre){

        Usuario usuario  = repository.listarPorNombre(nombre);

        if(usuario==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        int total = service.sumarPorNombre(nombre);
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

    @GetMapping("/calcularId")
    public ResponseEntity<Integer> sumarPorId(@RequestParam("id") Integer id){

        Optional<Usuario> usuario  = repository.findById(id);

        if(usuario==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        int total = service.sumarPorId(id);
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

    @GetMapping("/buscarFecha")
    public ResponseEntity<List<PaqueteResponseDTO>> buscarPorFecha(@RequestParam("fechaBuscar") LocalDate fechaBuscar){

        List<PaqueteResponseDTO> lista = service.buscarPorFecha(fechaBuscar);


        return new ResponseEntity<>(lista,HttpStatus.OK);
    }

    @GetMapping("/contarEstado")
    public ResponseEntity<ResumenDTO> contarEstado(){

        ResumenDTO resumen= service.contarEstado();


        return new ResponseEntity<>(resumen,HttpStatus.OK);
    }

    @PutMapping("/entregar")
    public ResponseEntity<Paquete> cambiarEstado(@RequestParam("fechaEntrega")  LocalDate fechaEntrega, @RequestParam("nombre") String nombre) {

        Paquete paquete = service.cambiarEstado(fechaEntrega, nombre);
        return new ResponseEntity<>(paquete, HttpStatus.OK);
    }

    @GetMapping("/buscarParametros")
    public ResponseEntity<List<Paquete>> buscarParametros(@RequestParam(required = false) String direccion, @RequestParam(required = false) String nombre){

        List<Paquete> lista = service.buscarParametros(direccion,nombre);


        return new ResponseEntity<>(lista,HttpStatus.OK);
    }


}
