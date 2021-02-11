package br.itaumon.eventdash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itaumon.eventdash.model.Evento;
import br.itaumon.eventdash.repository.EventoRepo;

@RestController // Indica que a classe irá responder protocolos HTTP (GET/POST)
@CrossOrigin("*")
@RequestMapping("/evento")
public class EventoController {

	@Autowired // indica que o gerenciamento do atributo sera feito pelo Spring
	private EventoRepo repo;

	@GetMapping("/all")
	public ResponseEntity<List<Evento>> getAll(){
		List<Evento> lista = (List<Evento>) repo.findAll();
		if(lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/num_seq/{numseq}")
	public ResponseEntity<Evento> pesquisarEvento(@PathVariable int numseq) {
		Evento objeto = repo.findById(numseq).orElse(null);
		if (objeto == null) {
			return ResponseEntity.status(404).build();
			
		}
		return ResponseEntity.ok(objeto);
	}

	
}
