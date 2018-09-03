package web.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import db.entity.Position;
import db.operation.repository.sd.PositionRepository;
import web.exception.ResultNotFoundException;

/**
 * Service represents operations on positions available in departments.
 * 
 * @author Mateusz Mucha
 */
@Service
public class PositionService extends DefaultService<Position> {
	@Autowired
	private PositionRepository repository;

	/**
	 * Default construstor
	 */
	public PositionService() {

	}

	/**
	 * Method to find all positions available in specific department.
	 * 
	 * @param departmentId
	 *            identificator of department
	 * @return collection of positions for department
	 * @throws ResultNotFoundException
	 *             throw when there are no positions for this department
	 */
	public Collection<Position> findAllOfDepartment(int departmentId) throws ResultNotFoundException {
		Collection<Position> list = repository.findAllByDepartmentId(departmentId);

		throwExceptionWhenListIsEmpty(list,
				String.format(
						"Department of identificator %d has no available positions or department does not exists.",
						departmentId));

		return list;
	}
}
