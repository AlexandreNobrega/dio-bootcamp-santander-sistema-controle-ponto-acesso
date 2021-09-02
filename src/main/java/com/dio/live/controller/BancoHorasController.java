package com.dio.live.controller;

import com.dio.live.model.BancoHoras;
import com.dio.live.model.Usuario;
import com.dio.live.repository.BancoHorasRepository;
import com.dio.live.service.BancoHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/bancoHoras")
public class BancoHorasController {

    @Autowired
    BancoHorasRepository bancoHorasRepository;

    @Autowired
    BancoHorasService bancoHorasService;

    @PostMapping
    public BancoHoras createBancoHoras(@RequestBody BancoHoras bancoHoras) {
        return bancoHorasService.saveBancoHoras(bancoHoras);
    }

    @GetMapping
    public List<BancoHoras> getBancoHorasList() {
        return bancoHorasService.findAll();
    }

    @GetMapping("/{idBancoHoras}")
    public ResponseEntity<BancoHoras> getBancoHorasByID(@PathVariable("idBancoHoras") Long idBancoHoras) throws Exception {
        return ResponseEntity.ok(bancoHorasService.getById(idBancoHoras).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public BancoHoras updateBancoHoras(@RequestBody BancoHoras bancoHoras) {
        return bancoHorasService.updateBancoHoras(bancoHoras);
    }

    @DeleteMapping("/{idBancoHoras}")
    public ResponseEntity<BancoHoras> deleteByID(@PathVariable("idBancoHoras") Long idBancoHoras) {
        Optional<BancoHoras> bancoHoras = this.bancoHorasRepository.findById(idBancoHoras);

        if (bancoHoras.isPresent()) {
            bancoHorasService.deleteBancoHoras(idBancoHoras);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
