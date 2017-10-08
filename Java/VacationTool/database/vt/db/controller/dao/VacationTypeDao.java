package vt.db.controller.dao;

import vt.db.controller.dao.interfaces.IVacationTypeDao;
import vt.db.model.dao.GenericDao;
import vt.db.model.entity.VacationType;
/***
 * Class represents vacation type operations on database. In this class should appear all operations on database. 
 * @author Mateusz Mucha
 */
public class VacationTypeDao extends GenericDao<VacationType> implements IVacationTypeDao {
	
	
	public VacationTypeDao() {
		super();
	}
	
	
}