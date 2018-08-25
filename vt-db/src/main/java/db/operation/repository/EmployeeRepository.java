package db.operation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import db.entity.Employee;
import db.operation.EmployeesManagement;

/**
 * Interface represents repository of employee for Spring Data. All possible to
 * use methods by using Spring Data should be there to manage employee in
 * database.
 * 
 * @author Mateusz Mucha
 *
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>, EmployeesManagement {
	Employee findByEvidenceNumber(String evidenceNumber);

	List<Employee> findAllByDepartmentId(Integer departmentId);

	List<Employee> findAllByDepartmentIdAndIdNot(Integer departmentId, Integer id);

	@Query("SELECT new db.entity.Employee(e.id,e.firstName,e.lastName,e.departmentId) FROM Employee e WHERE e.isManager = 1")
	List<Employee> findAllManagers();

	@Query("SELECT CONCAT(e.firstName,' ',e.lastName) FROM Employee e WHERE e.id = :id")
	String findFullNameById(@Param("id") Integer id);

	@Query("SELECT e.avatar FROM Employee e WHERE e.id = :id")
	String findAvatarById(@Param("id") Integer id);

	@Query("SELECT e.departmentId FROM Employee e WHERE e.id = :id")
	Integer findDepartmentIdById(@Param("id") Integer id);

	@Query("SELECT e.positionId FROM Employee e WHERE e.id = :id")
	Integer findPositionIdById(@Param("id") Integer id);

	@Query("SELECT e.managerId FROM Employee e WHERE e.id = :id")
	Integer findManagerIdById(@Param("id") Integer id);

	@Transactional
	@Modifying
	@Query("UPDATE Employee e SET e.password = :password WHERE e.id = :id")
	void changePassword(@Param("password") String password, @Param("id") Integer id);
}