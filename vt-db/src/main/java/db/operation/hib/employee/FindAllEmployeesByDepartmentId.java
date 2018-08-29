package db.operation.hib.employee;

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

import db.entity.Employee;
import db.exception.ExceptionDescription;
import db.operation.hib.EmployeeListOperation;
import db.util.HibernateUtil;

/**
 * Class to find all employees in database belong to specific department.
 * 
 * @author Mateusz Mucha
 *
 */
public final class FindAllEmployeesByDepartmentId implements EmployeeListOperation {
	private Integer departmentId;

	/**
	 * Constructor to set identificator of department to search employees from
	 * there.
	 * 
	 * @param id
	 *            identificator of department to research
	 */
	public FindAllEmployeesByDepartmentId(Integer id) {
		this.departmentId = id;
	}

	@Override
	public Collection<Employee> run() {
		Session session = null;
		Collection<Employee> employees = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
			Root<Employee> root = criteria.from(Employee.class);

			criteria.where(builder.equal(root.get("departmentId"), departmentId));
			employees = session.createQuery(criteria).getResultList();
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

		return Optional.ofNullable(employees).orElse(new ArrayList<Employee>());
	}

}