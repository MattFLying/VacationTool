package db.util;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

/**
 * Class to test HibernateUtil for database connections of hibernate.
 * 
 * @author Mateusz Mucha
 *
 */
public class HibernateUtilTest {
	private Session session = null;

	/**
	 * Method to test creating session factory.
	 */
	@Test
	public void getSessionFactoryTest() {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		assertNotEquals(null, factory);
		assertEquals(false, factory.isClosed());
		assertEquals(true, factory.isOpen());
	}

	/**
	 * Method to test opening hibernate session.
	 */
	@Test
	public void openingSessionTest() {
		session = HibernateUtil.getSessionFactory().openSession();

		assertEquals(true, session.isOpen());
		assertEquals(true, session.isConnected());
	}

	/**
	 * Method to test closing session factory.
	 */
	@Test
	public void closeSessionFactoryTest() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		factory.close();

		assertNotEquals(null, factory);
		assertEquals(true, factory.isClosed());
		assertEquals(false, factory.isOpen());
	}

	/**
	 * Method to test closing hibernate session.
	 */
	@Test
	public void closeSessionTest() {
		session = HibernateUtil.getSessionFactory().openSession();
		session.close();
		assertEquals(false, session.isOpen());
		assertEquals(false, session.isConnected());
	}

}
