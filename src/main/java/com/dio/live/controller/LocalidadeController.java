package com.dio.live.controller;

import com.dio.live.model.Localidade;
import com.dio.live.repository.LocalidadeRepository;
import com.dio.live.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {


    @Autowired
    LocalidadeRepository localidadeRepository;

    @Autowired
    LocalidadeService localidadeService;

    @PostMapping
    public Localidade createLocalidade(@Valid @RequestBody Localidade localidade) {
        return localidadeService.saveLocalidade(localidade);
    }

    @GetMapping
    public List<Localidade> getLocalidadeList() {
        return localidadeService.findAll();
    }

    @GetMapping("/{idLocalidade}")
    public ResponseEntity<Localidade> getLocalidadeByID(@PathVariable("idLocalidade") Long idLocalidade) {
        Optional<Localidade> localidade = this.localidadeRepository.findById(idLocalidade);

        if (localidade.isPresent()) {
            return ResponseEntity.ok(localidade.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public Localidade updateLocalidade(@RequestBody Localidade localidade) {
        return localidadeService.updateLocalidade(localidade);
    }

    @DeleteMapping("/{idLocalidade}")
    public ResponseEntity<Localidade> deleteByID(@PathVariable("idLocalidade") Long idLocalidade) {
        Optional<Localidade> localidade = this.localidadeRepository.findById(idLocalidade);

        if (localidade.isPresent()) {
            localidadeService.deleteLocalidade(idLocalidade);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
