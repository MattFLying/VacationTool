package db.operation.repository.sd;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import db.entity.Department;
import db.operation.DepartmentManagement;

/**
 * Interface represents repository of department for Spring Data. All possible
 * to use methods by using Spring Data should be there to manage department in
 * database.
 * 
 * @author Mateusz Mucha
 *
 */
@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer>, DepartmentManagement {

}