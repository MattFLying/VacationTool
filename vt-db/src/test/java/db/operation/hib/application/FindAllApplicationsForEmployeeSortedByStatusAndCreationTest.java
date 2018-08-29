package db.operation.hib.application;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import db.entity.Application;
import db.operation.hib.ApplicationListOperation;
import db.operation.hib.HibernateOperation;

/**
 * Class to test finding application list for specific employee.
 * 
 * @author Mateusz Mucha
 *
 */
public class FindAllApplicationsForEmployeeSortedByStatusAndCreationTest {
	private final int employeeId = 14;

	/**
	 * Method to test find application list for specific employee by creating
	 * instance of class object.
	 */
	@Test
	public void runTestForInstantiateObject() {
		FindAllApplicationsForEmployeeSortedByStatusAndCreation find = new FindAllApplicationsForEmployeeSortedByStatusAndCreation(
				employeeId);

		assertNotNull(find);

		List<Application> list = find.run().stream().collect(Collectors.toList());
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	/**
	 * Method to test find application list for specific employee by using
	 * interface of applicationlistoperation.
	 */
	@Test
	public void runTestForInstantiateByApplicationInterface() {
		ApplicationListOperation find = new FindAllApplicationsForEmployeeSortedByStatusAndCreation(employeeId);

		assertNotNull(find);

		List<Application> list = find.run().stream().collect(Collectors.toList());
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	/**
	 * Method to test find application list for specific employee by using main
	 * interface.
	 */
	@Test
	public void runTestForInstantiateByMainInterface() {
		HibernateOperation<Collection<Application>> find = new FindAllApplicationsForEmployeeSortedByStatusAndCreation(
				employeeId);

		assertNotNull(find);

		List<Application> list = find.run().stream().collect(Collectors.toList());
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

}
