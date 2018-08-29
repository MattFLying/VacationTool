package db.operation.repository.hib;

import java.util.Collection;
import org.springframework.stereotype.Repository;

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
@Repository
public class VacationDao extends HibernateDao<Vacation> implements VacationManagement {
	private final HibernateExecutor<Vacation> executor = new HibernateExecutor<Vacation>();

	/**
	 * Default constructor.
	 */
	public VacationDao() {

	}

	@Override
	public Collection<Vacation> findAllByEmployeeId(Integer employeeId) {
		return executor.actionCollection(new FindAllVacationsByEmployeeId(employeeId));
	}

	@Override
	public Collection<Vacation> findAllByEmployeeIdAndVacationType(Integer employeeId, Integer vacationType) {
		return executor.actionCollection(new FindAllVacationsByEmployeeAndVacationType(employeeId, vacationType));
	}

}
