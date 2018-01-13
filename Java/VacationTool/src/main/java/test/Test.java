package test;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import vt.app.services.EmployeeService;
import vt.db.controller.dao.DepartmentDao;
import vt.db.controller.dao.EmployeeDao;
import vt.db.controller.dao.interfaces.IDepartment;
import vt.db.controller.dao.interfaces.IEmployee;
import vt.db.model.dao.IGenericDao;
import vt.db.model.entity.Department;
import vt.db.model.entity.Employee;

public class Test {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();
		
		Employee e = dao.findByIdNameSurname(4);
		System.out.println(e.getEmpFirstName() + " " + e.getEmpEvidenceNumber());
		
		
		/*for(int i = 0; i < 10; i++) {
			String s = passwordEncoder().encode("haslo");
			System.out.println(s);
		}*/
		
		
		/*EmployeeDao dao = new EmployeeDao();
		Department entity;
		IGenericDao<Employee> genDao = new EmployeeDao();
		IEmployee depDao = (IEmployee)genDao;*/
		
		
		//IEmployee emp = new EmployeeDao();
		//EmployeeService emp = new EmployeeService();
		//Employee e = emp.getUserByEvidenceNumberLogin("I001");
		//System.out.println(e.getEmpFirstName() + " " + e.getEmpEvidenceNumber());
		
		/*System.out.println("From criteria: " + emp.getUserByEvidenceNumberLogin("I001").getClass().getClassLoader());
		System.out.println("To cast: " + Employee.class.getClassLoader());
		
		Employee e = emp.getUserByEvidenceNumberLogin("I001");
		System.out.println(e.getEmpFirstName() + " " + e.getEmpEvidenceNumber());*/
		
		//Employee e = emp.findByLogin("I001");
		//System.out.println(e.getEmpFirstName() + " " + e.getEmpEvidenceNumber());
		
		/*entity = dao.findById(1);
		System.out.println(entity.getDepName());*/
		
		/*List<Employee> list = new ArrayList<Employee>();
		list = dao.findAll(Employee.class);
		for(Employee d : list) {
			System.out.println(d.getEmpEvidenceNumber());
		}*/
		
		/*entity = dao.findById(6);
		System.out.println("Status usuniecia: " + dao.delete(entity));*/
		
		/*entity = dao.findById(6);
		entity.setDepName("Departamencik");
		System.out.println("Status update: " + dao.update(entity));*/
		
		/*entity = new Department();
		entity.setDepName("Nowo dodany");
		System.out.println("Status dodania: " + dao.save(entity));*/
		
		
		
	}
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}