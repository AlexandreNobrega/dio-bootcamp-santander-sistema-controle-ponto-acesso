package com.dio.live.controller;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.model.Usuario;
import com.dio.live.repository.CategoriaUsuarioRepository;
import com.dio.live.repository.UsuarioRepository;
import com.dio.live.service.CategoriaUsuarioService;
import com.dio.live.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/categoriaUsuario")
public class CategoriaUsuarioController {

    @Autowired
    CategoriaUsuarioRepository categoriaUsuarioRepository;

    @Autowired
    CategoriaUsuarioService categoriaUsuarioService;

    @PostMapping
    public CategoriaUsuario createUsuario(@RequestBody CategoriaUsuario categoriaUsuario) {
        return categoriaUsuarioService.saveCategoriaUsuario(categoriaUsuario);
    }

    @GetMapping
    public List<CategoriaUsuario> getUsuarioList() {
        return categoriaUsuarioService.findAll();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<CategoriaUsuario> getUsuarioByID(@PathVariable("idUsuario") Long idUsuario) throws Exception {
        return ResponseEntity.ok(categoriaUsuarioService.getById(idUsuario).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public CategoriaUsuario updateCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario) {
        return categoriaUsuarioService.updateCategoriaUsuario(categoriaUsuario);
    }

    @DeleteMapping("/{idCategoriaUsuario}")
    public ResponseEntity<CategoriaUsuario> deleteByID(@PathVariable("idCategoriaUsuario") Long idCategoriaUsuario) {
        Optional<CategoriaUsuario> usuario = this.categoriaUsuarioRepository.findById(idCategoriaUsuario);

        if (usuario.isPresent()) {
            categoriaUsuarioService.deleteCategoriaUsuario(idCategoriaUsuario);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
