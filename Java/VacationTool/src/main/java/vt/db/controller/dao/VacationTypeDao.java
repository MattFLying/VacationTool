package vt.db.controller.dao;

import vt.db.controller.dao.interfaces.IVacationType;
import vt.db.model.dao.GenericDao;
import vt.db.model.entity.VacationType;

public class VacationTypeDao extends GenericDao<VacationType> implements IVacationType {
	
	
	public VacationTypeDao() {
		super();
	}
	
	
}