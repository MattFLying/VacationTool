package vt.db.controller.dao;

import vt.db.controller.dao.interfaces.IEmployeeDao;
import vt.db.model.dao.GenericDao;
import vt.db.model.entity.Employee;
/***
 * Class represents employee operations on database. In this class should appear all operations on database. 
 * @author Mateusz Mucha
 */
public class EmployeeDao extends GenericDao<Employee> implements IEmployeeDao {
	
	
	public EmployeeDao() {
		super();
	}
	
	
}