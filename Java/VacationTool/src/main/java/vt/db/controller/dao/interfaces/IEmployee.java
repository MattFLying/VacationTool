package vt.db.controller.dao.interfaces;

import vt.db.model.dao.IGenericDao;
import vt.db.model.entity.Employee;

public interface IEmployee extends IGenericDao<Employee> {
	public Employee findByLogin(String login);
	public Employee findByIdNameSurname(int id);
}