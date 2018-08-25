package db.operation;

import java.util.List;

import db.entity.Position;

/**
 * Interface with possible operations on positions in database. Should be
 * implemented by all finally strategies depending than type of using ORM.
 * 
 * @author Mateusz Mucha
 *
 */
public interface PositionManagement extends DatabaseOperations<Position> {
	/**
	 * Method to find all positions exists in specific department.
	 * 
	 * @param departmentId
	 *            identificator of department
	 * @return list of positions of department
	 */
	List<Position> findAllByDepartmentId(Integer departmentId);
}