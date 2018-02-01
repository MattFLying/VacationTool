package vt.db.controller.dao;

import vt.db.controller.dao.interfaces.IApplication;
import vt.db.model.dao.GenericDao;
import vt.db.model.entity.Application;

public class ApplicationDao extends GenericDao<Application> implements IApplication {
	
	
	public ApplicationDao() {
		super();
	}
	
	
}