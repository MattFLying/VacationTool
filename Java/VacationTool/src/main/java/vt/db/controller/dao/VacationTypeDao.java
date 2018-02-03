package vt.db.controller.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import vt.db.controller.dao.interfaces.IVacationType;
import vt.db.model.dao.GenericDao;
import vt.db.model.entity.VacationType;
import vt.db.model.util.HibernateUtil;

public class VacationTypeDao extends GenericDao<VacationType> implements IVacationType {
	public VacationTypeDao() {
		super();
	}
	
	
	@Override
	public List<VacationType> findAllVacationTypes() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = null;
		List<VacationType> vacations = new ArrayList<VacationType>();
		
		try {
			criteria = session.createCriteria(VacationType.class);

			vacations = criteria.list();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			session.clear();
			session.close();
		}
		
		return vacations;
	}
}