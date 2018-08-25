package db.operation;

import db.entity.Department;

/**
 * Interface with possible operations on departments in database. Should be
 * implemented by all finally strategies depending than type of using ORM.
 * 
 * @author Mateusz Mucha
 *
 */
public interface DepartmentManagement extends DatabaseOperations<Department> {

}