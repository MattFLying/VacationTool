package db.operation.repository.hib;

import java.util.Collection;
import db.entity.BaseEntity;
import db.operation.hib.HibernateOperation;

/**
 * Class to execute strategies in dao classes.
 * 
 * @author Mateusz Mucha
 *
 * @param <T>
 *            entity type which should be returned
 */
public class HibernateExecutor<T extends BaseEntity> {

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
	public Collection<T> actionCollection(HibernateOperation<Collection<T>> operation) {
		return operation.run();
	}

}