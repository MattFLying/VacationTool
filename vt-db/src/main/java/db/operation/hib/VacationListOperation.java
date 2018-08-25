package db.operation.hib;

import java.util.List;

import db.entity.Vacation;

/**
 * Interface only for separate operations in this case only for vacation list
 * management.
 * 
 * @author Mateusz Mucha
 *
 */
public interface VacationListOperation extends HibernateOperation<List<Vacation>> {

}