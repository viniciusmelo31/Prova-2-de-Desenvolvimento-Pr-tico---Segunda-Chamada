package org.senai.eventos.service;
import org.senai.eventos.entity.Evento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventoService {
    List<Evento> eventos;

    public EventoService(){
        eventos = new ArrayList();
    }

    public List<Evento> listarEventos(){
        return eventos;
    }

    public Evento encontrarEventoPorId(Long codigo){
        return eventos.stream().filter(evento -> evento.getCodigo() == codigo).findFirst().get();
    }

    public Evento criarEvento(Evento evento){
        eventos.add(evento);
        return evento;
    }

    public Evento atualizarEvento(Long codigo, Evento detalhesEvento){
        eventos.forEach(evento -> {
            if (evento.getCodigo() == codigo) {
                evento.setNome(detalhesEvento.getNome());
                evento.setDescricao(detalhesEvento.getDescricao());
                evento.setCusto(detalhesEvento.getCusto());
                evento.setData(detalhesEvento.getData());
            }
        });
        return detalhesEvento;

    }

    public void deletarEvento(Long codigo){
        eventos.removeIf(evento -> evento.getCodigo() == codigo);
    }
}
