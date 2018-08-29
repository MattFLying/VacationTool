package db.operation.repository.sd;

import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import db.entity.Position;
import db.operation.PositionManagement;

/**
 * Interface represents repository of position for Spring Data. All possible to
 * use methods by using Spring Data should be there to manage position in
 * database.
 * 
 * @author Mateusz Mucha
 *
 */
@Repository
public interface PositionRepository extends CrudRepository<Position, Integer>, PositionManagement {
	Collection<Position> findAllByDepartmentId(Integer departmentId);
}