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
 * Class to find all applications for specific manager in database sorted by
 * created date and status. The newest applications will be at the beggining of
 * the result.
 * 
 * @author Mateusz Mucha
 *
 */
public final class FindAllApplicationsForManagerSortedByStatusAndCreation implements ApplicationListOperation {
	private Integer managerId;

	/**
	 * Constructor to set identificator of manager to search applications of
	 * him.
	 * 
	 * @param managerId
	 *            identificator of manager to research
	 */
	public FindAllApplicationsForManagerSortedByStatusAndCreation(Integer managerId) {
		this.managerId = managerId;
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

			criteria.where(builder.equal(root.get("managerId"), managerId));
			criteria.orderBy(builder.desc(root.get("status")), builder.desc(root.get("createdDate")));

			applications = session.createQuery(criteria).getResultList();
		} catch (HibernateException e) {
			Logger.getLogger(FindAllApplicationsForManagerSortedByStatusAndCreation.class)
					.error(ExceptionDescription.HIBERNATE_SESSION_OPEN.fullDescription());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return (applications != null) ? applications : new ArrayList<Application>();
	}

}