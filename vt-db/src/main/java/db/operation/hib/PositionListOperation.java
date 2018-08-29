package db.operation.hib;

import java.util.Collection;
import db.entity.Position;

/**
 * Interface only for separate operations in this case only for position list
 * management.
 * 
 * @author Mateusz Mucha
 *
 */
public interface PositionListOperation extends HibernateOperation<Collection<Position>> {

}