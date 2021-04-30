package br.itaumon.eventdash.repository;

import org.springframework.data.repository.CrudRepository;

import br.itaumon.eventdash.model.Evento;

import java.time.LocalDate;
import java.util.List;

public interface EventoRepo extends CrudRepository <Evento, Integer>{
    
    //public List<Evento> findByDataevtBetweenOrderByDataevtAsc(LocalDate dataini, LocalDate datafim);
    //public List<Evento> findBydata_evtBetweenOrderBydata_evtAsc(LocalDate dataini, LocalDate datafim);
    public List<Evento> findBydata_evtBetween(LocalDate dataini, LocalDate datafim);
  
}
