package vt.db.model.entity;
// default package
// Generated 2017-09-26 19:55:22 by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class VtFreeDays.
 * @see .VtFreeDays
 * @author Hibernate Tools
 */
public class VtFreeDaysHome {

	private static final Log log = LogFactory.getLog(VtFreeDaysHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(VtFreeDays transientInstance) {
		log.debug("persisting VtFreeDays instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(VtFreeDays instance) {
		log.debug("attaching dirty VtFreeDays instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VtFreeDays instance) {
		log.debug("attaching clean VtFreeDays instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(VtFreeDays persistentInstance) {
		log.debug("deleting VtFreeDays instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VtFreeDays merge(VtFreeDays detachedInstance) {
		log.debug("merging VtFreeDays instance");
		try {
			VtFreeDays result = (VtFreeDays) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public VtFreeDays findById(int id) {
		log.debug("getting VtFreeDays instance with id: " + id);
		try {
			VtFreeDays instance = (VtFreeDays) sessionFactory.getCurrentSession().get("VtFreeDays", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(VtFreeDays instance) {
		log.debug("finding VtFreeDays instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("VtFreeDays").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
