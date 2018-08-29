package db.operation;

import java.util.Collection;
import db.entity.Vacation;

/**
 * Interface with possible operations on vacations in database. Should be
 * implemented by all finally strategies depending than type of using ORM.
 * 
 * @author Mateusz Mucha
 *
 */
public interface VacationManagement extends DatabaseOperations<Vacation> {
	/**
	 * Method to find all vacations for specific employee.
	 * 
	 * @param employeeId
	 *            identificator of employee
	 * @return list of all vacations for employee
	 */
	Collection<Vacation> findAllByEmployeeId(Integer employeeId);

	/**
	 * Method to find all vacations by specific type of these vacations for
	 * specific employee.
	 * 
	 * @param employeeId
	 *            identificator of employee
	 * @param vacationType
	 *            identificator of vacation type
	 * @return vacation list of specific type for employee
	 */
	Collection<Vacation> findAllByEmployeeIdAndVacationType(Integer employeeId, Integer vacationType);
}