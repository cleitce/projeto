package br.itaumon.eventdash.repository;

import org.springframework.data.repository.CrudRepository;

import br.itaumon.eventdash.model.Alarme;

//CRUD - Create, Read, Update e Delete registros
public interface AlarmeRepo extends CrudRepository<Alarme, Integer>{
    
}
