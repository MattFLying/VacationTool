package web.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import db.entity.Application;
import db.operation.repository.sd.ApplicationRepository;
import web.exception.ResultNotFoundException;

/**
 * Service represents operations on vacation applications.
 * 
 * @author Mateusz Mucha
 */
@Service
public class ApplicationService extends DefaultService<Application> {
	@Autowired
	private ApplicationRepository repository;

	/**
	 * Default construstor
	 */
	public ApplicationService() {

	}

	/**
	 * Method to find all vacation applications in system sorted by created date
	 * and status.
	 * 
	 * @return collection of sorted vacation applications
	 * @throws ResultNotFoundException
	 *             throw when there are no vacation applications
	 */
	public Collection<Application> findAllSortedByCreatedAndStatus() throws ResultNotFoundException {
		Collection<Application> list = repository.findAllByOrderByStatusDescCreatedDateDesc();

		throwExceptionWhenListIsEmpty(list, "There is no vacation applications to show.");

		return list;
	}

	/**
	 * Method to find all sorted vacation applications by created date and
	 * status for specific manager.
	 * 
	 * @param managerId
	 *            identificator of manager
	 * @return collection of sorted vacation applications for manager
	 * @throws ResultNotFoundException
	 *             throw when there are no vacation applications for this
	 *             manager
	 */
	public Collection<Application> findAllSortedForManager(int managerId) throws ResultNotFoundException {
		Collection<Application> list = repository.findAllByManagerIdOrderByStatusDescCreatedDateDesc(managerId);

		throwExceptionWhenListIsEmpty(list,
				String.format(
						"Manager of identificator %d have no vacation applications or this manager does not exists.",
						managerId));

		return list;
	}

	/**
	 * Method to find all sorted vacation applications by created date and
	 * status for specific employee.
	 * 
	 * @param managerId
	 *            identificator of employee
	 * @return collection of sorted vacation applications for employee
	 * @throws ResultNotFoundException
	 *             throw when there are no vacation applications for this
	 *             employee
	 */
	public Collection<Application> findAllSortedForEmployee(int employeeId) throws ResultNotFoundException {
		Collection<Application> list = repository.findAllByEmployeeIdOrderByStatusDescCreatedDateDesc(employeeId);

		throwExceptionWhenListIsEmpty(list,
				String.format(
						"Employee of identificator %d have no vacation applications or this employee does not exists.",
						employeeId));

		return list;
	}
}
