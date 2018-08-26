package db.operation.hib.application;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import db.entity.Application;
import db.operation.hib.ApplicationListOperation;
import db.operation.hib.HibernateOperation;

/**
 * Class to test finding all application list.
 * 
 * @author Mateusz Mucha
 *
 */
public class FindAllApplicationsSortedByStatusAndCreationTest {

	/**
	 * Method to test find application list by creating instance of class
	 * object.
	 */
	@Test
	public void runTestForInstantiateObject() {
		FindAllApplicationsSortedByStatusAndCreation find = new FindAllApplicationsSortedByStatusAndCreation();

		assertNotNull(find);

		List<Application> list = find.run();
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	/**
	 * Method to test find application list by using interface of
	 * applicationlistoperation.
	 */
	@Test
	public void runTestForInstantiateByApplicationInterface() {
		ApplicationListOperation find = new FindAllApplicationsSortedByStatusAndCreation();

		assertNotNull(find);

		List<Application> list = find.run();
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	/**
	 * Method to test find application list by using main interface.
	 */
	@Test
	public void runTestForInstantiateByMainInterface() {
		HibernateOperation<List<Application>> find = new FindAllApplicationsSortedByStatusAndCreation();

		assertNotNull(find);

		List<Application> list = find.run();
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

}
