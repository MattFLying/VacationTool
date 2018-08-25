package db.operation.repository;

import java.util.List;

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
	List<Position> findAllByDepartmentId(Integer departmentId);
}