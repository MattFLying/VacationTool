package db.operation.hib;

import java.util.List;

import db.entity.Application;

/**
 * Interface only for separate operations in this case only for application list
 * management.
 * 
 * @author Mateusz Mucha
 *
 */
public interface ApplicationListOperation extends HibernateOperation<List<Application>> {

}