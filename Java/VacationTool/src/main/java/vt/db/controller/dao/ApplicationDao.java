package vt.db.controller.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import vt.db.controller.dao.interfaces.IApplication;
import vt.db.model.dao.GenericDao;
import vt.db.model.entity.Application;
import vt.db.model.util.HibernateUtil;

public class ApplicationDao extends GenericDao<Application> implements IApplication {
	public ApplicationDao() {
		super();
	}
	
	
	@Override
	public List<Application> findAllSortedByStatus() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = null;
		List<Application> applications = new ArrayList<Application>();
		
		try {
			criteria = session.createCriteria(Application.class);
			criteria.addOrder(Order.desc("appStatus"));
			criteria.addOrder(Order.desc("appCreatedDate"));

			applications = criteria.list();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			session.clear();
			session.close();
		}
		
		return applications;
	}
	@Override
	public List<Application> findAllSortedByStatusById(int managerId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = null;
		List<Application> applications = new ArrayList<Application>();
		
		try {
			criteria = session.createCriteria(Application.class);
			criteria.add(Restrictions.eq("appManagerId", managerId));
			criteria.addOrder(Order.desc("appStatus"));
			criteria.addOrder(Order.desc("appCreatedDate"));

			applications = criteria.list();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			session.clear();
			session.close();
		}
		
		return applications;
	}
	@Override
	public List<Application> findAllSortedByStatusByEmployeeId(int empId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = null;
		List<Application> applications = new ArrayList<Application>();
		
		try {
			criteria = session.createCriteria(Application.class);
			criteria.add(Restrictions.eq("appEmployeeId", empId));
			criteria.addOrder(Order.desc("appStatus"));
			criteria.addOrder(Order.desc("appCreatedDate"));

			applications = criteria.list();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			session.clear();
			session.close();
		}
		
		return applications;
	}
}