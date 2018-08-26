package db.operation.hib.employee;

import static org.junit.Assert.*;

import org.junit.Test;

import db.entity.Employee;
import db.operation.hib.EmployeeOperation;
import db.operation.hib.HibernateOperation;

/**
 * Class to test finding manager of employee.
 * 
 * @author Mateusz Mucha
 *
 */
public class FindManagerIdByEmployeeIdTest {
	private final int managerId = 1;
	private final int employeeId = 4;

	/**
	 * Method to test find manager of employee by creating instance of class
	 * object.
	 */
	@Test
	public void runTestForInstantiateObject() {
		FindManagerIdByEmployeeId find = new FindManagerIdByEmployeeId(employeeId);

		assertNotNull(find);

		Employee employee = find.run();
		assertNotNull(employee);
		assertEquals(0, employee.getId().intValue());
		assertEquals(managerId, employee.getManagerId().intValue());
	}

	/**
	 * Method to test find manager of employee by using interface of
	 * EmployeeOperation.
	 */
	@Test
	public void runTestForInstantiateByEmployeeInterface() {
		EmployeeOperation find = new FindManagerIdByEmployeeId(employeeId);

		assertNotNull(find);

		Employee employee = find.run();
		System.out.println(employee.toString());
		assertNotNull(employee);
		assertEquals(0, employee.getId().intValue());
		assertEquals(managerId, employee.getManagerId().intValue());
	}

	/**
	 * Method to test find manager of employee by using main interface.
	 */
	@Test
	public void runTestForInstantiateByMainInterface() {
		HibernateOperation<Employee> find = new FindManagerIdByEmployeeId(employeeId);

		assertNotNull(find);

		Employee employee = find.run();
		assertNotNull(employee);
		assertEquals(0, employee.getId().intValue());
		assertEquals(managerId, employee.getManagerId().intValue());
	}

}
