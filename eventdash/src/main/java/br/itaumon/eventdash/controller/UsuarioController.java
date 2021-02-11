package br.itaumon.eventdash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itaumon.eventdash.model.Usuario;
import br.itaumon.eventdash.repository.UsuarioRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepo repo;

    @GetMapping("/id/{id}")
    public ResponseEntity<Usuario> buscaUsuarioId(@PathVariable int id){
        Usuario usuarioEncontrado = repo.findById(id).orElse(null);  //find o id ou retorna null

        if(usuarioEncontrado != null){
            return ResponseEntity.ok(usuarioEncontrado);  //ok é o status 200
        }
        return ResponseEntity.notFound().build();   // notfound é o status 404 e .build significa monta a resposta com nada dentro
    }

    @GetMapping("/racf/{racf}")
    public ResponseEntity<Usuario> buscaUsuarioRacf(@PathVariable String racf){
        Usuario usuarioEncontrado = null;
        
        usuarioEncontrado = repo.findByRacf(racf);  //find o id ou retorna null

        if(usuarioEncontrado != null){
            return ResponseEntity.ok(usuarioEncontrado);  //ok é o status 200
        }
        return ResponseEntity.notFound().build();   // notfound é o status 404 e .build significa monta a resposta com nada dentro
    }

    @GetMapping("/email/{email}") 
    public ResponseEntity<Usuario> buscaUsuarioEmail(@PathVariable String email){
        Usuario usuarioEncontrado = null;
        usuarioEncontrado = repo.findByEmail(email);  //find o id ou retorna null

        if(usuarioEncontrado != null){ 
            return ResponseEntity.ok(usuarioEncontrado);  //ok é o status 200
        }
        return ResponseEntity.notFound().build();   // notfound é o status 404 e .build significa monta a resposta com nada dentro
    }   

	@GetMapping("/getnome/{nome}")
	public ResponseEntity<List<Usuario>> getNome(@PathVariable String nome){
		List<Usuario> lista = repo.findByNome(nome);
		if (lista==null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}    

    @GetMapping("/all")
	public ResponseEntity<List<Usuario>> getAll(){
		List<Usuario> lista = (List<Usuario>) repo.findAll();
		if(lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}

    @PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario usuario){
		Usuario usuarioEncontrado = repo.findByEmailOrRacf(usuario.getEmail(),usuario.getRacf());

		if (usuarioEncontrado != null ) {
			if (usuarioEncontrado.getSenha().equals(usuario.getSenha())) {
				
				// mascarar a senha do usuario para nao exibir no retorno
				usuarioEncontrado.setSenha("********");
				
				return ResponseEntity.ok(usuarioEncontrado);
			}

		}
		
		return ResponseEntity.status(403).build();
	}	

 
	/*
	@DeleteMapping("/usuario/{cod}")
	public ResponseEntity<Usuario> apagarUsuario(@PathVariable int cod) {
		Usuario objeto = repo.findById(cod).orElse(null);
		if (objeto == null) {
			return ResponseEntity.status(404).build();
		}
		repo.delete(objeto);
		return ResponseEntity.ok(objeto);
	}
    */

	/*
    @PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario usuario){
		Usuario userFound = null;
		userFound = repo.findByEmailAndSenha(usuario.getEmail(),usuario.getSenha());

		if (userFound == null ) {
			userFound=repo.findByRacfAndSenha(usuario.getEmail(),usuario.getSenha());
			if (userFound == null ) {
				return ResponseEntity.status(403).build();
			}

		}
		return ResponseEntity.ok(userFound);
	}
    */
	/*
	@PutMapping("/usuario/{cod}")
	public ResponseEntity<Usuario> update(@PathVariable int cod, @RequestBody Usuario objeto){
		try {
			objeto.setCodigo(cod);
			Usuario resposta = repo.save(objeto);
			return ResponseEntity.ok(resposta);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
		
	}
	
	

	@PostMapping("/novousuario")
	public ResponseEntity<Usuario> add(@RequestBody Usuario objeto){
		try {
			Usuario resposta = dao.save(objeto);
			return ResponseEntity.ok(resposta);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
		
	}
    */


    
}
