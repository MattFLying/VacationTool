package vt.app.services;

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
	public Employee getEmployeeNameSurnameById(int id) {
		return this.emp.findByIdNameSurname(id);
	}
	
	
	
	
	
	
	
	
	
}