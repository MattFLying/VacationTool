package db.operation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import db.entity.VacationType;
import db.operation.VacationTypeManagement;

/**
 * Interface represents repository of vacation type for Spring Data. All
 * possible to use methods by using Spring Data should be there to manage
 * vacation type in database.
 * 
 * @author Mateusz Mucha
 *
 */
@Repository
public interface VacationTypeRepository extends CrudRepository<VacationType, Integer>, VacationTypeManagement {

}