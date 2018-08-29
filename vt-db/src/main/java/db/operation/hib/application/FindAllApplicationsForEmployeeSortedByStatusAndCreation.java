package db.operation.hib.application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jboss.logging.Logger;

import db.entity.Application;
import db.exception.ExceptionDescription;
import db.operation.hib.ApplicationListOperation;
import db.operation.hib.employee.ChangeEmployeePassword;
import db.util.HibernateUtil;

/**
 * Class to find all applications for specific employee in database sorted by
 * created date and status. The newest applications will be at the beggining of
 * the result.
 * 
 * @author Mateusz Mucha
 *
 */
public final class FindAllApplicationsForEmployeeSortedByStatusAndCreation implements ApplicationListOperation {
	private Integer employeeId;

	/**
	 * Constructor to set identificator of manager to search applications of
	 * him.
	 * 
	 * @param employeeId
	 *            identificator of employee to research
	 */
	public FindAllApplicationsForEmployeeSortedByStatusAndCreation(Integer employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public Collection<Application> run() {
		Session session = null;
		Collection<Application> applications = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Application> criteria = builder.createQuery(Application.class);
			Root<Application> root = criteria.from(Application.class);

			criteria.where(builder.equal(root.get("employeeId"), employeeId));
			criteria.orderBy(builder.desc(root.get("status")), builder.desc(root.get("createdDate")));

			applications = session.createQuery(criteria).getResultList();
		} catch (HibernateException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_SESSION_OPEN.fullDescription());
		} catch (RollbackException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_TRANSATION_FAIL.fullDescription());
		} catch (IllegalStateException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_ENTITYMANAGER_CLOSED.fullDescription());
		} catch (IllegalArgumentException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_ATTRIBUTE_NO_EXIST.fullDescription());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return Optional.ofNullable(applications).orElse(new ArrayList<Application>());
	}

}