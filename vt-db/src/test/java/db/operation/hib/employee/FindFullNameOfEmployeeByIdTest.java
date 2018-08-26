package db.operation.hib.employee;

import static org.junit.Assert.*;

import org.junit.Test;

import db.entity.Employee;
import db.operation.hib.EmployeeOperation;
import db.operation.hib.HibernateOperation;

/**
 * Class to test finding full builded name of employee.
 * 
 * @author Mateusz Mucha
 *
 */
public class FindFullNameOfEmployeeByIdTest {
	private final int employeeId = 1;

	/**
	 * Method to test find full name of employee by creating instance of class
	 * object.
	 */
	@Test
	public void runTestForInstantiateObject() {
		FindFullNameOfEmployeeById find = new FindFullNameOfEmployeeById(employeeId);

		assertNotNull(find);

		Employee employee = find.run();
		assertNotNull(employee);
		assertEquals(0, employee.getId().intValue());
		assertEquals("Mateusz", employee.getFirstName());
		assertEquals("Mucha", employee.getLastName());
	}

	/**
	 * Method to test find full name of employee by using interface of
	 * EmployeeOperation.
	 */
	@Test
	public void runTestForInstantiateByEmployeeInterface() {
		EmployeeOperation find = new FindFullNameOfEmployeeById(employeeId);

		assertNotNull(find);

		Employee employee = find.run();
		assertNotNull(employee);
		assertEquals(0, employee.getId().intValue());
		assertEquals("Mateusz", employee.getFirstName());
		assertEquals("Mucha", employee.getLastName());
	}

	/**
	 * Method to test find full name of employee by using main interface.
	 */
	@Test
	public void runTestForInstantiateByMainInterface() {
		HibernateOperation<Employee> find = new FindFullNameOfEmployeeById(employeeId);

		assertNotNull(find);

		Employee employee = find.run();
		assertNotNull(employee);
		assertEquals(0, employee.getId().intValue());
		assertEquals("Mateusz", employee.getFirstName());
		assertEquals("Mucha", employee.getLastName());
	}

}
