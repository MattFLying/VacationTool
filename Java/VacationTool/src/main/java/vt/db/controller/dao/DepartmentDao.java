package vt.db.controller.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import vt.db.controller.dao.interfaces.IDepartment;
import vt.db.model.dao.GenericDao;
import vt.db.model.entity.Department;
import vt.db.model.util.HibernateUtil;

public class DepartmentDao extends GenericDao<Department> implements IDepartment {
	public DepartmentDao() {
		super();
	}
	
	
	@Override
	public List<Department> findAllDepartments() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = null;
		List<Department> positions = new ArrayList<Department>();
		
		try {
			criteria = session.createCriteria(Department.class);

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