package vt.db.controller.dao;

import vt.db.controller.dao.interfaces.IFreeDaysDao;
import vt.db.model.dao.GenericDao;
import vt.db.model.entity.FreeDays;
/***
 * Class represents free days operations on database. In this class should appear all operations on database. 
 * @author Mateusz Mucha
 */
public class FreeDaysDao extends GenericDao<FreeDays> implements IFreeDaysDao {
	
	
	public FreeDaysDao() {
		super();
	}
	
	
}