package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaRepository;
import com.dio.live.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @Autowired
    JornadaRepository jornadaRepository;

    @PostMapping
    public JornadaTrabalho createJornada(@Valid @RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.saveJornada(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> getJornadaList(){
        return jornadaService.findAll();

    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho>  getJornadaByID(@PathVariable("idJornada") Long idJornada) {
        Optional<JornadaTrabalho> jornadaTrabalho = this.jornadaRepository.findById(idJornada);

        if (jornadaTrabalho.isPresent()) {
            return ResponseEntity.ok(jornadaTrabalho.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.updateJornada(jornadaTrabalho);
    }

    @DeleteMapping("/{idJornada}")
    public ResponseEntity deleteByID(@PathVariable("idJornada") Long idJornada) throws Exception {
        Optional<JornadaTrabalho> jornadaTrabalho = this.jornadaRepository.findById(idJornada);

        if (jornadaTrabalho.isPresent()) {
            jornadaService.deleteJornada(idJornada);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
