package db.operation.repository.hib;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import db.entity.Application;
import db.operation.ApplicationManagement;
import db.operation.hib.application.FindAllApplicationsForEmployeeSortedByStatusAndCreation;
import db.operation.hib.application.FindAllApplicationsForManagerSortedByStatusAndCreation;
import db.operation.hib.application.FindAllApplicationsSortedByStatusAndCreation;

/**
 * DAO class for Application management using hibernate.
 * 
 * @author Mateusz Mucha
 *
 */
@Repository
public class ApplicationDao extends HibernateDao<Application> implements ApplicationManagement {
	private final HibernateExecutor<Application> executor = new HibernateExecutor<Application>();

	/**
	 * Default constructor.
	 */
	public ApplicationDao() {

	}

	@Override
	public Collection<Application> findAllByOrderByStatusDescCreatedDateDesc() {
		return executor.actionCollection(new FindAllApplicationsSortedByStatusAndCreation());
	}

	@Override
	public Collection<Application> findAllByManagerIdOrderByStatusDescCreatedDateDesc(Integer managerId) {
		return executor.actionCollection(new FindAllApplicationsForManagerSortedByStatusAndCreation(managerId));
	}

	@Override
	public Collection<Application> findAllByEmployeeIdOrderByStatusDescCreatedDateDesc(Integer employeeId) {
		return executor.actionCollection(new FindAllApplicationsForEmployeeSortedByStatusAndCreation(employeeId));
	}

}
