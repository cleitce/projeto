package br.itaumon.eventdash.repository;

import org.springframework.data.repository.CrudRepository;

import br.itaumon.eventdash.model.Equipamento;

public interface EquipamentoRepo extends CrudRepository <Equipamento, Integer>{
    
}
