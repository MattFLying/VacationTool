package db.operation.hib.employee;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import db.entity.Employee;
import db.operation.hib.EmployeeListOperation;
import db.operation.hib.HibernateOperation;

/**
 * Class to test finding all employees which are a manager.
 * 
 * @author Mateusz Mucha
 *
 */
public class FindAllManagersTest {
	/**
	 * Method to test find employees list which are a manager by creating
	 * instance of class object.
	 */
	@Test
	public void runTestForInstantiateObject() {
		FindAllManagers find = new FindAllManagers();

		assertNotNull(find);

		List<Employee> list = find.run();
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	/**
	 * Method to test find employees list which are a manager by using interface
	 * of EmployeeListOperation.
	 */
	@Test
	public void runTestForInstantiateByEmployeeInterface() {
		EmployeeListOperation find = new FindAllManagers();

		assertNotNull(find);

		List<Employee> list = find.run();
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	/**
	 * Method to test find employees list which are a manager by using main
	 * interface.
	 */
	@Test
	public void runTestForInstantiateByMainInterface() {
		HibernateOperation<List<Employee>> find = new FindAllManagers();

		assertNotNull(find);

		List<Employee> list = find.run();
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

}
