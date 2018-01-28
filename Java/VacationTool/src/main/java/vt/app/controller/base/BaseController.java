package vt.app.controller.base;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vt.app.services.DepartmentService;
import vt.app.services.EmployeeService;
import vt.app.services.FreeDaysService;
import vt.app.services.PositionService;
import vt.app.services.VacationService;
import vt.app.services.VacationTypeService;
import vt.db.model.entity.Department;
import vt.db.model.entity.Employee;
import vt.db.model.entity.Position;

public abstract class BaseController {
	protected EmployeeService emp = new EmployeeService();
	protected DepartmentService dept = new DepartmentService();
	protected PositionService pos = new PositionService();
	protected VacationTypeService vacType = new VacationTypeService();
	protected FreeDaysService freeDays = new FreeDaysService();
	protected VacationService vacations = new VacationService();
	protected int departmentId, managerId = 0;
	
	public ModelAndView uploadAvatar(MultipartFile file, Employee employee, String page) {
		byte[] bytes = null;
		try {
			Employee entity = emp.getEmp().findById(employee.getId());
			bytes = file.getBytes();
			
			byte[] encodeBase64 = Base64.getEncoder().encode(bytes);
			String base64Encoded = new String(encodeBase64, "UTF-8");
			
			entity.setEmpAvatar(base64Encoded.trim());
			emp.getEmp().update(entity);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:" + page + "/index");
	}
	protected void buildMainPanel(HttpSession session, Model model, String username) {
		session.setAttribute("username", username);
		
		Employee employee = emp.getEmployeeByEvidenceNumberLogin(username);
		model.addAttribute("employee", employee);
		model.addAttribute("areaOfWork", formatAreaOfWork(employee.getEmpAreaOfWork()));
		
		Employee manager = emp.getEmployeeById(employee.getEmpManagerId());
		model.addAttribute("manager", formatManager(manager, employee));
		
		Position position = pos.getPositionById(employee.getEmpPositionId());
		model.addAttribute("position", position);
		
		Department department = dept.getDepartmentById(employee.getEmpDepartmentId());
		model.addAttribute("department", department);
	}
	protected String formatManager(Employee manager, Employee employee) {
		if(manager.getId() == employee.getId()) {
			return "brak";
		} else {
			return manager.getNameAndSurname();
		}
	}
	protected String formatAreaOfWork(double area) {
		if(area == 1.0) {
			return "Pełny Etat";
		} else if(area == 0.5) {
			return "1/2 Etatu";
		} else if(area == 0.25) {
			return "1/4 Etatu";
		} else if(area == 0.75) {
			return "3/4 Etatu";
		} else {
			return String.valueOf(area);
		}
	}
}