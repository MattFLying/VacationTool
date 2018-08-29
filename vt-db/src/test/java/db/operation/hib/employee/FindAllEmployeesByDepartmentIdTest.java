package db.operation.hib.employee;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import db.entity.Employee;
import db.operation.hib.EmployeeListOperation;
import db.operation.hib.HibernateOperation;

/**
 * Class to test finding employees by department id.
 * 
 * @author Mateusz Mucha
 *
 */
public class FindAllEmployeesByDepartmentIdTest {
	private final int departmentId = 1;

	/**
	 * Method to test find employees list for specific department by creating
	 * instance of class object.
	 */
	@Test
	public void runTestForInstantiateObject() {
		FindAllEmployeesByDepartmentId find = new FindAllEmployeesByDepartmentId(departmentId);

		assertNotNull(find);

		List<Employee> list = find.run().stream().collect(Collectors.toList());
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	/**
	 * Method to test find employees list for specific department by using
	 * interface of EmployeeListOperation.
	 */
	@Test
	public void runTestForInstantiateByEmployeeInterface() {
		EmployeeListOperation find = new FindAllEmployeesByDepartmentId(departmentId);

		assertNotNull(find);

		List<Employee> list = find.run().stream().collect(Collectors.toList());
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	/**
	 * Method to test find employees list for specific department by using main
	 * interface.
	 */
	@Test
	public void runTestForInstantiateByMainInterface() {
		HibernateOperation<Collection<Employee>> find = new FindAllEmployeesByDepartmentId(departmentId);

		assertNotNull(find);

		List<Employee> list = find.run().stream().collect(Collectors.toList());
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

}
