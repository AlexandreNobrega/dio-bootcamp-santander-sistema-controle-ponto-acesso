package com.dio.live.controller;

import com.dio.live.model.TipoData;
import com.dio.live.repository.TipoDataRepository;
import com.dio.live.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipoData")
public class TipoDataController {

    @Autowired
    TipoDataRepository tipoDataRepository;

    @Autowired
    TipoDataService tipoDataService;

    @PostMapping
    public TipoData createTipoData(@Valid @RequestBody TipoData tipoData) {
        return tipoDataService.saveTipoData(tipoData);
    }

    @GetMapping
    public List<TipoData> getTipoDataList() {
        return tipoDataService.findAll();
    }

    @GetMapping("/{idTipoData}")
    public ResponseEntity<TipoData> getTipoDataByID(@PathVariable("idTipoData") Long idTipoData) {
        Optional<TipoData> tipoData = this.tipoDataRepository.findById(idTipoData);

        if (tipoData.isPresent()) {
            return ResponseEntity.ok(tipoData.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public TipoData updateTipoData(@RequestBody TipoData tipoData) {
        return tipoDataService.updateTipoData(tipoData);
    }

    @DeleteMapping("/{idTipoData}")
    public ResponseEntity<TipoData> deleteByID(@PathVariable("idTipoData") Long idTipoData) {
        Optional<TipoData> tipoData = this.tipoDataRepository.findById(idTipoData);

        if (tipoData.isPresent()) {
            tipoDataService.deleteTipoData(idTipoData);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
