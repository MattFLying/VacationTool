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
 * Class to find employee's position in company.
 * 
 * @author Mateusz Mucha
 *
 */
public final class FindPositionIdByEmployeeId implements EmployeeOperation {
	private Integer employeeId;

	/**
	 * Constructor to set identificator of employee to search employee's
	 * position identificator.
	 * 
	 * @param id
	 *            identificator of employee
	 */
	public FindPositionIdByEmployeeId(Integer id) {
		this.employeeId = id;
	}

	@Override
	public Employee run() {
		Session session = null;
		Employee employee = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Integer> criteria = builder.createQuery(Integer.class);
			Root<Employee> root = criteria.from(Employee.class);

			criteria.where(builder.equal(root.get("id"), employeeId));
			criteria.select(root.get("positionId"));

			employee = new Employee();
			employee.setPositionId(session.createQuery(criteria).getResultList().get(0));
		} catch (HibernateException e) {
			Logger.getLogger(FindPositionIdByEmployeeId.class)
					.error(ExceptionDescription.HIBERNATE_SESSION_OPEN.fullDescription());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return employee;
	}

}