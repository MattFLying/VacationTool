package db.operation.hib.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import db.entity.Department;
import db.operation.DatabaseOperations;
import db.operation.DepartmentManagement;

/**
 * Class to test functionality of DepartmentDao.
 * 
 * @author Mateusz Mucha
 *
 */
public class DepartmentDaoTest {
	private DepartmentDao dao;
	private DepartmentManagement management;
	private DatabaseOperations<Department> databaseOperations;
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
		this.dao = new DepartmentDao();
		this.management = new DepartmentDao();
		this.databaseOperations = new DepartmentDao();
	}

	/**
	 * Method to test saving entity to database by using 3 possible ways.
	 */
	@Test
	public void saveTest() {
		Department test = new Department();
		test.setDepartmentName(testString_1);

		Department test_1 = dao.save(test);
		assertEquals(testString_1, test.getDepartmentName());
		assertEquals(testString_1, dao.findById(test_1.getId()).get().getDepartmentName());

		test.setDepartmentName(testString_2);
		Department test_2 = management.save(test);
		assertEquals(testString_2, test_2.getDepartmentName());
		assertEquals(testString_2, dao.findById(test_2.getId()).get().getDepartmentName());

		test.setDepartmentName(testString_3);
		Department test_3 = databaseOperations.save(test);
		assertEquals(testString_3, test_3.getDepartmentName());
		assertEquals(testString_3, dao.findById(test_3.getId()).get().getDepartmentName());
	}

	/**
	 * Method to test updating entity to database by using 3 possible ways.
	 */
	@Test
	public void updateTest() {
		Department test = new Department();
		test.setDepartmentName(testString_1);

		Department test_1 = dao.save(test);
		assertEquals(testString_1, dao.findById(test_1.getId()).get().getDepartmentName());
		test_1.setDepartmentName(testString_2);

		Department test_2 = dao.save(test_1);
		assertEquals(testString_2, dao.findById(test_2.getId()).get().getDepartmentName());

		test = new Department();
		test.setDepartmentName(testString_1);

		test_1 = management.save(test);
		assertEquals(testString_1, management.findById(test_1.getId()).get().getDepartmentName());
		test_1.setDepartmentName(testString_2);

		test_2 = management.save(test_1);
		assertEquals(testString_2, management.findById(test_2.getId()).get().getDepartmentName());

		test = new Department();
		test.setDepartmentName(testString_1);

		test_1 = databaseOperations.save(test);
		assertEquals(testString_1, databaseOperations.findById(test_1.getId()).get().getDepartmentName());
		test_1.setDepartmentName(testString_2);

		test_2 = databaseOperations.save(test_1);
		assertEquals(testString_2, databaseOperations.findById(test_2.getId()).get().getDepartmentName());
	}

	/**
	 * Method to test delete entity to database by using 3 possible ways.
	 */
	@Test
	public void deleteTest() {
		Department test = dao.findById(idToTest).get();
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
		Department test = dao.findById(idToTest).get();
		assertNotNull(test);
		assertNotNull(test.getDepartmentName());

		test = management.findById(idToTest).get();
		assertNotNull(test);
		assertNotNull(test.getDepartmentName());

		test = databaseOperations.findById(idToTest).get();
		assertNotNull(test);
		assertNotNull(test.getDepartmentName());
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
		Iterable<Department> iterator_1 = dao.findAll();
		assertNotNull(iterator_1);

		Iterable<Department> iterator_2 = management.findAll();
		assertNotNull(iterator_2);

		Iterable<Department> iterator_3 = databaseOperations.findAll();
		assertNotNull(iterator_3);
	}
}
