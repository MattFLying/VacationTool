package vt.db.controller.dao;

import vt.db.controller.dao.interfaces.IVacationDao;
import vt.db.model.dao.GenericDao;
import vt.db.model.entity.Vacation;
/***
 * Class represents vacation operations on database. In this class should appear all operations on database. 
 * @author Mateusz Mucha
 */
public class VacationDao extends GenericDao<Vacation> implements IVacationDao {
	
	
	public VacationDao() {
		super();
	}
	
	
}