package db.operation.hib;

/**
 * Interface to create operations on database entities using hibernate.
 * 
 * @author Mateusz Mucha
 *
 * @param <T>
 *            type of returned data which can be an entity or something else
 */
public interface HibernateOperation<T> {
	/**
	 * Method to run strategy of database operation.
	 * 
	 * @return some object on specific type declared in implementing classes
	 */
	T run();
}