package db.operation;

import java.util.Optional;

/**
 * Interface represents basic operations on database.
 * 
 * @author Mateusz Mucha
 *
 * @param <T>
 *            entity class type
 */
public interface DatabaseOperations<T> {
	/**
	 * Method to save and update entity to database.
	 * 
	 * @param entity
	 *            entity to save or update
	 * @return entity which has been saved or updated
	 */
	<S extends T> S save(S entity);

	/**
	 * Method to save all entities at one time.
	 * 
	 * @param entities
	 *            entities to save or update
	 * @return entities which have been saved or updated
	 */
	<S extends T> Iterable<S> saveAll(Iterable<S> entities);

	/**
	 * Method to find entity by identificator
	 * 
	 * @param id
	 *            identificator
	 * @return entity of specific identificator
	 */
	Optional<T> findById(Integer id);

	/**
	 * Method to check if entity exist in database.
	 * 
	 * @param id
	 *            identificator of entity to check
	 * @return true if entity exist in database and false if not
	 */
	boolean existsById(Integer id);

	/**
	 * Method to find all entities.
	 * 
	 * @return all entities
	 */
	Iterable<T> findAll();

	/**
	 * Method to delete entity from database with specific id
	 * 
	 * @param id
	 *            identificator of entity
	 */
	void deleteById(Integer id);

	/**
	 * Method to delete specific entity from database
	 * 
	 * @param entity
	 *            entity to delete
	 */
	void delete(T entity);

	/**
	 * Method to delete all entities
	 * 
	 * @param entities
	 *            entities list to delete
	 */
	void deleteAll(Iterable<? extends T> entities);
}