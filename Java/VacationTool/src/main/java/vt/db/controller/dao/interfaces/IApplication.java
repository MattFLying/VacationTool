package vt.db.controller.dao.interfaces;

import java.util.List;
import vt.db.model.dao.IGenericDao;
import vt.db.model.entity.Application;

public interface IApplication extends IGenericDao<Application> {
	public List<Application> findAllSortedByStatus();
	public List<Application> findAllSortedByStatusById(int managerId);
}