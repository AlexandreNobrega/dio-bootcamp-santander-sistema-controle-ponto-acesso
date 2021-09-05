package com.dio.live.controller;

import com.dio.live.model.BancoHoras;
import com.dio.live.model.Localidade;
import com.dio.live.model.Movimentacao;
import com.dio.live.repository.BancoHorasRepository;
import com.dio.live.repository.MovimentacaoRepositorio;
import com.dio.live.service.BancoHorasService;
import com.dio.live.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    MovimentacaoRepositorio movimentacaoRepositorio;

    @Autowired
    MovimentacaoService movimentacaoService;

    @PostMapping
    public Movimentacao createMovimentacao(@Valid @RequestBody Movimentacao movimentacao) {
        return movimentacaoService.saveMovimentacao(movimentacao);
    }

    @GetMapping
    public List<Movimentacao> getMovimentacaoList() {
        return movimentacaoService.findAll();
    }

    @GetMapping("/{idMovimentacao}")
    public ResponseEntity<Movimentacao> getBancoHorasByID(@PathVariable("idMovimentacao") Long idMovimentacao) {
        Optional<Movimentacao> movimentacao = this.movimentacaoRepositorio.findById(idMovimentacao);

        if (movimentacao.isPresent()) {
            return ResponseEntity.ok(movimentacao.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public Movimentacao updateBancoHoras(@RequestBody Movimentacao movimentacao) {
        return movimentacaoService.updateBancoHoras(movimentacao);
    }

    @DeleteMapping("/{idMovimentacao}")
    public ResponseEntity<Movimentacao> deleteByID(@PathVariable("idMovimentacao") Long idMovimentacao) {
        Optional<Movimentacao> bancoHoras = this.movimentacaoRepositorio.findById(idMovimentacao);

        if (bancoHoras.isPresent()) {
            movimentacaoService.deleteBancoHoras(idMovimentacao);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
