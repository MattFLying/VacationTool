package vt.db.model.dao;

import java.util.List;
import org.hibernate.HibernateException;

import vt.db.model.entity.Employee;

public interface IGenericDao<T> {
	int save(T entity) throws HibernateException;
	int update(T entity) throws HibernateException;
	int delete(T entity) throws HibernateException;
	int deleteAll(List<T> entities) throws HibernateException;
	T findById(int id) throws HibernateException;
	List<T> findAll(Class<T> clazz) throws HibernateException;
}