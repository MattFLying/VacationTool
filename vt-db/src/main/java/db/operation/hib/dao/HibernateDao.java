package db.operation.hib.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.operation.DatabaseOperations;
import db.util.HibernateUtil;

/**
 * Implementation of basic oeprations on database.
 * 
 * @author Mateusz Mucha
 *
 * @param <T>
 *            entity type
 */
abstract class HibernateDao<T> implements DatabaseOperations<T> {
	/**
	 * Field to define type of passed entity.
	 */
	private Class<? extends T> daoClassType;

	/**
	 * Default constructor.
	 */
	protected HibernateDao() {
		defineTypeOfEntity();
	}

	/**
	 * Method to define type of passed entity.
	 */
	private void defineTypeOfEntity() {
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parametrized = (ParameterizedType) type;
		this.daoClassType = (Class) parametrized.getActualTypeArguments()[0];
	}

	@Override
	public <S extends T> S save(S entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Transaction transaction = session.beginTransaction();

			if (session.contains(entity)) {
				session.save(entity);
			} else {
				session.update(entity);
			}
			transaction.commit();

			return entity;
		} catch (Exception e) {
			e.getStackTrace();

			return entity;
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}
	}

	@Override
	public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Transaction transaction = session.beginTransaction();

			entities.forEach(entity -> {
				if (session.contains(entity)) {
					session.save(entity);
				} else {
					session.update(entity);
				}
			});
			transaction.commit();

			return entities;
		} catch (Exception e) {
			e.getStackTrace();

			return entities;
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}
	}

	@Override
	public Optional<T> findById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		T found = (T) session.get(daoClassType, id);

		if (found != null) {
			return Optional.of(found);
		} else {
			return null;
		}
	}

	@Override
	public boolean existsById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		T found = (T) session.get(daoClassType, id);

		if (found != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Iterable<T> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = null;
		List<T> list = null;

		try {
			criteria = session.createCriteria(daoClassType);
			list = criteria.list();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}

		return list;
	}

	@Override
	public void deleteById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Transaction transaction = session.beginTransaction();
			session.delete(findById(id).get());
			transaction.commit();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}
	}

	@Override
	public void delete(T entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Transaction transaction = session.beginTransaction();
			session.delete(entity);
			transaction.commit();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}
	}

	@Override
	public void deleteAll(Iterable<? extends T> entities) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Transaction transaction = session.beginTransaction();
			for (T entity : entities) {
				session.delete(entity);
			}
			transaction.commit();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}
	}
}