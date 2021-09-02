package com.dio.live.service;

import com.dio.live.model.Calendario;
import com.dio.live.repository.CalendarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarioService {

    CalendarioRepository calendarioRepository;

    public CalendarioService(CalendarioRepository calendarioRepository) { this.calendarioRepository = calendarioRepository; }

    public Calendario saveCalendario(Calendario calendario) {
        return calendarioRepository.save(calendario);
    }

    public List<Calendario> findAll() {
        return calendarioRepository.findAll();
    }

    public Optional<Calendario> getById(Long idCalendario) {
        return calendarioRepository.findById(idCalendario);
    }

    public Calendario updateCalendario(Calendario calendario) {
        return calendarioRepository.save(calendario);
    }

    public void deleteCalendario(Long idCalendario) {
        calendarioRepository.deleteById(idCalendario);
    }



}
