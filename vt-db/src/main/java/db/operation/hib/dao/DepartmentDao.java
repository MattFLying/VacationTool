package db.operation.hib.dao;

import db.entity.Department;
import db.operation.DepartmentManagement;

/**
 * DAO class for Department management using hibernate.
 * 
 * @author Mateusz Mucha
 *
 */
public final class DepartmentDao extends HibernateDao<Department> implements DepartmentManagement {
	/**
	 * Default constructor.
	 */
	public DepartmentDao() {

	}

}
