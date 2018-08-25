package db.operation.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import db.entity.Vacation;
import db.operation.VacationManagement;

/**
 * Interface represents repository of vacation for Spring Data. All possible to
 * use methods by using Spring Data should be there to manage vacation in
 * database.
 * 
 * @author Mateusz Mucha
 *
 */
@Repository
public interface VacationRepository extends CrudRepository<Vacation, Integer>, VacationManagement {
	List<Vacation> findAllByEmployeeId(Integer employeeId);

	List<Vacation> findAllByEmployeeIdAndVacationType(Integer employeeId, Integer vacationType);
}