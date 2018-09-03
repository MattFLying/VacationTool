package web.service;

import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import db.entity.Employee;
import db.operation.repository.sd.EmployeeRepository;
import web.exception.ResultNotFoundException;
import web.exception.ValueCannotBeNull;

/**
 * Service represents operations on vacation applications.
 * 
 * @author Mateusz Mucha
 */
@Service
public class EmployeeService extends DefaultService<Employee> {
	@Autowired
	private EmployeeRepository repository;

	/**
	 * Default construstor
	 */
	public EmployeeService() {

	}

	/**
	 * Method to find employee be evidence number.
	 * 
	 * @param evidenceNumber
	 *            evidence number of employee
	 * @return employee with specified evidence number
	 * @throws ResultNotFoundException
	 *             throw when employee with specified evidence number does not
	 *             exists
	 */
	public Optional<Employee> findByEvidenceNumber(String evidenceNumber) throws ResultNotFoundException {
		Optional<Employee> result = Optional.ofNullable(repository.findByEvidenceNumber(evidenceNumber));

		if (!result.isPresent())
			throw new ResultNotFoundException(
					String.format("The employee of evidence number: %s could not be found.", evidenceNumber));
		return result;
	}

	/**
	 * Method to find all employees from specific department.
	 * 
	 * @param departmentId
	 *            identificator of department
	 * @return employees list from specified department
	 * @throws ResultNotFoundException
	 *             throw when specified department has no employees
	 */
	public Collection<Employee> findAllFromDepartment(int departmentId) throws ResultNotFoundException {
		Collection<Employee> list = repository.findAllByDepartmentId(departmentId);

		throwExceptionWhenListIsEmpty(list,
				String.format("Department of identificator: %d have no employees.", departmentId));

		return list;
	}

	/**
	 * Method to find all employees from specific department without one
	 * employee which could be a manager or something else what can exclude this
	 * employee from list..
	 * 
	 * @param departmentId
	 *            identificator of department
	 * @param employeeId
	 *            identificator of employee
	 * @return employees list from specified department without one employee
	 * @throws ResultNotFoundException
	 *             throw when specified department has no employees
	 */
	public Collection<Employee> findAllFromDepartmentWithoutOne(int departmentId, int employeeId)
			throws ResultNotFoundException {
		Collection<Employee> list = repository.findAllByDepartmentIdAndIdNot(departmentId, employeeId);

		throwExceptionWhenListIsEmpty(list,
				String.format("Department of identificator: %d have no employees.", departmentId));

		return list;
	}

	/**
	 * Method to find all employees with manager role.
	 * 
	 * @return employees list which are managers
	 * @throws ResultNotFoundException
	 *             throw when there is no employee with manager function
	 */
	public Collection<Employee> findAllManagers() throws ResultNotFoundException {
		Collection<Employee> list = repository.findAllManagers();

		throwExceptionWhenListIsEmpty(list, "Employees with manager function no found.");

		return list;
	}

	/**
	 * Method to find full name of employee: firstname and lastname together
	 * e.g. 'Joe Doe'
	 * 
	 * @param employeeId
	 *            identificator of employee
	 * @return full name of employee
	 * @throws ResultNotFoundException
	 *             throw when employee of this identificator does not exists
	 */
	public String findFullName(int employeeId) throws ValueCannotBeNull {
		String result = repository.findFullNameById(employeeId);

		throwExceptionWhenValueIsNull(result, String
				.format("There is no employee of identificator: %d and full name could not be created.", employeeId));

		return result;
	}

	/**
	 * Method to find avatar of employee.
	 * 
	 * @param employeeId
	 *            identificator of employee
	 * @return avatar of employee
	 * @throws ResultNotFoundException
	 *             throw when employee of this identificator does not exists or
	 *             employee have no assigned avatar
	 */
	public String findAvatar(int employeeId) throws ValueCannotBeNull {
		String result = repository.findAvatarById(employeeId);

		throwExceptionWhenValueIsNull(result, String
				.format("There is no employee of identificator: %d or this employee did not set avatar.", employeeId));

		return result;
	}

	/**
	 * Method to find department of employee.
	 * 
	 * @param employeeId
	 *            identificator of employee
	 * @return department of employee
	 * @throws ResultNotFoundException
	 *             throw when employee of this identificator does not exists or
	 *             employee have no assigned department
	 */
	public int findDepartment(int employeeId) throws ValueCannotBeNull {
		Integer result = repository.findDepartmentIdById(employeeId);

		throwExceptionWhenValueIsNull(result,
				String.format(
						"There is no employee of identificator: %d or this employee is not assigned to any department.",
						employeeId));

		return result;
	}

	/**
	 * Method to find position of employee.
	 * 
	 * @param employeeId
	 *            identificator of employee
	 * @return position of employee
	 * @throws ResultNotFoundException
	 *             throw when employee of this identificator does not exists or
	 *             employee have no assigned position
	 */
	public int findPosition(int employeeId) throws ValueCannotBeNull {
		Integer result = repository.findPositionIdById(employeeId);

		throwExceptionWhenValueIsNull(result,
				String.format(
						"There is no employee of identificator: %d or this employee have no assigned position in his department.",
						employeeId));

		return result;
	}

	/**
	 * Method to find manager of employee.
	 * 
	 * @param employeeId
	 *            identificator of employee
	 * @return manager of employee
	 * @throws ResultNotFoundException
	 *             throw when employee of this identificator does not exists or
	 *             employee have no assigned manager
	 */
	public int findManager(int employeeId) throws ValueCannotBeNull {
		Integer result = repository.findManagerIdById(employeeId);

		throwExceptionWhenValueIsNull(result,
				String.format("Employee of identificator: %d have no assigned manager.", employeeId));

		return result;
	}

	/**
	 * Method to change password of employee.
	 * 
	 * @param password
	 *            new password value which can not to be null value
	 * @param employeeId
	 *            identificator fo employee
	 * @throws ResultNotFoundException
	 *             throw when passed new password is null value
	 */
	public void changePassword(String password, int employeeId) throws ValueCannotBeNull {
		throwExceptionWhenValueIsNull(password, "New password cannot be null value.");

		String newPassword = passwordEncoder().encode(password);
		repository.changePassword(newPassword, employeeId);
	}

	/**
	 * Password encoder that uses the BCrypt strong hashing function.
	 * 
	 * @return BCryptPasswordEncoder
	 */
	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}