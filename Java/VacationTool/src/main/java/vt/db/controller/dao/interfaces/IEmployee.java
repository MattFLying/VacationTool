package vt.db.controller.dao.interfaces;

import java.util.List;

import vt.db.model.dao.IGenericDao;
import vt.db.model.entity.Employee;

public interface IEmployee extends IGenericDao<Employee> {
	public Employee findByLogin(String login);
	public Employee findByIdNameSurname(int id);
	public List<Employee> findAllManagers();
	public Employee findByIdDepartment(int id);
	public Employee findByIdAvatar(int id);
	public Employee findByIdPosition(int id);
	public Employee findByIdManager(int id);
}