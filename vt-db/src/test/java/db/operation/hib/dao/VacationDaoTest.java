package db.operation.hib.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import db.entity.Vacation;
import db.operation.DatabaseOperations;
import db.operation.VacationManagement;
import db.operation.repository.hib.VacationDao;

/**
 * Class to test functionality of VacationDao.
 * 
 * @author Mateusz Mucha
 *
 */
public class VacationDaoTest {
	private VacationDao dao;
	private VacationManagement management;
	private DatabaseOperations<Vacation> databaseOperations;
	private final int testInt_1 = 50;
	private final int testInt_2 = 60;
	private final int testInt_3 = 70;
	private final int idToTest = 1;
	private final int vacationTypeId = 2;

	/**
	 * Method set up three possible ways to run operations on database by
	 * hibvernate of DAO type.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.dao = new VacationDao();
		this.management = new VacationDao();
		this.databaseOperations = new VacationDao();
	}

	/**
	 * Method to test saving entity to database by using 3 possible ways.
	 */
	@Test
	public void saveTest() {
		Vacation test = new Vacation();
		test.setVacationYear(testInt_1);

		Vacation test_1 = dao.save(test);
		assertEquals(testInt_1, test.getVacationYear().intValue());
		assertEquals(testInt_1, dao.findById(test_1.getId()).get().getVacationYear().intValue());

		test.setVacationYear(testInt_2);
		Vacation test_2 = management.save(test);
		assertEquals(testInt_2, test_2.getVacationYear().intValue());
		assertEquals(testInt_2, dao.findById(test_2.getId()).get().getVacationYear().intValue());

		test.setVacationYear(testInt_3);
		Vacation test_3 = databaseOperations.save(test);
		assertEquals(testInt_3, test_3.getVacationYear().intValue());
		assertEquals(testInt_3, dao.findById(test_3.getId()).get().getVacationYear().intValue());
	}

	/**
	 * Method to test updating entity to database by using 3 possible ways.
	 */
	@Test
	public void updateTest() {
		Vacation test = new Vacation();
		test.setVacationYear(testInt_1);

		Vacation test_1 = dao.save(test);
		assertEquals(testInt_1, dao.findById(test_1.getId()).get().getVacationYear().intValue());
		test_1.setVacationYear(testInt_2);

		Vacation test_2 = dao.save(test_1);
		assertEquals(testInt_2, dao.findById(test_2.getId()).get().getVacationYear().intValue());

		test = new Vacation();
		test.setVacationYear(testInt_1);

		test_1 = management.save(test);
		assertEquals(testInt_1, management.findById(test_1.getId()).get().getVacationYear().intValue());
		test_1.setVacationYear(testInt_2);

		test_2 = management.save(test_1);
		assertEquals(testInt_2, management.findById(test_2.getId()).get().getVacationYear().intValue());

		test = new Vacation();
		test.setVacationYear(testInt_1);

		test_1 = databaseOperations.save(test);
		assertEquals(testInt_1, databaseOperations.findById(test_1.getId()).get().getVacationYear().intValue());
		test_1.setVacationYear(testInt_2);

		test_2 = databaseOperations.save(test_1);
		assertEquals(testInt_2, databaseOperations.findById(test_2.getId()).get().getVacationYear().intValue());
	}

	/**
	 * Method to test delete entity to database by using 3 possible ways.
	 */
	@Test
	public void deleteTest() {
		Vacation test = dao.findById(idToTest).get();
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
		Vacation test = dao.findById(idToTest).get();
		assertNotNull(test);
		assertNotNull(test.getEmployeeId());
		assertNotNull(test.getVacationYear().intValue());
		assertNotNull(test.getVacationDaysLeft());
		assertNotNull(test.getVacationType());

		test = management.findById(idToTest).get();
		assertNotNull(test);
		assertNotNull(test.getEmployeeId());
		assertNotNull(test.getVacationYear().intValue());
		assertNotNull(test.getVacationDaysLeft());
		assertNotNull(test.getVacationType());

		test = databaseOperations.findById(idToTest).get();
		assertNotNull(test);
		assertNotNull(test.getEmployeeId());
		assertNotNull(test.getVacationYear().intValue());
		assertNotNull(test.getVacationDaysLeft());
		assertNotNull(test.getVacationType());
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
		Iterable<Vacation> iterator_1 = dao.findAll();
		assertNotNull(iterator_1);

		Iterable<Vacation> iterator_2 = management.findAll();
		assertNotNull(iterator_2);

		Iterable<Vacation> iterator_3 = databaseOperations.findAll();
		assertNotNull(iterator_3);
	}

	/**
	 * Method to find all vacatioons for employee.
	 */
	@Test
	public void findAllByEmployeeIdTest() {
		List<Vacation> list1 = dao.findAllByEmployeeId(idToTest).stream().collect(Collectors.toList());
		assertNotNull(list1);

		List<Vacation> list2 = management.findAllByEmployeeId(idToTest).stream().collect(Collectors.toList());
		assertNotNull(list2);
	}

	/**
	 * Method to find all vacation for employee by specific type of vacation.
	 */
	@Test
	public void findAllByEmployeeIdAndVacationTypeTest() {
		List<Vacation> list = dao.findAllByEmployeeIdAndVacationType(idToTest, vacationTypeId).stream()
				.collect(Collectors.toList());
		assertNotNull(list);

		List<Vacation> list2 = management.findAllByEmployeeIdAndVacationType(idToTest, vacationTypeId).stream()
				.collect(Collectors.toList());
		assertNotNull(list2);
	}

}
