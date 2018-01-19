package vt.db.controller.dao.interfaces;

import java.util.List;

import vt.db.model.dao.IGenericDao;
import vt.db.model.entity.Department;

public interface IDepartment extends IGenericDao<Department> {
	public List<Department> findAllDepartments();
}