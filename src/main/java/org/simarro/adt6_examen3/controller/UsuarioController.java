package org.simarro.adt6_examen3.controller;

import org.simarro.adt6_examen3.model.Usuario;
import org.simarro.adt6_examen3.repository.IUsuarioRepository;
import org.simarro.adt6_examen3.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    @Autowired
    private IUsuarioService service;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarPorId(@PathVariable("id") Integer id){
        Usuario obj = service.listarPorId(id);
// Código 200 OK para select
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }



}
