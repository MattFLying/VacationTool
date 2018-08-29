package db.operation.repository.hib;

import org.springframework.stereotype.Repository;

import db.entity.VacationType;
import db.operation.VacationTypeManagement;

/**
 * DAO class for VacationType management using hibernate.
 * 
 * @author Mateusz Mucha
 *
 */
@Repository
public class VacationTypeDao extends HibernateDao<VacationType> implements VacationTypeManagement {
	/**
	 * Default constructor.
	 */
	public VacationTypeDao() {

	}

}
