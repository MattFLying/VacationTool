package vt.app.services;

import java.util.List;

import org.springframework.stereotype.Service;
import vt.db.controller.dao.DepartmentDao;
import vt.db.controller.dao.interfaces.IDepartment;
import vt.db.model.entity.Department;
import vt.db.model.entity.Position;

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
	public List<Department> getAllDepartments() {
		return this.dept.findAllDepartments();
	}
	
	
	
	
}