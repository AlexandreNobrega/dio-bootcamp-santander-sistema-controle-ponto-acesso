package com.dio.live.controller;

import com.dio.live.model.Ocorrencia;
import com.dio.live.repository.OcorrenciaRepository;
import com.dio.live.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    @Autowired
    OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    OcorrenciaService ocorrenciaService;

    @PostMapping
    public Ocorrencia createOcorrencia(@Valid @RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaService.saveOcorrencia(ocorrencia);
    }

    @GetMapping
    public List<Ocorrencia> getOcorrenciaList() {
        return ocorrenciaService.findAll();
    }

    @GetMapping("/{idOcorrencia}")
    public ResponseEntity<Ocorrencia> getOcorrenciaByID(@PathVariable("idOcorrencia") Long idOcorrencia) {
        Optional<Ocorrencia> ocorrencia = this.ocorrenciaRepository.findById(idOcorrencia);

        if (ocorrencia.isPresent()) {
            return ResponseEntity.ok(ocorrencia.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public Ocorrencia updateOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaService.updateOcorrencia(ocorrencia);
    }

    @DeleteMapping("/{idOcorrencia}")
    public ResponseEntity<Ocorrencia> deleteByID(@PathVariable("idOcorrencia") Long idOcorrencia) {
        Optional<Ocorrencia> ocorrencia = this.ocorrenciaRepository.findById(idOcorrencia);

        if (ocorrencia.isPresent()) {
            ocorrenciaService.deleteOcorrencia(idOcorrencia);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
