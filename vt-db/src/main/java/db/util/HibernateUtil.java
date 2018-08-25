package db.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Class for obtaining the hibernate session.
 * 
 * @author Mateusz Mucha
 *
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory = null;

	/**
	 * Method to get session factory.
	 * 
	 * @return session factory
	 */
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}

	/**
	 * Method to set session factory
	 * 
	 * @param sessionFactory
	 *            session factory
	 */
	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}

	/**
	 * Method which close the session factory
	 */
	public static void closeSessionFactory() {
		sessionFactory.close();
	}
}