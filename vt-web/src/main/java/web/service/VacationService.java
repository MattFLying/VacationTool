package web.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import db.entity.Vacation;
import db.operation.repository.sd.VacationRepository;
import web.exception.ResultNotFoundException;

/**
 * Service represents operations on vacations.
 * 
 * @author Mateusz Mucha
 */
@Service
public class VacationService extends DefaultService<Vacation> {
	@Autowired
	private VacationRepository repository;

	/**
	 * Default construstor
	 */
	public VacationService() {

	}

	/**
	 * Method to find all vacations for specific employee.
	 * 
	 * @param employeeId
	 *            identificator of employee
	 * @return collection of vacations for employee
	 * @throws ResultNotFoundException
	 *             throw when there are no vacations for this employee
	 */
	public Collection<Vacation> findAllForEmployee(int employeeId) throws ResultNotFoundException {
		Collection<Vacation> list = repository.findAllByEmployeeId(employeeId);

		throwExceptionWhenListIsEmpty(list, String.format(
				"Employee of identificator %d have no vacations to show or employee does not exists.", employeeId));

		return list;
	}

	/**
	 * Method to find all vacations for specific employee by specific vacation
	 * type.
	 * 
	 * @param employeeId
	 *            identificator of employee
	 * @param vacationType
	 *            identificator of vacation type
	 * @return collection of vacations for employee with specific vacation type
	 * @throws ResultNotFoundException
	 *             throw when there are no vacations for this employee and this
	 *             vacation type
	 */
	public Collection<Vacation> findAllForEmployeeByVacationType(int employeeId, int vacationType)
			throws ResultNotFoundException {
		Collection<Vacation> list = repository.findAllByEmployeeIdAndVacationType(employeeId, vacationType);

		throwExceptionWhenListIsEmpty(list,
				String.format(
						"Employee of identificator %d have no vacations of this type to show alsow employee or vacation type could not exists.",
						employeeId));

		return list;
	}

}
