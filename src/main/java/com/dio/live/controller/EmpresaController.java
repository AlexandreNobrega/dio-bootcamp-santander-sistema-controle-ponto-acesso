package com.dio.live.controller;

import com.dio.live.model.Empresa;
import com.dio.live.repository.EmpresaRepository;
import com.dio.live.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    EmpresaService empresaService;

    @PostMapping
    public Empresa createEmpresa(@Valid @RequestBody Empresa empresa) {
        return empresaService.saveEmpresa(empresa);
    }

    @GetMapping
    public List<Empresa> getEmpresaList() {
        return empresaService.findAll();
    }

    @GetMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> getEmpresaByID(@PathVariable("idEmpresa") Long idEmpresa) {
        Optional<Empresa> empresa = this.empresaRepository.findById(idEmpresa);

        if (empresa.isPresent()) {
            return ResponseEntity.ok(empresa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public Empresa updateEmpresa(@RequestBody Empresa empresa) {
        return empresaService.updateEmpresa(empresa);
    }

    @DeleteMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> deleteByID(@PathVariable("idEmpresa") Long idEmpresa) {
        Optional<Empresa> empresa = this.empresaRepository.findById(idEmpresa);

        if (empresa.isPresent()) {
            empresaService.deleteEmpresa(idEmpresa);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
