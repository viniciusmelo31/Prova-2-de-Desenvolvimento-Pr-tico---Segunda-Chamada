package org.senai.eventos.controller;

import org.senai.eventos.entity.Evento;
import org.senai.eventos.service.EventoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public List<Evento> listarEventos() {
        return eventoService.listarEventos();
    }

    @GetMapping("/{codigo}")
    public Evento encontrarEventoPorId(@PathVariable Long codigo) {
        return eventoService.encontrarEventoPorId(codigo);
    }

    @PostMapping
    public Evento criarEvento(@RequestBody Evento evento) {
        return eventoService.criarEvento(evento);
    }

    @PutMapping("/{codigo}")
    public Evento atualizarEvento(@PathVariable Long codigo, @RequestBody Evento detalhesEvento) {
        return eventoService.atualizarEvento(codigo, detalhesEvento);
    }

    @DeleteMapping("/{codigo}")
    public void deletarEvento(@PathVariable Long codigo) {
        eventoService.deletarEvento(codigo);
    }
}

