package vt.app.services;

import java.util.List;
import org.springframework.stereotype.Service;
import vt.db.controller.dao.VacationDao;
import vt.db.controller.dao.interfaces.IVacation;
import vt.db.model.entity.Vacation;

@Service
public class VacationService {
	private IVacation vac;


	public VacationService() {
		this.vac = new VacationDao();
	}
	

	public IVacation getVac() {
		return vac;
	}
	public Vacation getVacationById(int id) {
		return this.vac.findById(id);
	}
	public List<Vacation> getAllVacations() {
		return this.vac.findAllVacations();
	}
	public List<Vacation> getAllVacationsByEmployeeId(int id) {
		return this.vac.findAllVacationsByEmployeeId(id);
	}
	public Vacation getfindVacationByEmployeeIdAndVacationType(int employeeId, int vacationType) {
		return this.vac.findVacationByEmployeeIdAndVacationType(employeeId, vacationType);
	}
}