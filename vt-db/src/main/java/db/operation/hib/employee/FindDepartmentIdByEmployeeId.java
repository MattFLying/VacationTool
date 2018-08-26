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
 * Class to find employee's department.
 * 
 * @author Mateusz Mucha
 *
 */
public final class FindDepartmentIdByEmployeeId implements EmployeeOperation {
	private Integer employeeId;

	/**
	 * Constructor to set identificator of employee for which will be searching
	 * department.
	 * 
	 * @param id
	 *            identificator of employee
	 */
	public FindDepartmentIdByEmployeeId(Integer id) {
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
			criteria.select(root.get("departmentId"));

			employee = new Employee();
			employee.setDepartmentId(session.createQuery(criteria).getResultList().get(0));
		} catch (HibernateException e) {
			Logger.getLogger(FindDepartmentIdByEmployeeId.class)
					.error(ExceptionDescription.HIBERNATE_SESSION_OPEN.fullDescription());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return employee;
	}

}