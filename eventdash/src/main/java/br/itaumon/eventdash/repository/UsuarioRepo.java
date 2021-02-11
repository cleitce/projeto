package br.itaumon.eventdash.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.itaumon.eventdash.model.Usuario;

//CRUD - Create, Read, Update e Delete registros
public interface UsuarioRepo extends CrudRepository<Usuario, Integer>{
    
	public Usuario findByEmailAndSenha(String email,String senha);
	public Usuario findByRacfAndSenha(String racf,String senha);
	public Usuario findByEmailOrRacf(String email,String racf);
    public Usuario findByEmail(String email);
    public Usuario findByRacf(String racf);
	public List<Usuario> findByNome(String nome);
}
