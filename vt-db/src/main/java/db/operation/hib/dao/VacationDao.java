package db.operation.hib.dao;

import java.util.List;

import db.entity.Vacation;
import db.operation.VacationManagement;
import db.operation.hib.vacation.FindAllVacationsByEmployeeAndVacationType;
import db.operation.hib.vacation.FindAllVacationsByEmployeeId;

/**
 * DAO class for Vacation management using hibernate.
 * 
 * @author Mateusz Mucha
 *
 */
public final class VacationDao extends HibernateDao<Vacation> implements VacationManagement {
	private final HibernateExecutor<Vacation> executor = new HibernateExecutor<Vacation>();

	/**
	 * Default constructor.
	 */
	public VacationDao() {

	}

	@Override
	public List<Vacation> findAllByEmployeeId(Integer employeeId) {
		return executor.actionList(new FindAllVacationsByEmployeeId(employeeId));
	}

	@Override
	public List<Vacation> findAllByEmployeeIdAndVacationType(Integer employeeId, Integer vacationType) {
		return executor.actionList(new FindAllVacationsByEmployeeAndVacationType(employeeId, vacationType));
	}

}
