package com.dio.live.controller;

import com.dio.live.model.Calendario;
import com.dio.live.model.Usuario;
import com.dio.live.repository.CalendarioRepository;
import com.dio.live.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {

    @Autowired
    CalendarioRepository calendarioRepository;

    @Autowired
    CalendarioService calendarioService;

    @PostMapping
    public Calendario createCalendario(@RequestBody Calendario calendario) {
        return calendarioService.saveCalendario(calendario);
    }

    @GetMapping
    public List<Calendario> getUsuarioList() {
        return calendarioService.findAll();
    }

    @GetMapping("/{idCalendario}")
    public ResponseEntity<Calendario> getUsuarioByID(@PathVariable("idCalendario") Long idCalendario) throws Exception {
        return ResponseEntity.ok(calendarioService.getById(idCalendario).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public Calendario updateCalendario(@RequestBody Calendario calendario) {
        return calendarioService.updateCalendario(calendario);
    }

    @DeleteMapping("/{idCalendario}")
    public ResponseEntity<Calendario> deleteByID(@PathVariable("idCalendario") Long idCalendario) {
        Optional<Calendario> calendario = this.calendarioRepository.findById(idCalendario);

        if (calendario.isPresent()) {
            calendarioService.deleteCalendario(idCalendario);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
