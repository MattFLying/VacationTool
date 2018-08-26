package db.operation.hib.dao;

import java.util.List;

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
public final class ApplicationDao extends HibernateDao<Application> implements ApplicationManagement {
	private final HibernateExecutor<Application> executor = new HibernateExecutor<Application>();

	/**
	 * Default constructor.
	 */
	public ApplicationDao() {

	}

	@Override
	public List<Application> findAllByOrderByStatusDescCreatedDateDesc() {
		return executor.actionList(new FindAllApplicationsSortedByStatusAndCreation());
	}

	@Override
	public List<Application> findAllByManagerIdOrderByStatusDescCreatedDateDesc(Integer managerId) {
		return executor.actionList(new FindAllApplicationsForManagerSortedByStatusAndCreation(managerId));
	}

	@Override
	public List<Application> findAllByEmployeeIdOrderByStatusDescCreatedDateDesc(Integer employeeId) {
		return executor.actionList(new FindAllApplicationsForEmployeeSortedByStatusAndCreation(employeeId));
	}

}
