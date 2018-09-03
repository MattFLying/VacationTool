package web.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import db.entity.BaseEntity;
import web.exception.ResultNotFoundException;
import web.exception.ValueCannotBeNull;

/**
 * Default service with basic CRUD oeprations. Should be extended by all
 * services with special entity parameter.
 * 
 * @author Mateusz Mucha
 *
 * @param <T>
 *            entity type
 */
@Service
public abstract class DefaultService<T extends BaseEntity> {
	@Autowired
	private CrudRepository<T, Integer> operation;

	/**
	 * Method to find entity with specific identificator.
	 * 
	 * @param id
	 *            identificator of entity to find
	 * @return entity result as optional
	 * @throws ResultNotFoundException
	 *             throw when result was not found
	 */
	public Optional<T> findById(int id) throws ResultNotFoundException {
		Optional<T> result = operation.findById(id);

		if (!result.isPresent())
			throw new ResultNotFoundException(String.format("The result of id: %d could not be found.", id));
		return result;
	}

	/**
	 * Method to find all positions of specific entity.
	 * 
	 * @return collection of entities
	 * @throws ResultNotFoundException
	 *             throw when result collection was not found
	 */
	public Collection<T> findAll() throws ResultNotFoundException {
		Iterable<T> result = operation.findAll();
		Collection<T> list = new ArrayList<T>();

		if (!result.iterator().hasNext())
			throw new ResultNotFoundException("There is no result to show.");
		result.forEach(list::add);

		return list;
	}

	/**
	 * Method to delete specific entity.
	 * 
	 * @param entity
	 *            entity to delete
	 * @throws ResultNotFoundException
	 *             if passed entity is null then cannot be deleted
	 */
	public void delete(T entity) throws ResultNotFoundException {
		if (!Optional.ofNullable(entity).isPresent())
			throw new ResultNotFoundException("You cannot delete empty entity.");
		operation.delete(entity);
	}

	/**
	 * Method to delete entity with specific identificator.
	 * 
	 * @param id
	 *            identificator of entity to delete
	 * @throws ResultNotFoundException
	 *             throw when entity with given identificator does not exists
	 */
	public void delete(int id) throws ResultNotFoundException {
		if (!operation.existsById(id))
			throw new ResultNotFoundException(String.format("Entity with given id: %d does not exists.", id));
		operation.deleteById(id);
	}

	/**
	 * Method to add and update entity. Entity is updated when identificator is
	 * not null.
	 * 
	 * @param entity
	 *            entity to add or update.
	 * @return entity which was saved
	 * @throws ResultNotFoundException
	 *             throw when entity could not be saved
	 * @throws MySQLIntegrityConstraintViolationException
	 *             throw when all required fields were not filled
	 */
	public T save(T entity) throws ResultNotFoundException, MySQLIntegrityConstraintViolationException {
		T result = operation.save(entity);

		if (!Optional.ofNullable(result).isPresent())
			throw new ResultNotFoundException("Entity could not be saved.");

		return result;
	}

	/**
	 * Method to check if passed collection is empty and throw exceptino if is.
	 * 
	 * @param list
	 *            collection to check
	 * @param message
	 *            message to show
	 * @throws ResultNotFoundException
	 *             throw when passed collection is empty
	 */
	protected void throwExceptionWhenListIsEmpty(Collection<T> list, String message) throws ResultNotFoundException {
		if (list.isEmpty())
			throw new ResultNotFoundException(message);
	}

	/**
	 * Method to check if passed value object is null and throw exceptino if is.
	 * 
	 * @param value
	 *            value to check
	 * @param message
	 *            message to show
	 * @throws ResultNotFoundException
	 *             throw when passed value is null
	 */
	protected void throwExceptionWhenValueIsNull(Object value, String message) throws ValueCannotBeNull {
		if (!Optional.ofNullable(value).isPresent())
			throw new ValueCannotBeNull(message);
	}
}