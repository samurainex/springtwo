package net.cobicobi.springone.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.cobicobi.springone.entity.User;
import net.cobicobi.springone.repo.BaseRepo;
import net.cobicobi.springone.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
@Transactional(readOnly=true)
public class UserServiceImpl extends BaseServiceImpl<User> 
implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@PersistenceContext(unitName="springonePU")
	private EntityManager em;

	public User getByUsername(String username) {
		return em.createNamedQuery("User.findByUsername", User.class)
				.setParameter("username", username).getSingleResult();
	}
	
	public User getByEmail(String email) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		
		Root<User> root = criteria.from(User.class);
		criteria.where(builder.equal(root.get("email"), email));
		TypedQuery<User> query = em.createQuery(criteria.select(root));
		
		return query.getSingleResult();
	}

	@Override
	protected BaseRepo<User> getRepo() {
		return userRepo;
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

}
