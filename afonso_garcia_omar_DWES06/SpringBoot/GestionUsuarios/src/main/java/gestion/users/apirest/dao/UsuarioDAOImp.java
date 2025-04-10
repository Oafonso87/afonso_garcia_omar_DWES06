package gestion.users.apirest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;

import gestion.users.apirest.entity.Usuario;
import jakarta.persistence.EntityManager;

@Repository
public class UsuarioDAOImp implements UsuarioDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<Usuario> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Usuario> consulta = currentSession.createQuery("from Usuario", Usuario.class);
		List<Usuario> user = consulta.getResultList();
		return user;
	}

	@Override
	@Transactional
	public Usuario findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Usuario user = currentSession.get(Usuario.class, id);

		return user;
	}

	@Override
	@Transactional
	public void create(Usuario user) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(user);


	}
	
	@Override
	@Transactional
	public void update(Usuario user) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(user);


	}

	@Override
	@Transactional
	public void deletedById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		//Query consulta = currentSession.createQuery("delete from usuario where id = :id");
	    var consulta = currentSession.createMutationQuery("delete from Usuario where id = :id");
		consulta.setParameter("id", id);
		consulta.executeUpdate();

	}

}
