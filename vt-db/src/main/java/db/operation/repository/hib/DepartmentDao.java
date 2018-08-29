package db.operation.repository.hib;

import org.springframework.stereotype.Repository;

import db.entity.Department;
import db.operation.DepartmentManagement;

/**
 * DAO class for Department management using hibernate.
 * 
 * @author Mateusz Mucha
 *
 */
@Repository
public class DepartmentDao extends HibernateDao<Department> implements DepartmentManagement {
	/**
	 * Default constructor.
	 */
	public DepartmentDao() {

	}

}
