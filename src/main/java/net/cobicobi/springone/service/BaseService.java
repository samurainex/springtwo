package net.cobicobi.springone.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
	
	List<T> getAll();
	
	List<T> getAll(int offset, int limit);
	
	T get(Serializable id);
	
	void save(T entity);
	
	void delete(T entity);
	
}
