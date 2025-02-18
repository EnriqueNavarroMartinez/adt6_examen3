package org.simarro.adt6_examen3.service;

import org.simarro.adt6_examen3.model.Usuario;
import org.simarro.adt6_examen3.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private IUsuarioRepository repo;

    @Override
    public Usuario listarPorId(Integer id) {
        Optional<Usuario> op = repo.findById(id);
        return op.isPresent() ? op.get() : null;
    }
}
