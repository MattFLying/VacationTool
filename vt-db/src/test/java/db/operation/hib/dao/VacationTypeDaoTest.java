package db.operation.hib.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import db.entity.VacationType;
import db.operation.DatabaseOperations;
import db.operation.VacationTypeManagement;

/**
 * Class to test functionality of VacationTypeDao.
 * 
 * @author Mateusz Mucha
 *
 */
public class VacationTypeDaoTest {
	private VacationTypeDao dao;
	private VacationTypeManagement management;
	private DatabaseOperations<VacationType> databaseOperations;
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
		this.dao = new VacationTypeDao();
		this.management = new VacationTypeDao();
		this.databaseOperations = new VacationTypeDao();
	}

	/**
	 * Method to test saving entity to database by using 3 possible ways.
	 */
	@Test
	public void saveTest() {
		VacationType test = new VacationType();
		test.setVacationTypeName(testString_1);

		VacationType test_1 = dao.save(test);
		assertEquals(testString_1, test.getVacationTypeName());
		assertEquals(testString_1, dao.findById(test_1.getId()).get().getVacationTypeName());

		test.setVacationTypeName(testString_2);
		VacationType test_2 = management.save(test);
		assertEquals(testString_2, test_2.getVacationTypeName());
		assertEquals(testString_2, dao.findById(test_2.getId()).get().getVacationTypeName());

		test.setVacationTypeName(testString_3);
		VacationType test_3 = databaseOperations.save(test);
		assertEquals(testString_3, test_3.getVacationTypeName());
		assertEquals(testString_3, dao.findById(test_3.getId()).get().getVacationTypeName());
	}

	/**
	 * Method to test updating entity to database by using 3 possible ways.
	 */
	@Test
	public void updateTest() {
		VacationType test = new VacationType();
		test.setVacationTypeName(testString_1);

		VacationType test_1 = dao.save(test);
		assertEquals(testString_1, dao.findById(test_1.getId()).get().getVacationTypeName());
		test_1.setVacationTypeName(testString_2);

		VacationType test_2 = dao.save(test_1);
		assertEquals(testString_2, dao.findById(test_2.getId()).get().getVacationTypeName());

		test = new VacationType();
		test.setVacationTypeName(testString_1);

		test_1 = management.save(test);
		assertEquals(testString_1, management.findById(test_1.getId()).get().getVacationTypeName());
		test_1.setVacationTypeName(testString_2);

		test_2 = management.save(test_1);
		assertEquals(testString_2, management.findById(test_2.getId()).get().getVacationTypeName());

		test = new VacationType();
		test.setVacationTypeName(testString_1);

		test_1 = databaseOperations.save(test);
		assertEquals(testString_1, databaseOperations.findById(test_1.getId()).get().getVacationTypeName());
		test_1.setVacationTypeName(testString_2);

		test_2 = databaseOperations.save(test_1);
		assertEquals(testString_2, databaseOperations.findById(test_2.getId()).get().getVacationTypeName());
	}

	/**
	 * Method to test delete entity to database by using 3 possible ways.
	 */
	@Test
	public void deleteTest() {
		VacationType test = dao.findById(idToTest).get();
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
		VacationType test = dao.findById(idToTest).get();
		assertNotNull(test);
		assertNotNull(test.getVacationTypeMaxDays());
		assertNotNull(test.getVacationTypeName());

		test = management.findById(idToTest).get();
		assertNotNull(test);
		assertNotNull(test.getVacationTypeMaxDays());
		assertNotNull(test.getVacationTypeName());

		test = databaseOperations.findById(idToTest).get();
		assertNotNull(test);
		assertNotNull(test.getVacationTypeMaxDays());
		assertNotNull(test.getVacationTypeName());
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
		Iterable<VacationType> iterator_1 = dao.findAll();
		assertNotNull(iterator_1);

		Iterable<VacationType> iterator_2 = management.findAll();
		assertNotNull(iterator_2);

		Iterable<VacationType> iterator_3 = databaseOperations.findAll();
		assertNotNull(iterator_3);
	}
}
