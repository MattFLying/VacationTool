package vt.db.controller.dao.interfaces;

import java.util.List;
import vt.db.model.dao.IGenericDao;
import vt.db.model.entity.Vacation;

public interface IVacation extends IGenericDao<Vacation> {
	public List<Vacation> findAllVacations();
	public List<Vacation> findAllVacationsByEmployeeId(int employeeId);
}