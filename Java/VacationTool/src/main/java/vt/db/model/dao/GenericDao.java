package vt.db.model.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vt.db.model.entity.base.Entity;
import vt.db.model.util.HibernateUtil;

public abstract class GenericDao<T> implements IGenericDao<T> {
	protected Class<? extends T> daoClassType;

	
	public GenericDao() {
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parametrized = (ParameterizedType) type;
		this.daoClassType = (Class) parametrized.getActualTypeArguments()[0];
	}

	
	public int save(T entity) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Transaction transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();

			return 1;
		} catch (Exception e) {
			e.getStackTrace();

			return 0;
		} finally {
			session.clear();
			session.close();
		}
	}
	public int update(T entity) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Transaction transaction = session.beginTransaction();
			session.update(entity);
			transaction.commit();

			return 1;
		} catch (Exception e) {
			e.getStackTrace();

			return 0;
		} finally {
			session.clear();
			session.close();
		}
	}
	public int delete(T entity) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Transaction transaction = session.beginTransaction();
			session.delete(entity);
			transaction.commit();

			return 1;
		} catch (Exception e) {
			e.getStackTrace();

			return 0;
		} finally {
			session.clear();
			session.close();
		}
	}
	public int deleteAll(List<T> entities) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Transaction transaction = session.beginTransaction();
			for (T entity : entities) {
				session.delete(entity);
			}
			transaction.commit();

			return 1;
		} catch (Exception e) {
			e.getStackTrace();

			return 0;
		} finally {
			session.clear();
			session.close();
		}
	}
	public T findById(int id) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		T found = (T) session.get(daoClassType, id);

		if (found != null) {
			return found;
		} else {
			return null;
		}
	}
	public List<T> findAll(Class<T> clazz) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = null;
		List<T> list = null;
		
		try {
			criteria = session.createCriteria(clazz);
			list = criteria.list();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			session.clear();
			session.close();
		}
		
		return list;
	}
}