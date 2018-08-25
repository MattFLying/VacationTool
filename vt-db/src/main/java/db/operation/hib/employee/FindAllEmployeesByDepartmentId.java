package db.operation.hib.employee;

import java.util.ArrayList;
import java.util.List;
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
public class FindAllEmployeesByDepartmentId implements EmployeeListOperation {
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
	public List<Employee> run() {
		Session session = null;
		List<Employee> employees = new ArrayList<Employee>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
			Root<Employee> root = criteria.from(Employee.class);

			criteria.where(builder.equal(root.get("departmentId"), departmentId));
			employees = session.createQuery(criteria).getResultList();
		} catch (HibernateException e) {
			Logger.getLogger(FindAllEmployeesByDepartmentId.class)
					.error(ExceptionDescription.HIBERNATE_SESSION_OPEN.fullDescription());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return (employees != null) ? employees : new ArrayList<Employee>();
	}

}