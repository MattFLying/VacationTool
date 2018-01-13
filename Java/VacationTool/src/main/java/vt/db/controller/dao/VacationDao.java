package vt.db.controller.dao;

import vt.db.controller.dao.interfaces.IVacationDao;
import vt.db.model.dao.GenericDao;
import vt.db.model.entity.Vacation;

public class VacationDao extends GenericDao<Vacation> implements IVacationDao {
	
	
	public VacationDao() {
		super();
	}
	
	
}