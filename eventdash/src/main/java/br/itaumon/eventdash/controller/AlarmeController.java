package br.itaumon.eventdash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itaumon.eventdash.model.Alarme;
import br.itaumon.eventdash.repository.AlarmeRepo;

@RestController // Indica que a classe irá responder protocolos HTTP (GET/POST)
@CrossOrigin("*")
@RequestMapping("/alarme")
public class AlarmeController {

	@Autowired // indica que o gerenciamento do atributo sera feito pelo Spring
	private AlarmeRepo repo;
	
	@GetMapping("/all")
	public ResponseEntity<List<Alarme>> getAll(){
		List<Alarme> lista = (List<Alarme>) repo.findAll();
		if(lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Alarme> pesquisarAlarme(@PathVariable int id) {
		Alarme objeto = repo.findById(id).orElse(null);
		if (objeto == null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(objeto);
	}    
}
