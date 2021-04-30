package br.itaumon.eventdash.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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


    @PostMapping("/data")
    public ResponseEntity <List<Evento>> buscarPorDataEvt(@RequestBody ObjectNode json) throws ParseException{      
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate ini = LocalDate.parse(json.get("dt1").asText(), fmt);
		LocalDate fim = LocalDate.parse(json.get("dt2").asText(), fmt);

        List<Evento> lista = repo.findBydata_evtBetween(ini, fim);

		if(lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
        return ResponseEntity.ok(lista);
    }

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
