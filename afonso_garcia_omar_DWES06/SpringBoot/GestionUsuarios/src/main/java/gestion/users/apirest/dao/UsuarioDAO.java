package gestion.users.apirest.dao;

import java.util.List;

import gestion.users.apirest.entity.Usuario;

public interface UsuarioDAO {

	public List<Usuario> findAll();
	
	public Usuario findById(int id);
	
	public void create (Usuario user);
	
	public void update (Usuario user);

	
	public void deletedById(int id);
}
