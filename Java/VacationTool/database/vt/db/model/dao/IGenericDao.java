package vt.db.model.dao;

import java.util.List;
import org.hibernate.HibernateException;
import vt.db.model.entity.base.Entity;
/***
 * Basic interface for DAO objects using to operations on database. Contains
 * basic operations on database.
 * @author Mateusz Mucha
 * @param <T> - is an Entity type object
 */
public interface IGenericDao<T extends Entity> {
	/***
	 * Method to save entity in database.
	 * 
	 * @param entity
	 * @return int value represent success of operations: 0 - operation failed 1
	 *         - operation successful
	 * @throws HibernateException
	 */
	int save(T entity) throws HibernateException;

	/***
	 * Method to update entity in database.
	 * 
	 * @param entity
	 * @return int value represent success of operations: 0 - operation failed 1
	 *         - operation successful
	 * @throws HibernateException
	 */
	int update(T entity) throws HibernateException;

	/***
	 * Method to delete entity in database.
	 * 
	 * @param entity
	 * @return int value represent success of operations: 0 - operation failed 1
	 *         - operation successful
	 * @throws HibernateException
	 */
	int delete(T entity) throws HibernateException;

	/***
	 * Method to delete all entities in database.
	 * 
	 * @param entities
	 * @return int value represent success of operations: 0 - operation failed 1
	 *         - operation successful
	 * @throws HibernateException
	 */
	int deleteAll(List<T> entities) throws HibernateException;

	/***
	 * Method to find entity in database by specific identificator.
	 * 
	 * @param id
	 * @return specific entity
	 * @throws HibernateException
	 */
	T findById(int id) throws HibernateException;

	/***
	 * Method to find all entities in database.
	 * 
	 * @param clazz
	 * @return list of entities
	 * @throws HibernateException
	 */
	List<T> findAll(Class<T> clazz) throws HibernateException;
}