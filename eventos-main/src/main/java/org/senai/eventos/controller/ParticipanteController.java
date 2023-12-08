package org.senai.eventos.controller;

import org.senai.eventos.entity.Participante;
import org.senai.eventos.service.ParticipanteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

    private final ParticipanteService participanteService;

    public ParticipanteController(ParticipanteService participanteService) {
        this.participanteService = participanteService;
    }

    @GetMapping
    public List<Participante> listarParticipantes() {
        return participanteService.listarParticipantes();
    }

    @GetMapping("/{codigo}")
    public Participante encontrarParticipantePorId(@PathVariable Long codigo) {
        return participanteService.encontrarParticipantePorId(codigo);
    }

    @PostMapping
    public Participante criarParticipante(@RequestBody Participante participante) {
        return participanteService.criarParticipante(participante);
    }

    @PutMapping("/{codigo}")
    public Participante atualizarParticipante(@PathVariable Long codigo, @RequestBody Participante detalhesParticipante) {
        return participanteService.atualizarParticipante(codigo, detalhesParticipante);
    }

    @DeleteMapping("/{codigo}")
    public void deletarParticipante(@PathVariable Long codigo) {
        participanteService.deletarParticipante(codigo);
    }
}
