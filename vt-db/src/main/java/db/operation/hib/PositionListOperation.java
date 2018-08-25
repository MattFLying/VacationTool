package db.operation.hib;

import java.util.List;

import db.entity.Position;

/**
 * Interface only for separate operations in this case only for position list
 * management.
 * 
 * @author Mateusz Mucha
 *
 */
public interface PositionListOperation extends HibernateOperation<List<Position>> {

}