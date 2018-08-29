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
 * Class to find all employees in database which are managers.
 * 
 * @author Mateusz Mucha
 *
 */
public final class FindAllManagers implements EmployeeListOperation {

	/**
	 * Default constructor to instantiate.
	 */
	public FindAllManagers() {

	}

	@Override
	public Collection<Employee> run() {
		Session session = null;
		Collection<Employee> employees = new ArrayList<Employee>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
			Root<Employee> root = criteria.from(Employee.class);

			criteria.where(builder.equal(root.get("isManager"), 1));
			criteria.select(builder.array(root.get("id"), root.get("firstName"), root.get("lastName"),
					root.get("departmentId")));

			session.createQuery(criteria).getResultList().forEach(result -> {
				Integer id = (Integer) result[0];
				String firstName = (String) result[1];
				String lastName = (String) result[2];
				Integer departmentId = (Integer) result[3];

				employees.add(new Employee(id, firstName, lastName, departmentId));
			});
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