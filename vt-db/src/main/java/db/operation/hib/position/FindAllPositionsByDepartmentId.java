package db.operation.hib.position;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jboss.logging.Logger;

import db.entity.Position;
import db.exception.ExceptionDescription;
import db.operation.hib.PositionListOperation;
import db.util.HibernateUtil;

/**
 * Class to find all positions in database belong to specific department.
 * 
 * @author Mateusz Mucha
 *
 */
public final class FindAllPositionsByDepartmentId implements PositionListOperation {
	private Integer departmentId;

	/**
	 * Constructor to set identificator of department to search positions from
	 * there.
	 * 
	 * @param id
	 *            identificator of department to research
	 */
	public FindAllPositionsByDepartmentId(Integer id) {
		this.departmentId = id;
	}

	@Override
	public List<Position> run() {
		Session session = null;
		List<Position> positions = new ArrayList<Position>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Position> criteria = builder.createQuery(Position.class);
			Root<Position> root = criteria.from(Position.class);

			criteria.where(builder.equal(root.get("departmentId"), departmentId));
			positions = session.createQuery(criteria).getResultList();
		} catch (HibernateException e) {
			Logger.getLogger(FindAllPositionsByDepartmentId.class)
					.error(ExceptionDescription.HIBERNATE_SESSION_OPEN.fullDescription());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return (positions != null) ? positions : new ArrayList<Position>();
	}

}