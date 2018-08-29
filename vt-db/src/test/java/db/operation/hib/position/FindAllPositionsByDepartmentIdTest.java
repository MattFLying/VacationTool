package db.operation.hib.position;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import db.entity.Position;
import db.operation.hib.HibernateOperation;
import db.operation.hib.PositionListOperation;

/**
 * Class to test finding position list.
 * 
 * @author Mateusz Mucha
 *
 */
public class FindAllPositionsByDepartmentIdTest {
	private final int departmentId = 1;

	/**
	 * Method to test find position list for specific department by creating
	 * instance of class object.
	 */
	@Test
	public void runTestForInstantiateObject() {
		FindAllPositionsByDepartmentId find = new FindAllPositionsByDepartmentId(departmentId);

		assertNotNull(find);

		List<Position> list = find.run().stream().collect(Collectors.toList());
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	/**
	 * Method to test find position list for specific department by using
	 * interface of PositionListOperation.
	 */
	@Test
	public void runTestForInstantiateByPositionInterface() {
		PositionListOperation find = new FindAllPositionsByDepartmentId(departmentId);

		assertNotNull(find);

		List<Position> list = find.run().stream().collect(Collectors.toList());
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	/**
	 * Method to test find position list for specific department by using main
	 * interface.
	 */
	@Test
	public void runTestForInstantiateByMainInterface() {
		HibernateOperation<Collection<Position>> find = new FindAllPositionsByDepartmentId(departmentId);

		assertNotNull(find);

		List<Position> list = find.run().stream().collect(Collectors.toList());
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}
}
