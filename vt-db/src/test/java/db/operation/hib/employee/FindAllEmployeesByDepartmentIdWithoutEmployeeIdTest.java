package db.operation.hib.employee;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import db.entity.Employee;
import db.operation.hib.EmployeeListOperation;
import db.operation.hib.HibernateOperation;

/**
 * Class to test finding employees without one of them(e.g. is a manager) by
 * department id.
 * 
 * @author Mateusz Mucha
 *
 */
public class FindAllEmployeesByDepartmentIdWithoutEmployeeIdTest {
	private final int departmentId = 1;
	private final int employeeId = 1;

	/**
	 * Method to test find employees list without one of them for specific
	 * department by creating instance of class object.
	 */
	@Test
	public void runTestForInstantiateObject() {
		FindAllEmployeesByDepartmentIdWithoutEmployeeId find = new FindAllEmployeesByDepartmentIdWithoutEmployeeId(
				departmentId, employeeId);

		assertNotNull(find);

		List<Employee> list = find.run();
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	/**
	 * Method to test find employees list without one of them for specific
	 * department by using interface of EmployeeListOperation.
	 */
	@Test
	public void runTestForInstantiateByEmployeeInterface() {
		EmployeeListOperation find = new FindAllEmployeesByDepartmentIdWithoutEmployeeId(departmentId, employeeId);

		assertNotNull(find);

		List<Employee> list = find.run();
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	/**
	 * Method to test find employees list without one of them for specific
	 * department by using main interface.
	 */
	@Test
	public void runTestForInstantiateByMainInterface() {
		HibernateOperation<List<Employee>> find = new FindAllEmployeesByDepartmentIdWithoutEmployeeId(departmentId,
				employeeId);

		assertNotNull(find);

		List<Employee> list = find.run();
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

}
