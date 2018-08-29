package db.operation.hib.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import db.entity.Position;
import db.operation.DatabaseOperations;
import db.operation.PositionManagement;
import db.operation.repository.hib.PositionDao;

/**
 * Class to test functionality of PositionDao.
 * 
 * @author Mateusz Mucha
 *
 */
public class PositionDaoTest {
	private PositionDao dao;
	private PositionManagement management;
	private DatabaseOperations<Position> databaseOperations;
	private final String testString_1 = "TEST_1";
	private final String testString_2 = "TEST_2";
	private final String testString_3 = "TEST_3";
	private final int idToTest = 1;

	/**
	 * Method set up three possible ways to run operations on database by
	 * hibvernate of DAO type.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.dao = new PositionDao();
		this.management = new PositionDao();
		this.databaseOperations = new PositionDao();
	}

	/**
	 * Method to test saving entity to database by using 3 possible ways.
	 */
	@Test
	public void saveTest() {
		Position test = new Position();
		test.setPositionName(testString_1);

		Position test_1 = dao.save(test);
		assertEquals(testString_1, test.getPositionName());
		assertEquals(testString_1, dao.findById(test_1.getId()).get().getPositionName());

		test.setPositionName(testString_2);
		Position test_2 = management.save(test);
		assertEquals(testString_2, test_2.getPositionName());
		assertEquals(testString_2, dao.findById(test_2.getId()).get().getPositionName());

		test.setPositionName(testString_3);
		Position test_3 = databaseOperations.save(test);
		assertEquals(testString_3, test_3.getPositionName());
		assertEquals(testString_3, dao.findById(test_3.getId()).get().getPositionName());
	}

	/**
	 * Method to test updating entity to database by using 3 possible ways.
	 */
	@Test
	public void updateTest() {
		Position test = new Position();
		test.setPositionName(testString_1);

		Position test_1 = dao.save(test);
		assertEquals(testString_1, dao.findById(test_1.getId()).get().getPositionName());
		test_1.setPositionName(testString_2);

		Position test_2 = dao.save(test_1);
		assertEquals(testString_2, dao.findById(test_2.getId()).get().getPositionName());

		test = new Position();
		test.setPositionName(testString_1);

		test_1 = management.save(test);
		assertEquals(testString_1, management.findById(test_1.getId()).get().getPositionName());
		test_1.setPositionName(testString_2);

		test_2 = management.save(test_1);
		assertEquals(testString_2, management.findById(test_2.getId()).get().getPositionName());

		test = new Position();
		test.setPositionName(testString_1);

		test_1 = databaseOperations.save(test);
		assertEquals(testString_1, databaseOperations.findById(test_1.getId()).get().getPositionName());
		test_1.setPositionName(testString_2);

		test_2 = databaseOperations.save(test_1);
		assertEquals(testString_2, databaseOperations.findById(test_2.getId()).get().getPositionName());
	}

	/**
	 * Method to test delete entity to database by using 3 possible ways.
	 */
	@Test
	public void deleteTest() {
		Position test = dao.findById(idToTest).get();
		dao.delete(test);
		assertNull(dao.findById(idToTest).get());

		test = management.findById(idToTest).get();
		management.delete(test);
		assertNull(management.findById(idToTest).get());

		test = databaseOperations.findById(idToTest).get();
		databaseOperations.delete(test);
		assertNull(databaseOperations.findById(idToTest).get());
	}

	/**
	 * Method to test finding by identificator entity to database by using 3
	 * possible ways.
	 */
	@Test
	public void findByIdTest() {
		Position test = dao.findById(idToTest).get();
		assertNotNull(test);
		assertNotNull(test.getPositionName());
		assertNotNull(test.getDepartmentId());

		test = management.findById(idToTest).get();
		assertNotNull(test);
		assertNotNull(test.getPositionName());
		assertNotNull(test.getDepartmentId());

		test = databaseOperations.findById(idToTest).get();
		assertNotNull(test);
		assertNotNull(test.getPositionName());
		assertNotNull(test.getDepartmentId());
	}

	/**
	 * Method to test if entity exist in database entity to database by using 3
	 * possible ways.
	 */
	@Test
	public void existsByIdTest() {
		assertTrue(dao.existsById(idToTest));
		assertTrue(management.existsById(idToTest));
		assertTrue(databaseOperations.existsById(idToTest));
	}

	/**
	 * Method to test finding all entities from database by using 3 possible
	 * ways.
	 */
	@Test
	public void findAllTest() {
		Iterable<Position> iterator_1 = dao.findAll();
		assertNotNull(iterator_1);

		Iterable<Position> iterator_2 = management.findAll();
		assertNotNull(iterator_2);

		Iterable<Position> iterator_3 = databaseOperations.findAll();
		assertNotNull(iterator_3);
	}

	/**
	 * Method to find all positions for specific department.
	 */
	@Test
	public void findAllByDepartmentIdTest() {
		List<Position> list_1 = dao.findAllByDepartmentId(idToTest).stream().collect(Collectors.toList());
		assertNotNull(list_1);

		List<Position> list_2 = management.findAllByDepartmentId(idToTest).stream().collect(Collectors.toList());
		assertNotNull(list_2);
	}
}
