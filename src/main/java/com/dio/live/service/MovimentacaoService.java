package com.dio.live.service;

import com.dio.live.model.Movimentacao;
import com.dio.live.repository.MovimentacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    MovimentacaoRepositorio movimentacaoRepositorio;

    @Autowired
    public MovimentacaoService(MovimentacaoRepositorio movimentacaoRepositorio) {
        this.movimentacaoRepositorio = movimentacaoRepositorio;
    }

    public Movimentacao saveMovimentacao(Movimentacao movimentacao){
        return movimentacaoRepositorio.save(movimentacao);
    }

    public List<Movimentacao> findAll() {
        return movimentacaoRepositorio.findAll();
    }

    public Optional<Movimentacao> getById(Long idMovimentacao) {
        return movimentacaoRepositorio.findById(idMovimentacao);
    }

    public Movimentacao updateBancoHoras(Movimentacao movimentacao) {
        return movimentacaoRepositorio.save(movimentacao);
    }

    public void deleteBancoHoras(Long idBancoHoras) {
        movimentacaoRepositorio.deleteById(idBancoHoras);
    }
}
