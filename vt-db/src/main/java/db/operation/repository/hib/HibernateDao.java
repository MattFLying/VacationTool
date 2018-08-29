package db.operation.repository.hib;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import javax.persistence.RollbackException;
import javax.persistence.TransactionRequiredException;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

import db.exception.ExceptionDescription;
import db.operation.DatabaseOperations;
import db.operation.hib.employee.ChangeEmployeePassword;
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
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			if (session.contains(entity)) {
				session.save(entity);
			} else {
				session.update(entity);
			}
			transaction.commit();

		} catch (HibernateException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_SESSION_OPEN.fullDescription());
		} catch (RollbackException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_TRANSATION_FAIL.fullDescription());
		} catch (IllegalStateException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_ENTITYMANAGER_CLOSED.fullDescription());
		} catch (IllegalArgumentException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_ATTRIBUTE_NO_EXIST.fullDescription());
		} catch (TransactionRequiredException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_TRANSACTION_FAIL.fullDescription());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return entity;
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
		} catch (HibernateException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_SESSION_OPEN.fullDescription());
		} catch (RollbackException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_TRANSATION_FAIL.fullDescription());
		} catch (IllegalStateException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_ENTITYMANAGER_CLOSED.fullDescription());
		} catch (IllegalArgumentException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_ATTRIBUTE_NO_EXIST.fullDescription());
		} catch (TransactionRequiredException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_TRANSACTION_FAIL.fullDescription());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return entities;
	}

	@Override
	public Optional<T> findById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		T found = (T) session.get(daoClassType, id);

		return Optional.ofNullable(found);
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
		} catch (HibernateException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_SESSION_OPEN.fullDescription());
		} catch (RollbackException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_TRANSATION_FAIL.fullDescription());
		} catch (IllegalStateException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_ENTITYMANAGER_CLOSED.fullDescription());
		} catch (IllegalArgumentException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_ATTRIBUTE_NO_EXIST.fullDescription());
		} catch (TransactionRequiredException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_TRANSACTION_FAIL.fullDescription());
		} finally {
			if (session != null) {
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
		} catch (HibernateException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_SESSION_OPEN.fullDescription());
		} catch (RollbackException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_TRANSATION_FAIL.fullDescription());
		} catch (IllegalStateException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_ENTITYMANAGER_CLOSED.fullDescription());
		} catch (IllegalArgumentException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_ATTRIBUTE_NO_EXIST.fullDescription());
		} catch (TransactionRequiredException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_TRANSACTION_FAIL.fullDescription());
		} finally {
			if (session != null) {
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
		} catch (HibernateException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_SESSION_OPEN.fullDescription());
		} catch (RollbackException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_TRANSATION_FAIL.fullDescription());
		} catch (IllegalStateException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_ENTITYMANAGER_CLOSED.fullDescription());
		} catch (IllegalArgumentException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_ATTRIBUTE_NO_EXIST.fullDescription());
		} catch (TransactionRequiredException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_TRANSACTION_FAIL.fullDescription());
		} finally {
			if (session != null) {
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
		} catch (HibernateException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_SESSION_OPEN.fullDescription());
		} catch (RollbackException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_TRANSATION_FAIL.fullDescription());
		} catch (IllegalStateException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_ENTITYMANAGER_CLOSED.fullDescription());
		} catch (IllegalArgumentException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_ATTRIBUTE_NO_EXIST.fullDescription());
		} catch (TransactionRequiredException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_TRANSACTION_FAIL.fullDescription());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}