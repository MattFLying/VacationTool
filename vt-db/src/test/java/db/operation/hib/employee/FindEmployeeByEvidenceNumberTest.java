package db.operation.hib.employee;

import static org.junit.Assert.*;

import org.junit.Test;

import db.entity.Employee;
import db.operation.hib.EmployeeOperation;
import db.operation.hib.HibernateOperation;

/**
 * Class to test finding employee by evidence number
 * 
 * @author Mateusz Mucha
 *
 */
public class FindEmployeeByEvidenceNumberTest {
	private final String evidenceNumber = "I001";
	private final int employeeId = 1;

	/**
	 * Method to test find employee by evidence number by creating instance of
	 * class object.
	 */
	@Test
	public void runTestForInstantiateObject() {
		FindEmployeeByEvidenceNumber find = new FindEmployeeByEvidenceNumber(evidenceNumber);

		assertNotNull(find);

		Employee employee = find.run();
		assertNotNull(employee);
		assertEquals(employeeId, employee.getId().intValue());
		assertEquals(evidenceNumber, employee.getEvidenceNumber());
		assertEquals("Mateusz", employee.getFirstName());
		assertEquals("Mucha", employee.getLastName());
	}

	/**
	 * Method to test find employee by evidence number by using interface of
	 * EmployeeOperation.
	 */
	@Test
	public void runTestForInstantiateByEmployeeInterface() {
		EmployeeOperation find = new FindEmployeeByEvidenceNumber(evidenceNumber);

		assertNotNull(find);

		Employee employee = find.run();
		assertNotNull(employee);
		assertEquals(employeeId, employee.getId().intValue());
		assertEquals(evidenceNumber, employee.getEvidenceNumber());
		assertEquals("Mateusz", employee.getFirstName());
		assertEquals("Mucha", employee.getLastName());
	}

	/**
	 * Method to test find employee by evidence number by using main interface.
	 */
	@Test
	public void runTestForInstantiateByMainInterface() {
		HibernateOperation<Employee> find = new FindEmployeeByEvidenceNumber(evidenceNumber);

		assertNotNull(find);

		Employee employee = find.run();
		assertNotNull(employee);
		assertEquals(employeeId, employee.getId().intValue());
		assertEquals(evidenceNumber, employee.getEvidenceNumber());
		assertEquals("Mateusz", employee.getFirstName());
		assertEquals("Mucha", employee.getLastName());
	}

}
