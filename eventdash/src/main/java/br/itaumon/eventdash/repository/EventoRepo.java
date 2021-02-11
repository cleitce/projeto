package br.itaumon.eventdash.repository;

import org.springframework.data.repository.CrudRepository;

import br.itaumon.eventdash.model.Evento;

public interface EventoRepo extends CrudRepository <Evento, Integer>{
    
}
