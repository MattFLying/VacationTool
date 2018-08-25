package db.operation;

import db.entity.VacationType;

/**
 * Interface with possible operations on vacation types in database. Should be
 * implemented by all finally strategies depending than type of using ORM.
 * 
 * @author Mateusz Mucha
 *
 */
public interface VacationTypeManagement extends DatabaseOperations<VacationType> {

}