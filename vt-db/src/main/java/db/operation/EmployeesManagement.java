package db.operation;

import java.util.List;
import db.entity.Employee;

/**
 * Interface with possible oeprations on employees in database. Should be
 * implemented by all finally strategies depending than type of using ORM.
 * 
 * @author Mateusz Mucha
 *
 */
public interface EmployeesManagement extends DatabaseOperations<Employee> {
	/**
	 * Method to get employee by login(evidence number)
	 * 
	 * @param evidenceNumber
	 *            evidence numer and login
	 * @return employee
	 */
	Employee findByEvidenceNumber(String evidenceNumber);

	/**
	 * Method to find all employees which are managers. Method return only
	 * identificator, first name, last name and identificator of departmend id.
	 * 
	 * @return list of managers with only a few specific fields.
	 */
	List<Employee> findAllManagers();

	/**
	 * Method to get all employees from specific department.
	 * 
	 * @param departmentId
	 *            identificator of department from which all employees will be
	 *            returned
	 * @return list of employees from specific deparment
	 */
	List<Employee> findAllByDepartmentId(Integer departmentId);

	/**
	 * Method to get all employees from specific department without one of them
	 * which could be a manager to listing all employees which this employee
	 * management.
	 * 
	 * @param departmentId
	 *            identificator of department from which all employees will be
	 * @param id
	 *            identificator of employee which should be excluded from list
	 *            e.g. if he is a manager and is no needed
	 * @return list of employees from specific deparment
	 */
	List<Employee> findAllByDepartmentIdAndIdNot(Integer departmentId, Integer id);

	/**
	 * Method to get first name and last name of employee as one formated string
	 * e.g. 'John Doe'
	 * 
	 * @param id
	 *            identificator of employee
	 * @return full name of employee
	 */
	String findFullNameById(Integer id);

	/**
	 * Method to get avatar of employee by his identificator.
	 * 
	 * @param id
	 *            identificator of employee
	 * @return avatar of employee
	 */
	String findAvatarById(Integer id);

	/**
	 * Method to get department identificator of employee by employee's
	 * identificator.
	 * 
	 * @param id
	 *            identificator of employee
	 * @return department identificator of employee
	 */
	Integer findDepartmentIdById(Integer id);

	/**
	 * Method to get position identificator of employee by employee's
	 * identificator.
	 * 
	 * @param id
	 *            identificator of employee
	 * @return position identificator of employee
	 */
	Integer findPositionIdById(Integer id);

	/**
	 * Method to get employee's manager identificator by employee identificator.
	 * 
	 * @param id
	 *            identificator of employee
	 * @return manager identificator of employee
	 */
	Integer findManagerIdById(Integer id);

	/**
	 * Method to change password of employee.
	 * 
	 * @param password
	 *            the new password to update
	 * @param id
	 *            identificator of employee for which will be changed password
	 */
	void changePassword(String password, Integer id);
}