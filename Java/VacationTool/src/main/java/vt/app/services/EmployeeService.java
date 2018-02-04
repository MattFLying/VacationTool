package vt.app.services;

import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vt.db.controller.dao.EmployeeDao;
import vt.db.controller.dao.interfaces.IEmployee;
import vt.db.model.entity.Employee;

@Service
public class EmployeeService {
	private IEmployee emp;
	

	public EmployeeService() {
		this.emp = new EmployeeDao();
	}
	

	public IEmployee getEmp() {
		return emp;
	}
	public Employee getEmployeeByEvidenceNumberLogin(String login) {
		return this.emp.findByLogin(login);
	}
	public Employee getEmployeeById(int id) {
		return this.emp.findById(id);
	}
	public Employee getEmployeeNameSurnameById(Integer id) {
		return this.emp.findByIdNameSurname(id);
	}
	public Employee getEmployeeDepartmentById(int id) {
		return this.emp.findByIdDepartment(id);
	}
	public Employee getEmployeeAvatarById(int id) {
		return this.emp.findByIdAvatar(id);
	}
	public Employee getEmployeePositionById(int id) {
		return this.emp.findByIdPosition(id);
	}
	public Employee getManagerOfEmployeeById(int id) {
		return this.emp.findByIdManager(id);
	}
	public List<Employee> getAllManagers() {
		return this.emp.findAllManagers();
	}
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	public List<Employee> getAllEmployeesFromDepartment(int departmentId) {
		return this.emp.findAllEmployeesFromDepartment(departmentId);
	}
	public List<Employee> getAllEmployeesFromDepartmentWithoutId(int departmentId, int employeeId) {
		return this.emp.findAllEmployeesFromDepartmentWithoutId(departmentId, employeeId);
	}
	public void changePassword(Employee employee, String oldPassword, String newPassword) {
		String password = passwordEncoder().encode(newPassword);
		
		employee.setEmpPassword(password);
		emp.update(employee);
	}
}