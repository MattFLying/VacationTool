package db.operation.hib.dao;

import java.util.List;

import db.entity.Entity;
import db.operation.hib.HibernateOperation;

/**
 * Class to execute strategies in dao classes.
 * 
 * @author Mateusz Mucha
 *
 * @param <T>
 *            entity type which should be returned
 */
public class HibernateExecutor<T extends Entity> {

	/**
	 * Defulat constructor.
	 */
	public HibernateExecutor() {

	}

	/**
	 * Method to execute operation on single entities objects.
	 * 
	 * @param operation
	 *            operation strategy to execute
	 * @return final entity after execute strategy
	 */
	public T action(HibernateOperation<T> operation) {
		return operation.run();
	}

	/**
	 * Method to execute basic operation on entities list.
	 * 
	 * @param operation
	 *            operation of list strategy to execute
	 * @return final entities list after execute strategy
	 */
	public List<T> actionList(HibernateOperation<List<T>> operation) {
		return operation.run();
	}

}