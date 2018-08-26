package db.operation.hib.employee;

import static org.junit.Assert.*;

import org.junit.Test;

import db.entity.Employee;
import db.operation.hib.EmployeeOperation;
import db.operation.hib.HibernateOperation;

/**
 * Class to test finding department of employee.
 * 
 * @author Mateusz Mucha
 *
 */
public class FindDepartmentIdByEmployeeIdTest {
	private final int employeeId = 1;
	private final int departmentId = 1;

	/**
	 * Method to test find department of employee by creating instance of class
	 * object.
	 */
	@Test
	public void runTestForInstantiateObject() {
		FindDepartmentIdByEmployeeId find = new FindDepartmentIdByEmployeeId(employeeId);

		assertNotNull(find);

		Employee employee = find.run();
		assertNotNull(employee);
		assertEquals(0, employee.getId().intValue());
		assertEquals(departmentId, employee.getDepartmentId().intValue());
	}

	/**
	 * Method to test find department of employee by using interface of
	 * EmployeeOperation.
	 */
	@Test
	public void runTestForInstantiateByEmployeeInterface() {
		EmployeeOperation find = new FindDepartmentIdByEmployeeId(employeeId);

		assertNotNull(find);

		Employee employee = find.run();
		assertNotNull(employee);
		assertEquals(0, employee.getId().intValue());
		assertEquals(departmentId, employee.getDepartmentId().intValue());
	}

	/**
	 * Method to test find department of employee by using main interface.
	 */
	@Test
	public void runTestForInstantiateByMainInterface() {
		HibernateOperation<Employee> find = new FindDepartmentIdByEmployeeId(employeeId);

		assertNotNull(find);

		Employee employee = find.run();
		assertNotNull(employee);
		assertEquals(0, employee.getId().intValue());
		assertEquals(departmentId, employee.getDepartmentId().intValue());
	}

}
