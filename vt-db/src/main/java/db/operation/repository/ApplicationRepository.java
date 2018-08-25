package db.operation.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import db.entity.Application;

/**
 * Interface represents repository of vacation applications for Spring Data. All
 * possible to use methods by using Spring Data should be there to manage
 * applications in database.
 * 
 * @author Mateusz Mucha
 *
 */
@Repository
public interface ApplicationRepository extends PagingAndSortingRepository<Application, Integer> {
	List<Application> findAllByOrderByStatusDescCreatedDateDesc();

	List<Application> findAllByManagerIdOrderByStatusDescCreatedDateDesc(@Param("managerId") Integer managerId);

	List<Application> findAllByEmployeeIdOrderByStatusDescCreatedDateDesc(@Param("employeeId") Integer employeeId);
}