package vt.db.controller.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import vt.db.controller.dao.interfaces.IVacation;
import vt.db.model.dao.GenericDao;
import vt.db.model.entity.Vacation;
import vt.db.model.util.HibernateUtil;

public class VacationDao extends GenericDao<Vacation> implements IVacation {
	public VacationDao() {
		super();
	}
	
	
	@Override
	public List<Vacation> findAllVacations() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = null;
		List<Vacation> vacations = new ArrayList<Vacation>();
		
		try {
			criteria = session.createCriteria(Vacation.class);

			vacations = criteria.list();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			session.clear();
			session.close();
		}
		
		return vacations;
	}
	@Override
	public List<Vacation> findAllVacationsByEmployeeId(int employeeId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = null;
		List<Vacation> vacations = new ArrayList<Vacation>();
		
		try {
			criteria = session.createCriteria(Vacation.class);
			criteria.add(Restrictions.eq("vacEmployeeId", employeeId));

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