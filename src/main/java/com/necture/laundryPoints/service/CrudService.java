package com.necture.laundryPoints.service;

import java.util.List;

public interface CrudService<T, Id> {

	List<T> findAll();

	T findById(Id id);

	T save(T object);

	void delete(T object);

	void deleteById(Id id);

}
