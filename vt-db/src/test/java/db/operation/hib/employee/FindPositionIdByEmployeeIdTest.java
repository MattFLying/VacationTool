package db.operation.hib.employee;

import static org.junit.Assert.*;

import org.junit.Test;

import db.entity.Employee;
import db.operation.hib.EmployeeOperation;
import db.operation.hib.HibernateOperation;

/**
 * Class to test finding position of employee.
 * 
 * @author Mateusz Mucha
 *
 */
public class FindPositionIdByEmployeeIdTest {
	private final int employeeId = 1;
	private final int position = 2;

	/**
	 * Method to test find position of employee by creating instance of class
	 * object.
	 */
	@Test
	public void runTestForInstantiateObject() {
		FindPositionIdByEmployeeId find = new FindPositionIdByEmployeeId(employeeId);

		assertNotNull(find);

		Employee employee = find.run();
		assertNotNull(employee);
		assertEquals(0, employee.getId().intValue());
		assertEquals(position, employee.getPositionId().intValue());
	}

	/**
	 * Method to test find position of employee by using interface of
	 * EmployeeOperation.
	 */
	@Test
	public void runTestForInstantiateByEmployeeInterface() {
		EmployeeOperation find = new FindPositionIdByEmployeeId(employeeId);

		assertNotNull(find);

		Employee employee = find.run();
		System.out.println(employee.toString());
		assertNotNull(employee);
		assertEquals(0, employee.getId().intValue());
		assertEquals(position, employee.getPositionId().intValue());
	}

	/**
	 * Method to test find position of employee by using main interface.
	 */
	@Test
	public void runTestForInstantiateByMainInterface() {
		HibernateOperation<Employee> find = new FindPositionIdByEmployeeId(employeeId);

		assertNotNull(find);

		Employee employee = find.run();
		assertNotNull(employee);
		assertEquals(0, employee.getId().intValue());
		assertEquals(position, employee.getPositionId().intValue());
	}

}
