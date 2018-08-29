package db.operation.hib;

import java.util.Collection;
import db.entity.Employee;

/**
 * Interface only for separate operations in this case only for employees list
 * management.
 * 
 * @author Mateusz Mucha
 *
 */
public interface EmployeeListOperation extends HibernateOperation<Collection<Employee>> {

}