package db.operation.hib;

import java.util.Collection;
import db.entity.Application;

/**
 * Interface only for separate operations in this case only for application list
 * management.
 * 
 * @author Mateusz Mucha
 *
 */
public interface ApplicationListOperation extends HibernateOperation<Collection<Application>> {

}