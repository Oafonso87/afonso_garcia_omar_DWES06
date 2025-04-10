package gestion.users.apirest.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.users.apirest.entity.Usuario;
import gestion.users.apirest.dao.*;


@Service
public class ServicioUsuarioImp implements ServicioUsuario {
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	
	@Override
	public List<Usuario> findAll() {
		List<Usuario> listUsers = usuarioDAO.findAll();
		return listUsers;
	}

	@Override
	public Usuario findById(int id) {
		Usuario user = usuarioDAO.findById(id);
		return user;
	}

	@Override
	public void create(Usuario user) {
		usuarioDAO.create(user);

	}

	@Override
	public void update(Usuario user) {
		usuarioDAO.update(user);
	}

	@Override
	public void deletedById(int id) {
		usuarioDAO.deletedById(id);

	}

}
