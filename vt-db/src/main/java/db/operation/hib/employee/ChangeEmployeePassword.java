package db.operation.hib.employee;

import java.util.Optional;

import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.TransactionRequiredException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;
import db.entity.Employee;
import db.exception.ExceptionDescription;
import db.operation.hib.EmployeeOperation;
import db.util.HibernateUtil;

/**
 * Class to change employee's password.
 * 
 * @author Mateusz Mucha
 *
 */
public final class ChangeEmployeePassword implements EmployeeOperation {
	private Integer employeeId;
	private String password;

	/**
	 * Constructor to set identificator of employee for which will be changed
	 * the new password..
	 * 
	 * @param id
	 *            identificator of employee
	 * @param password
	 *            new employee's password
	 */
	public ChangeEmployeePassword(Integer id, String password) {
		this.employeeId = id;
		this.password = password;
	}

	@Override
	public Employee run() {
		Session session = null;
		Employee employee = new Employee(employeeId);

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaUpdate<Employee> criteria = builder.createCriteriaUpdate(Employee.class);
			Root<Employee> root = criteria.from(Employee.class);

			criteria.set("password", password);
			criteria.where(builder.equal(root.get("id"), employeeId));

			session.createQuery(criteria).executeUpdate();

			transaction.commit();
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
		} catch (TransactionRequiredException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_TRANSACTION_FAIL.fullDescription());
		} catch (PersistenceException e) {
			Logger.getLogger(ChangeEmployeePassword.class)
					.error(ExceptionDescription.HIBERNATE_QUERY_TIMED_OUT.fullDescription());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return Optional.ofNullable(employee).orElse(new Employee("No ", "data."));
	}

}