package vt.db.controller.dao.interfaces;

import java.util.List;

import vt.db.model.dao.IGenericDao;
import vt.db.model.entity.VacationType;

public interface IVacationType extends IGenericDao<VacationType> {
	public List<VacationType> findAllVacationTypes();
}