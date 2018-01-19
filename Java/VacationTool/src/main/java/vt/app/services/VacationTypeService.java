package vt.app.services;

import java.util.List;
import org.springframework.stereotype.Service;
import vt.db.controller.dao.VacationTypeDao;
import vt.db.controller.dao.interfaces.IVacationType;

@Service
public class VacationTypeService {
	private IVacationType vacType;
	
	


	public VacationTypeService() {
		this.vacType = new VacationTypeDao();
	}
	

	public IVacationType getVacType() {
		return vacType;
	}
	
	
	
	
	
	
	
}