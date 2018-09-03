package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import db.entity.VacationType;
import db.operation.repository.sd.VacationTypeRepository;

/**
 * Service represents operations on vacation types.
 * 
 * @author Mateusz Mucha
 */
@Service
public class VacationTypeService extends DefaultService<VacationType> {
	@Autowired
	private VacationTypeRepository repository;

	/**
	 * Default construstor
	 */
	public VacationTypeService() {

	}

}
