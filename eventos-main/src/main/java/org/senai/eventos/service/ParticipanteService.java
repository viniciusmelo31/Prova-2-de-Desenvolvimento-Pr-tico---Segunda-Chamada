package org.senai.eventos.service;

import org.senai.eventos.entity.Participante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParticipanteService {

    private final List<Participante> participantes;

    public ParticipanteService() {
        this.participantes = new ArrayList();
    }

    public List<Participante> listarParticipantes() {
        return participantes;
    }

    public Participante encontrarParticipantePorId(Long codigo) {
        return participantes.stream().filter(participante -> participante.getCodigo() == codigo).findFirst().get();
    }

    public Participante criarParticipante(Participante participante) {
        participantes.add(participante);
        return participante;
    }

    public Participante atualizarParticipante(Long codigo, Participante detalhesParticipante) {
        participantes.forEach(participante -> {
            if (participante.getCodigo() == codigo) {
                participante.setNome(detalhesParticipante.getNome());
                participante.setEmail(detalhesParticipante.getEmail());
            }
        });
        return detalhesParticipante;
    }

    public void deletarParticipante(Long codigo) {
        participantes.removeIf(participante -> participante.getCodigo().equals(codigo));
    }

}
