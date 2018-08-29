package db.operation.repository.hib;

import java.util.Collection;
import org.springframework.stereotype.Repository;

import db.entity.Position;
import db.operation.PositionManagement;
import db.operation.hib.position.FindAllPositionsByDepartmentId;

/**
 * DAO class for Position management using hibernate.
 * 
 * @author Mateusz Mucha
 *
 */
@Repository
public class PositionDao extends HibernateDao<Position> implements PositionManagement {
	private final HibernateExecutor<Position> executor = new HibernateExecutor<Position>();

	/**
	 * Default constructor.
	 */
	public PositionDao() {

	}

	@Override
	public Collection<Position> findAllByDepartmentId(Integer departmentId) {
		return executor.actionCollection(new FindAllPositionsByDepartmentId(departmentId));
	}

}
