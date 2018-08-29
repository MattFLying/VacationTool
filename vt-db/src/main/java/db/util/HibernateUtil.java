package db.util;

import java.util.Optional;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Class for obtaining the hibernate session.
 * 
 * @author Mateusz Mucha
 *
 */
public final class HibernateUtil {
	private static SessionFactory sessionFactory = null;

	/**
	 * Method to get session factory.
	 * 
	 * @return session factory
	 */
	public static SessionFactory getSessionFactory() {
		return Optional.ofNullable(sessionFactory).orElse(new Configuration().configure().buildSessionFactory());
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