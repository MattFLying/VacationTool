package vt.db.controller.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import vt.db.controller.dao.interfaces.IPosition;
import vt.db.model.dao.GenericDao;
import vt.db.model.entity.Position;
import vt.db.model.util.HibernateUtil;

public class PositionDao extends GenericDao<Position> implements IPosition {
	public PositionDao() {
		super();
	}
	
	
	@Override
	public List<Position> findAllPositions() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = null;
		List<Position> positions = new ArrayList<Position>();
		
		try {
			criteria = session.createCriteria(Position.class);

			positions = criteria.list();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			session.clear();
			session.close();
		}
		
		return positions;
	}
	@Override
	public List<Position> findAllPositionsForDepartment(int departmentId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = null;
		List<Position> positions = null;
		
		try {
			criteria = session.createCriteria(Position.class);
			criteria.add(Restrictions.eq("positionDepartmentId", departmentId));
			
			positions = criteria.list();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			session.clear();
			session.close();
		}
		
		return positions;
	}
}