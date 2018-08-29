package db.operation;

import java.util.Collection;

import db.entity.Application;

/**
 * Interface with possible operations on vacation applications in database.
 * Should be implemented by all finally strategies depending than type of using
 * ORM.
 * 
 * @author Mateusz Mucha
 *
 */
public interface ApplicationManagement extends DatabaseOperations<Application> {
	/**
	 * Method to find all vacation applicatioons sorted by status and created
	 * date. Waiting applications will be at the begining of the list.
	 * 
	 * @return sorted list of applications by status
	 */
	Collection<Application> findAllByOrderByStatusDescCreatedDateDesc();

	/**
	 * Method to find all vacation applications sorted by status and created
	 * date for specific manager. Waiting applications will be at the begining
	 * of the liest.
	 * 
	 * @param managerId
	 *            identificator of manager
	 * @return sorted list of applications by status for specific manager
	 */
	Collection<Application> findAllByManagerIdOrderByStatusDescCreatedDateDesc(Integer managerId);

	/**
	 * Method to find all vacation applications sorted by status and created
	 * date for specific employee. Waiting applications will be at the begining
	 * of the list.
	 * 
	 * @param employeeId
	 *            identificator of employee
	 * @return sorted list of applications by status for specific employee
	 */
	Collection<Application> findAllByEmployeeIdOrderByStatusDescCreatedDateDesc(Integer employeeId);
}