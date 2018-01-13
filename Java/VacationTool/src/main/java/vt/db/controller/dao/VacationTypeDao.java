package vt.db.controller.dao;

import vt.db.controller.dao.interfaces.IVacationTypeDao;
import vt.db.model.dao.GenericDao;
import vt.db.model.entity.VacationType;

public class VacationTypeDao extends GenericDao<VacationType> implements IVacationTypeDao {
	
	
	public VacationTypeDao() {
		super();
	}
	
	
}