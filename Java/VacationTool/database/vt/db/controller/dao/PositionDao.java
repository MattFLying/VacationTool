package vt.db.controller.dao;

import vt.db.controller.dao.interfaces.IPositionDao;
import vt.db.model.dao.GenericDao;
import vt.db.model.entity.Position;
/***
 * Class represents position operations on database. In this class should appear all operations on database. 
 * @author Mateusz Mucha
 */
public class PositionDao extends GenericDao<Position> implements IPositionDao {
	
	
	public PositionDao() {
		super();
	}
	
	
}