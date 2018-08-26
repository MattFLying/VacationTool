package db.operation.hib.dao;

import java.util.List;

import db.entity.Position;
import db.operation.PositionManagement;
import db.operation.hib.position.FindAllPositionsByDepartmentId;

/**
 * DAO class for Position management using hibernate.
 * 
 * @author Mateusz Mucha
 *
 */
public final class PositionDao extends HibernateDao<Position> implements PositionManagement {
	private final HibernateExecutor<Position> executor = new HibernateExecutor<Position>();

	/**
	 * Default constructor.
	 */
	public PositionDao() {

	}

	@Override
	public List<Position> findAllByDepartmentId(Integer departmentId) {
		return executor.actionList(new FindAllPositionsByDepartmentId(departmentId));
	}

}
