package db.operation.hib.employee;

import static org.junit.Assert.*;

import org.junit.Test;

import db.entity.Employee;
import db.operation.hib.EmployeeOperation;
import db.operation.hib.HibernateOperation;

/**
 * Class to test changing password.
 * 
 * @author Mateusz Mucha
 *
 */
public class ChangeEmployeePasswordTest {
	private final int employeeId = 14;
	private final String password = "testPassword_2";
	private final String evidenceNumberToCheckIfPasswordIsChanged = "H014";

	/**
	 * Method to test change password of employee by creating instance of class
	 * object.
	 */
	@Test
	public void runTestForInstantiateObject() {
		ChangeEmployeePassword find = new ChangeEmployeePassword(employeeId, password);

		assertNotNull(find);

		Employee employee = find.run();
		assertNotNull(employee);
		assertEquals(employeeId, employee.getId().intValue());

		FindEmployeeByEvidenceNumber findToCheck = new FindEmployeeByEvidenceNumber(
				evidenceNumberToCheckIfPasswordIsChanged);
		Employee employee_check = findToCheck.run();
		assertNotNull(employee_check);
		assertEquals(employeeId, employee_check.getId().intValue());
		assertEquals(evidenceNumberToCheckIfPasswordIsChanged, employee_check.getEvidenceNumber());
		assertEquals(password, employee_check.getPassword());
	}

	/**
	 * Method to test change password of employee by using interface of
	 * EmployeeOperation.
	 */
	@Test
	public void runTestForInstantiateByEmployeeInterface() {
		EmployeeOperation find = new ChangeEmployeePassword(employeeId, password);

		assertNotNull(find);

		Employee employee = find.run();
		assertNotNull(employee);
		assertEquals(employeeId, employee.getId().intValue());

		FindEmployeeByEvidenceNumber findToCheck = new FindEmployeeByEvidenceNumber(
				evidenceNumberToCheckIfPasswordIsChanged);
		Employee employee_check = findToCheck.run();
		assertNotNull(employee_check);
		assertEquals(employeeId, employee_check.getId().intValue());
		assertEquals(evidenceNumberToCheckIfPasswordIsChanged, employee_check.getEvidenceNumber());
		assertEquals(password, employee_check.getPassword());
	}

	/**
	 * Method to test change password of employee by using main interface.
	 */
	@Test
	public void runTestForInstantiateByMainInterface() {
		HibernateOperation<Employee> find = new ChangeEmployeePassword(employeeId, password);

		assertNotNull(find);

		Employee employee = find.run();
		assertNotNull(employee);
		assertEquals(employeeId, employee.getId().intValue());

		FindEmployeeByEvidenceNumber findToCheck = new FindEmployeeByEvidenceNumber(
				evidenceNumberToCheckIfPasswordIsChanged);
		Employee employee_check = findToCheck.run();
		assertNotNull(employee_check);
		assertEquals(employeeId, employee_check.getId().intValue());
		assertEquals(evidenceNumberToCheckIfPasswordIsChanged, employee_check.getEvidenceNumber());
		assertEquals(password, employee_check.getPassword());
	}

}
