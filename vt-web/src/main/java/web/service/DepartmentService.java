package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import db.entity.Department;
import db.operation.repository.sd.DepartmentRepository;

/**
 * Service represents operations on departments.
 * 
 * @author Mateusz Mucha
 */
@Service
public class DepartmentService extends DefaultService<Department> {
	@Autowired
	private DepartmentRepository repository;

	/**
	 * Default construstor
	 */
	public DepartmentService() {

	}

}
