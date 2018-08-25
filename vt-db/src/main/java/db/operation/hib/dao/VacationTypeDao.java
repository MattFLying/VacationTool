package db.operation.hib.dao;

import db.entity.VacationType;
import db.operation.VacationTypeManagement;

/**
 * DAO class for VacationType management using hibernate.
 * 
 * @author Mateusz Mucha
 *
 */
public class VacationTypeDao extends HibernateDao<VacationType> implements VacationTypeManagement {
	/**
	 * Default constructor.
	 */
	public VacationTypeDao() {

	}

}
