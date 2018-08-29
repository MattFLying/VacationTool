package db.operation.repository.sd;

import java.util.Collection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import db.entity.Application;
import db.operation.ApplicationManagement;

/**
 * Interface represents repository of vacation applications for Spring Data. All
 * possible to use methods by using Spring Data should be there to manage
 * applications in database.
 * 
 * @author Mateusz Mucha
 *
 */
@Repository
public interface ApplicationRepository extends PagingAndSortingRepository<Application, Integer>, ApplicationManagement {
	Collection<Application> findAllByOrderByStatusDescCreatedDateDesc();

	Collection<Application> findAllByManagerIdOrderByStatusDescCreatedDateDesc(@Param("managerId") Integer managerId);

	Collection<Application> findAllByEmployeeIdOrderByStatusDescCreatedDateDesc(@Param("employeeId") Integer employeeId);
}