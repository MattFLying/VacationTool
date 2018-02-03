package test;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import vt.app.services.DepartmentService;
import vt.app.services.EmployeeService;
import vt.app.services.PositionService;
import vt.db.controller.dao.DepartmentDao;
import vt.db.controller.dao.EmployeeDao;
import vt.db.controller.dao.interfaces.IDepartment;
import vt.db.controller.dao.interfaces.IEmployee;
import vt.db.model.dao.IGenericDao;
import vt.db.model.entity.Department;
import vt.db.model.entity.Employee;
import vt.db.model.entity.Position;

public class Test {

	public static void main(String[] args) {
		
		
		Date d = new Date();
		
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyy HH:mm:ss");


		String s1 = df.format(new Date());
		String s2 = df.format(new Date());
		
		System.out.println(s1);
		System.out.println(s2);
		
		
		
		/*EmployeeDao dao = new EmployeeDao();
		
		Employee e = dao.findByIdNameSurname(4);
		System.out.println(e.getEmpFirstName() + " " + e.getEmpEvidenceNumber());*/
		/*String s = "22-11-1992";
		System.out.println(s.substring(0, 2));
		System.out.println(s.substring(3, 5));
		System.out.println(s.substring(6, 10));*/
		/*DepartmentService ds = new DepartmentService();
		for(Department d : ds.getAllDepartments()) {
			System.out.println(d.getId());
		}*/
		/*PositionService ds = new PositionService();
		for(Position d : ds.getAllPositionsForDepartment(2)) {
			System.out.println(d.getId());
		}*/
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
