package db.operation.hib.employee;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jboss.logging.Logger;

import db.entity.Employee;
import db.exception.ExceptionDescription;
import db.operation.hib.EmployeeOperation;
import db.util.HibernateUtil;

/**
 * Class to find employee's by his evidence number.
 * 
 * @author Mateusz Mucha
 *
 */
public class FindEmployeeByEvidenceNumber implements EmployeeOperation {
	private String evidenceNumber;

	/**
	 * Constructor to set evidence number for which will be searching an
	 * employee.
	 * 
	 * @param evidenceNumber
	 *            evidence number of employee
	 */
	public FindEmployeeByEvidenceNumber(String evidenceNumber) {
		this.evidenceNumber = evidenceNumber;
	}

	@Override
	public Employee run() {
		Session session = null;
		Employee employee = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
			Root<Employee> root = criteria.from(Employee.class);

			criteria.where(builder.equal(root.get("evidenceNumber"), evidenceNumber));

			employee = session.createQuery(criteria).getResultList().get(0);
		} catch (HibernateException e) {
			Logger.getLogger(FindEmployeeByEvidenceNumber.class)
					.error(ExceptionDescription.HIBERNATE_SESSION_OPEN.fullDescription());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return employee;
	}

}