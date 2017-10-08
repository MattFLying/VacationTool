package vt.db.controller.dao;

import vt.db.controller.dao.interfaces.IDepartmentDao;
import vt.db.model.dao.GenericDao;
import vt.db.model.entity.Department;
/***
 * Class represents department operations on database. In this class should appear all operations on database. 
 * @author Mateusz Mucha
 */
public class DepartmentDao extends GenericDao<Department> implements IDepartmentDao {
	
	
	public DepartmentDao() {
		super();
	}
	
	
}