package vt.app.services;

import org.springframework.stereotype.Service;
import vt.db.controller.dao.DepartmentDao;
import vt.db.controller.dao.interfaces.IDepartment;
import vt.db.model.entity.Department;

@Service
public class DepartmentService {
	private IDepartment dept;
	
	


	public DepartmentService() {
		this.dept = new DepartmentDao();
	}
	

	public IDepartment getDept() {
		return dept;
	}
	public Department getDepartmentById(int id) {
		return dept.findById(id);
	}
	
	
	
	
}