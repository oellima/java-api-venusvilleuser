package com.venusville.apivenusville.controllers;

import com.venusville.apivenusville.entities.Usuario;
import com.venusville.apivenusville.exceptions.UsuarioNotFoundException;
import com.venusville.apivenusville.services.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/usuario")
public class UsuarioController {

    @Autowired
    DbService dbService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario criarUsuario(@RequestBody @Validated Usuario usuario) { return dbService.postUsuario(usuario); }

    @GetMapping
    public List<Usuario> getUsuario() {
        return dbService.getUsuario();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(dbService.getUsuarioById(id).orElseThrow(() ->
                new UsuarioNotFoundException("Usuario com ID: " + id + "Não foi Encontrado!!!"))) ;
    }

    @PutMapping("/{id}")
    public Object putUsuario(@PathVariable Long id, @RequestBody Usuario usuario) throws UsuarioNotFoundException {
        try {
            return dbService.putUsario(usuario);
        }catch (Exception ex){
            return ("Usuario com ID: " + id + "Não foi Encontrado!!!!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable Long id) throws UsuarioNotFoundException{
        try {
            dbService.deleteUsuario(id);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return ResponseEntity.ok().build();
    }
}
