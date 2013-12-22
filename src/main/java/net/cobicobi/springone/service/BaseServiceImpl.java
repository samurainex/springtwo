package net.cobicobi.springone.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.cobicobi.springone.repo.BaseRepo;

import com.google.common.collect.Lists;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

	public List<T> getAll() {
		return Lists.newArrayList(getRepo().findAll());
	}

	public List<T> getAll(int offset, int limit) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

		CriteriaQuery<T> cq = cb.createQuery(getEntityClass());
		Root<T> r = cq.from(getEntityClass());
		TypedQuery<T> tq = getEntityManager().createQuery(cq.select(r));

		return tq.setFirstResult(offset).setMaxResults(limit).getResultList();
	}

	public T get(Serializable id) {
		return getRepo().findOne(id);
	}

	public void save(T entity) {
		getRepo().save(entity);		
	}

	public void delete(T entity) {
		getRepo().delete(entity);
	}
	
	protected abstract BaseRepo<T> getRepo();
	
	protected abstract EntityManager getEntityManager();
	
	protected abstract Class<T> getEntityClass();
}
