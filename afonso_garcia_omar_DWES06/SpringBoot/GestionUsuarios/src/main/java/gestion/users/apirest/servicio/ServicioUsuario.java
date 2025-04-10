package gestion.users.apirest.servicio;

import java.util.List;

import gestion.users.apirest.entity.Usuario;

public interface ServicioUsuario {
	
	public List<Usuario> findAll();
	
	public Usuario findById(int id);
	
	public void create (Usuario user);
	
	public void update (Usuario user);
	
	public void deletedById(int id);

}
