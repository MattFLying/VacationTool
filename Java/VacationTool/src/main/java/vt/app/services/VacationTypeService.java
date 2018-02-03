package vt.app.services;

import java.util.List;
import org.springframework.stereotype.Service;
import vt.db.controller.dao.VacationTypeDao;
import vt.db.controller.dao.interfaces.IVacationType;
import vt.db.model.entity.VacationType;

@Service
public class VacationTypeService {
	private IVacationType vacType;
	

	public VacationTypeService() {
		this.vacType = new VacationTypeDao();
	}
	

	public IVacationType getVacType() {
		return vacType;
	}
	public VacationType getVacationTypeById(int id) {
		return this.vacType.findById(id);
	}
	public List<VacationType> getAllVacationTypes() {
		return this.vacType.findAllVacationTypes();
	}
}