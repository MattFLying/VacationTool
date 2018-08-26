package db.operation.hib.dao;

import java.util.List;

import db.entity.Employee;
import db.operation.EmployeesManagement;
import db.operation.hib.employee.ChangeEmployeePassword;
import db.operation.hib.employee.FindAllEmployeesByDepartmentId;
import db.operation.hib.employee.FindAllEmployeesByDepartmentIdWithoutEmployeeId;
import db.operation.hib.employee.FindAllManagers;
import db.operation.hib.employee.FindAvatarByEmployeeId;
import db.operation.hib.employee.FindDepartmentIdByEmployeeId;
import db.operation.hib.employee.FindEmployeeByEvidenceNumber;
import db.operation.hib.employee.FindFullNameOfEmployeeById;
import db.operation.hib.employee.FindManagerIdByEmployeeId;
import db.operation.hib.employee.FindPositionIdByEmployeeId;

/**
 * DAO class for Employees management using hibernate.
 * 
 * @author Mateusz Mucha
 *
 */
public final class EmployeeDao extends HibernateDao<Employee> implements EmployeesManagement {
	private final HibernateExecutor<Employee> executor = new HibernateExecutor<Employee>();

	/**
	 * Default constructor.
	 */
	public EmployeeDao() {

	}

	@Override
	public Employee findByEvidenceNumber(String evidenceNumber) {
		return executor.action(new FindEmployeeByEvidenceNumber(evidenceNumber));
	}

	@Override
	public List<Employee> findAllManagers() {
		return executor.actionList(new FindAllManagers());
	}

	@Override
	public List<Employee> findAllByDepartmentId(Integer departmentId) {
		return executor.actionList(new FindAllEmployeesByDepartmentId(departmentId));
	}

	@Override
	public List<Employee> findAllByDepartmentIdAndIdNot(Integer departmentId, Integer id) {
		return executor.actionList(new FindAllEmployeesByDepartmentIdWithoutEmployeeId(departmentId, id));
	}

	@Override
	public String findFullNameById(Integer id) {
		Employee employee = executor.action(new FindFullNameOfEmployeeById(id));

		return new StringBuilder(employee.getFirstName()).append(" ").append(employee.getLastName()).toString();
	}

	@Override
	public String findAvatarById(Integer id) {
		return executor.action(new FindAvatarByEmployeeId(id)).getAvatar();
	}

	@Override
	public Integer findDepartmentIdById(Integer id) {
		return executor.action(new FindDepartmentIdByEmployeeId(id)).getDepartmentId();
	}

	@Override
	public Integer findPositionIdById(Integer id) {
		return executor.action(new FindPositionIdByEmployeeId(id)).getPositionId();
	}

	@Override
	public Integer findManagerIdById(Integer id) {
		return executor.action(new FindManagerIdByEmployeeId(id)).getManagerId();
	}

	@Override
	public void changePassword(String password, Integer id) {
		executor.action(new ChangeEmployeePassword(id, password));
	}

}
