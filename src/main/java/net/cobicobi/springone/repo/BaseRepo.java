package net.cobicobi.springone.repo;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

public interface BaseRepo<T> extends CrudRepository<T, Serializable>{

}
