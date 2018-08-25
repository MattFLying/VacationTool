package db.operation.hib.application;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jboss.logging.Logger;

import db.entity.Application;
import db.exception.ExceptionDescription;
import db.operation.hib.ApplicationListOperation;
import db.util.HibernateUtil;

/**
 * Class to find all applications in database sorted by created date and status.
 * The newest applications will be at the begining of the result.
 * 
 * @author Mateusz Mucha
 *
 */
public class FindAllApplicationsSortedByStatusAndCreation implements ApplicationListOperation {

	/**
	 * Default constructor.
	 */
	public FindAllApplicationsSortedByStatusAndCreation() {

	}

	@Override
	public List<Application> run() {
		Session session = null;
		List<Application> applications = new ArrayList<Application>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Application> criteria = builder.createQuery(Application.class);
			Root<Application> root = criteria.from(Application.class);

			criteria.orderBy(builder.desc(root.get("status")), builder.desc(root.get("createdDate")));
			applications = session.createQuery(criteria).getResultList();
		} catch (HibernateException e) {
			Logger.getLogger(FindAllApplicationsSortedByStatusAndCreation.class)
					.error(ExceptionDescription.HIBERNATE_SESSION_OPEN.fullDescription());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return (applications != null) ? applications : new ArrayList<Application>();
	}

}