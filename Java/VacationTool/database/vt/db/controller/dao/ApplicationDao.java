package vt.db.controller.dao;

import vt.db.controller.dao.interfaces.IApplicationDao;
import vt.db.model.dao.GenericDao;
import vt.db.model.entity.Application;
/***
 * Class represents application operations on database. In this class should appear all operations on database. 
 * @author Mateusz Mucha
 */
public class ApplicationDao extends GenericDao<Application> implements IApplicationDao {
	
	
	public ApplicationDao() {
		super();
	}
	
	
}