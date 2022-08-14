package com.venusville.apivenusville.services;

import com.venusville.apivenusville.entities.Usuario;
import com.venusville.apivenusville.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {

    IUsuarioRepository iUsuarioRepository;

    @Autowired
    public DbService(IUsuarioRepository iUsuarioRepository) {
        this.iUsuarioRepository = iUsuarioRepository;
    }

    public Usuario postUsuario(Usuario usuario) {
        return iUsuarioRepository.save(usuario);
    }

    public List<Usuario> getUsuario() {
        return iUsuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return iUsuarioRepository.findById(id);
    }

    public Usuario putUsario(Usuario usuario) {
        return iUsuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        iUsuarioRepository.deleteById(id);
    }
}
