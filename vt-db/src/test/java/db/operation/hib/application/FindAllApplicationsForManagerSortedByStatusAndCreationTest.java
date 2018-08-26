package db.operation.hib.application;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import db.entity.Application;
import db.operation.hib.ApplicationListOperation;
import db.operation.hib.HibernateOperation;

/**
 * Class to test finding application list for specific manager.
 * 
 * @author Mateusz Mucha
 *
 */
public class FindAllApplicationsForManagerSortedByStatusAndCreationTest {
	private final int managerId = 14;

	/**
	 * Method to test find application list for specific manager by creating
	 * instance of class object.
	 */
	@Test
	public void runTestForInstantiateObject() {
		FindAllApplicationsForManagerSortedByStatusAndCreation find = new FindAllApplicationsForManagerSortedByStatusAndCreation(
				managerId);

		assertNotNull(find);

		List<Application> list = find.run();
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	/**
	 * Method to test find application list for specific manager by using
	 * interface of applicationlistoperation.
	 */
	@Test
	public void runTestForInstantiateByApplicationInterface() {
		ApplicationListOperation find = new FindAllApplicationsForManagerSortedByStatusAndCreation(managerId);

		assertNotNull(find);

		List<Application> list = find.run();
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	/**
	 * Method to test find application list for specific manager by using main
	 * interface.
	 */
	@Test
	public void runTestForInstantiateByMainInterface() {
		HibernateOperation<List<Application>> find = new FindAllApplicationsForManagerSortedByStatusAndCreation(
				managerId);

		assertNotNull(find);

		List<Application> list = find.run();
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}
}
