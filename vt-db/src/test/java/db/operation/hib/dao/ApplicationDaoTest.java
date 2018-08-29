package db.operation.hib.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import db.entity.Application;
import db.operation.ApplicationManagement;
import db.operation.DatabaseOperations;
import db.operation.repository.hib.ApplicationDao;

/**
 * Class to test functionality of ApplicationDao.
 * 
 * @author Mateusz Mucha
 *
 */
public class ApplicationDaoTest {
	private ApplicationDao dao;
	private ApplicationManagement management;
	private DatabaseOperations<Application> databaseOperations;
	private final String testString_1 = "TEST_1";
	private final String testString_2 = "TEST_2";
	private final String testString_3 = "TEST_3";
	private final int idToTest = 1;
	private final int managerId = 4;

	/**
	 * Method set up three possible ways to run operations on database by
	 * hibvernate of DAO type.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.dao = new ApplicationDao();
		this.management = new ApplicationDao();
		this.databaseOperations = new ApplicationDao();
	}

	/**
	 * Method to test saving entity to database by using 3 possible ways.
	 */
	@Test
	public void saveTest() {
		Application test = new Application();
		test.setStatus(testString_1);

		Application test_1 = dao.save(test);
		assertEquals(testString_1, test.getStatus());
		assertEquals(testString_1, dao.findById(test_1.getId()).get().getStatus());

		test.setStatus(testString_2);
		Application test_2 = management.save(test);
		assertEquals(testString_2, test_2.getStatus());
		assertEquals(testString_2, dao.findById(test_2.getId()).get().getStatus());

		test.setStatus(testString_3);
		Application test_3 = databaseOperations.save(test);
		assertEquals(testString_3, test_3.getStatus());
		assertEquals(testString_3, dao.findById(test_3.getId()).get().getStatus());
	}

	/**
	 * Method to test updating entity to database by using 3 possible ways.
	 */
	@Test
	public void updateTest() {
		Application test = new Application();
		test.setStatus(testString_1);

		Application test_1 = dao.save(test);
		assertEquals(testString_1, dao.findById(test_1.getId()).get().getStatus());
		test_1.setStatus(testString_2);

		Application test_2 = dao.save(test_1);
		assertEquals(testString_2, dao.findById(test_2.getId()).get().getStatus());

		test = new Application();
		test.setStatus(testString_1);

		test_1 = management.save(test);
		assertEquals(testString_1, management.findById(test_1.getId()).get().getStatus());
		test_1.setStatus(testString_2);

		test_2 = management.save(test_1);
		assertEquals(testString_2, management.findById(test_2.getId()).get().getStatus());

		test = new Application();
		test.setStatus(testString_1);

		test_1 = databaseOperations.save(test);
		assertEquals(testString_1, databaseOperations.findById(test_1.getId()).get().getStatus());
		test_1.setStatus(testString_2);

		test_2 = databaseOperations.save(test_1);
		assertEquals(testString_2, databaseOperations.findById(test_2.getId()).get().getStatus());
	}

	/**
	 * Method to test delete entity to database by using 3 possible ways.
	 */
	@Test
	public void deleteTest() {
		Application test = dao.findById(idToTest).get();
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
		Application test = dao.findById(idToTest).get();
		assertNotNull(test);
		assertNotNull(test.getEmployeeId());
		assertNotNull(test.getManagerId());
		assertNotNull(test.getStatus());

		test = management.findById(idToTest).get();
		assertNotNull(test);
		assertNotNull(test.getEmployeeId());
		assertNotNull(test.getManagerId());
		assertNotNull(test.getStatus());

		test = databaseOperations.findById(idToTest).get();
		assertNotNull(test);
		assertNotNull(test.getEmployeeId());
		assertNotNull(test.getManagerId());
		assertNotNull(test.getStatus());
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
		Iterable<Application> iterator_1 = dao.findAll();
		assertNotNull(iterator_1);

		Iterable<Application> iterator_2 = management.findAll();
		assertNotNull(iterator_2);

		Iterable<Application> iterator_3 = databaseOperations.findAll();
		assertNotNull(iterator_3);
	}

	/**
	 * Method to test finding all applications sorted by created date and
	 * status.
	 */
	@Test
	public void findAllByOrderByStatusDescCreatedDateDescTest() {
		List<Application> list_1 = dao.findAllByOrderByStatusDescCreatedDateDesc().stream()
				.collect(Collectors.toList());
		assertNotNull(list_1);

		List<Application> list_2 = management.findAllByOrderByStatusDescCreatedDateDesc().stream()
				.collect(Collectors.toList());
		assertNotNull(list_2);
	}

	/**
	 * Method to test finding all applications for specific manager sorted by
	 * created date and status.
	 */
	@Test
	public void findAllByManagerIdOrderByStatusDescCreatedDateDescTest() {
		List<Application> list_1 = dao.findAllByManagerIdOrderByStatusDescCreatedDateDesc(managerId).stream()
				.collect(Collectors.toList());
		assertNotNull(list_1);

		List<Application> list_2 = management.findAllByManagerIdOrderByStatusDescCreatedDateDesc(managerId).stream()
				.collect(Collectors.toList());
		assertNotNull(list_2);
	}

	/**
	 * Method to test finding all applications for specific employee sorted by
	 * created date and status.
	 */
	@Test
	public void findAllByEmployeeIdOrderByStatusDescCreatedDateDescTest() {
		List<Application> list_1 = dao.findAllByEmployeeIdOrderByStatusDescCreatedDateDesc(idToTest).stream()
				.collect(Collectors.toList());
		assertNotNull(list_1);

		List<Application> list_2 = management.findAllByEmployeeIdOrderByStatusDescCreatedDateDesc(idToTest).stream()
				.collect(Collectors.toList());
		assertNotNull(list_2);
	}

}