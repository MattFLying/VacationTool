package db.operation.hib;

import java.util.List;
import db.entity.Employee;

/**
 * Interface only for separate operations in this case only for employees list
 * management.
 * 
 * @author Mateusz Mucha
 *
 */
public interface EmployeeListOperation extends HibernateOperation<List<Employee>> {

}