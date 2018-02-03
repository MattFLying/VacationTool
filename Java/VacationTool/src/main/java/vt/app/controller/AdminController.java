package vt.app.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import vt.app.controller.base.ApplicationVerification;
import vt.app.controller.base.BaseController;
import vt.db.model.entity.Application;
import vt.db.model.entity.Department;
import vt.db.model.entity.Employee;
import vt.db.model.entity.FreeDays;
import vt.db.model.entity.Position;
import vt.db.model.entity.Vacation;
import vt.db.model.entity.VacationType;

@Controller
@Secured("ROLE_ADMIN")
public class AdminController extends BaseController {
	@RequestMapping(value = { "/a/", "/a/index" }, method = RequestMethod.GET)
	public ModelAndView adminIndex(HttpSession session, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		buildMainPanel(session, model, username);
		model.addAttribute("emp", new Employee());
		
		return new ModelAndView("a/index");
	}
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView uploadImage(@RequestParam("file") MultipartFile file, @ModelAttribute(value = "emp") Employee employee) {
		return uploadAvatar(file, employee, "a");
	}
	
	
	@RequestMapping(value = "/a/employee", method = RequestMethod.GET)
	public ModelAndView employee(HttpSession session, Model model) {
		List<Employee> employees = emp.getEmp().findAll(Employee.class);
		model.addAttribute("employees", employees);
		model.addAttribute("employeeform", new Employee());
		model.addAttribute("dept", dept);
		model.addAttribute("pos", pos);
		model.addAttribute("emp", emp);
		
		return new ModelAndView("a/employee");
	}
	@RequestMapping(value = "/modifyemployee", method = RequestMethod.POST)
	public ModelAndView modifyEmployee(@ModelAttribute(value = "employeeform") Employee employee) {
		try {
			emp.getEmp().update(employee);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/employee");
	}
	@RequestMapping(value = "/deleteemployee", method = RequestMethod.POST)
	public ModelAndView deleteEmployee(@ModelAttribute(value = "employeeform") Employee employee) {
		try {
			emp.getEmp().delete(employee);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/employee");
	}
	@RequestMapping(value = "/addemployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute(value = "employeeform") Employee employee) {
		String pwd = emp.passwordEncoder().encode(employee.getEmpPassword());
		employee.setEmpPassword(pwd);
		try {
			String dep = dept.getDepartmentById(employee.getEmpDepartmentId()).getDepName().substring(0, 1);
			int id = emp.getEmp().save(employee);
			
			String number = dep.concat(String.valueOf(0)).concat(String.valueOf(id));
			employee.setEmpEvidenceNumber(number);
			emp.getEmp().update(employee);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/employee");
	}
	@RequestMapping(value = "/a/department", method = RequestMethod.GET)
	public ModelAndView department(HttpSession session, Model model) {
		List<Department> departments = dept.getDept().findAll(Department.class);
		model.addAttribute("departments", departments);
		model.addAttribute("departmentform", new Department());
		model.addAttribute("positionform", new Position());
		model.addAttribute("pos", pos);
		
		return new ModelAndView("a/department");
	}
	@RequestMapping(value = "/modifydepartment", method = RequestMethod.POST)
	public ModelAndView modifyDepartment(@ModelAttribute(value = "departmentform") Department department) {
		try {
			dept.getDept().update(department);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/department");
	}
	@RequestMapping(value = "/deletedepartment", method = RequestMethod.POST)
	public ModelAndView deleteDepartment(@ModelAttribute(value = "departmentform") Department department) {
		try {
			dept.getDept().delete(department);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/department");
	}
	@RequestMapping(value = "/adddepartment", method = RequestMethod.POST)
	public ModelAndView addDepartment(@ModelAttribute(value = "departmentform") Department department) {
		try {
			dept.getDept().save(department);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/department");
	}
	@RequestMapping(value = "/modifyposition", method = RequestMethod.POST)
	public ModelAndView modifyPosition(@ModelAttribute(value = "positionform") Position position) {
		try {
			pos.getPos().update(position);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/department");
	}
	@RequestMapping(value = "/deleteposition", method = RequestMethod.POST)
	public ModelAndView deletePosition(@ModelAttribute(value = "positionform") Position position) {
		try {
			pos.getPos().delete(position);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/department");
	}
	@RequestMapping(value = "/addposition", method = RequestMethod.POST)
	public ModelAndView addPosition(@ModelAttribute(value = "positionform") Position position) {
		try {
			pos.getPos().save(position);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/department");
	}
	@RequestMapping(value = "/a/vacationtype", method = RequestMethod.GET)
	public ModelAndView vacationType(HttpSession session, Model model) {
		List<VacationType> vacationTypes = vacType.getVacType().findAll(VacationType.class);
		model.addAttribute("vacationTypes", vacationTypes);
		model.addAttribute("vacationTypeform", new VacationType());
		
		return new ModelAndView("a/vacationtype");
	}
	@RequestMapping(value = "/modifyvactype", method = RequestMethod.POST)
	public ModelAndView modifyVacationType(@ModelAttribute(value = "vacationTypeform") VacationType vacationType) {
		try {
			vacType.getVacType().update(vacationType);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/vacationtype");
	}
	@RequestMapping(value = "/addvactype", method = RequestMethod.POST)
	public ModelAndView addVacationType(@ModelAttribute(value = "vacationTypeform") VacationType vacationType) {
		try {
			vacType.getVacType().save(vacationType);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/vacationtype");
	}
	@RequestMapping(value = "/deletevactype", method = RequestMethod.POST)
	public ModelAndView deletVacationType(@ModelAttribute(value = "vacationTypeform") VacationType vacationType) {
		try {
			vacType.getVacType().delete(vacationType);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/vacationtype");
	}
	@RequestMapping(value = "/a/freedays", method = RequestMethod.GET)
	public ModelAndView freeDays(HttpSession session, Model model) {
		List<FreeDays> freeDaysList = freeDays.getFreeDays().findAll(FreeDays.class);
		model.addAttribute("freeDays", freeDaysList);
		model.addAttribute("freeDaysform", new FreeDays());
		model.addAttribute("freedayNames", freeDays);
		
		return new ModelAndView("a/freedays");
	}
	@RequestMapping(value = "/modifyfreedays", method = RequestMethod.POST)
	public ModelAndView modifyFreeDays(@ModelAttribute(value = "vacationTypeform") FreeDays freeDay) {
		try {
			freeDays.getFreeDays().update(freeDay);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/freedays");
	}
	@RequestMapping(value = "/deletefreedays", method = RequestMethod.POST)
	public ModelAndView deleteFreeDays(@ModelAttribute(value = "vacationTypeform") FreeDays freeDay) {
		try {
			freeDays.getFreeDays().delete(freeDay);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/freedays");
	}
	@RequestMapping(value = "/addfreedays", method = RequestMethod.POST)
	public ModelAndView addFreeDays(@ModelAttribute(value = "vacationTypeform") FreeDays freeDay) {
		try {
			freeDays.getFreeDays().save(freeDay);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/freedays");
	}
	@RequestMapping(value = "/a/vacationmanage", method = RequestMethod.GET)
	public ModelAndView vacationManage(HttpSession session, Model model) {
		List<Employee> employees = emp.getEmp().findAll(Employee.class);
		model.addAttribute("employees", employees);
		model.addAttribute("employeeform", new Employee());
		model.addAttribute("vacationform", new Vacation());
		model.addAttribute("dept", dept);
		model.addAttribute("pos", pos);
		model.addAttribute("vac", vacations);
		model.addAttribute("vacType", vacType);
		
		return new ModelAndView("a/vacationmanage");
	}
	@RequestMapping(value = "/addvacationmanage", method = RequestMethod.POST)
	public ModelAndView addVacationManage(@ModelAttribute(value = "vacationform") Vacation vacation) {
		try {
			int vacTypeId = vacation.getVacType();
			VacationType vacationType = vacType.getVacationTypeById(vacTypeId);
			vacation.setVacDaysLeft(vacationType.getVacTypeMaxDays());
			
			vacations.getVac().save(vacation);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/vacationmanage");
	}
	@RequestMapping(value = "/deletevacationmanage", method = RequestMethod.POST)
	public ModelAndView deleteVacationManage(@ModelAttribute(value = "vacationform") Vacation vacation) {
		try {
			vacations.getVac().delete(vacation);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/vacationmanage");
	}
	@RequestMapping(value = "/modifyvacationmanage", method = RequestMethod.POST)
	public ModelAndView modifyVacationManage(@ModelAttribute(value = "vacationform") Vacation vacation) {
		try {
			Vacation v = vacations.getVacationById(vacation.getId());
			vacation.setVacEmployeeId(v.getVacEmployeeId());
			
			if(vacation.getVacType() == 0) {
				vacation.setVacType(v.getVacType());
			}
			
			vacations.getVac().update(vacation);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/vacationmanage");
	}
	@RequestMapping(value = "/a/application", method = RequestMethod.GET)
	public ModelAndView application(HttpSession session, Model model) {
		List<Application> applications = apps.getApp().findAllSortedByStatus();
		model.addAttribute("applications", applications);
		model.addAttribute("emp", emp);
		model.addAttribute("dept", dept);
		model.addAttribute("pos", pos);
		model.addAttribute("vacType", vacType);
		model.addAttribute("apps", apps);
		model.addAttribute("applicationform", new Application());
		
		return new ModelAndView("a/application");
	}
	@RequestMapping(value = "/deleteapplication", method = RequestMethod.POST)
	public ModelAndView deleteApplication(@ModelAttribute(value = "applicationform") Application application) {
		try {
			apps.getApp().delete(application);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/application");
	}
	@RequestMapping(value = "/declineapplication", method = RequestMethod.POST)
	public ModelAndView declineApplication(@ModelAttribute(value = "applicationform") Application application) {
		try {
			Application a = apps.getApp().findById(application.getId());
			a.setAppManagerComment(application.getAppManagerComment());
			a.setAppStatus(ApplicationVerification.DECLINED.name());
			a.setAppAcceptedDate(createDate());
			a.setAppAcceptedManager((int)session.getAttribute("employeeId"));
			
			apps.getApp().update(a);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/application");
	}
	@RequestMapping(value = "/acceptapplication", method = RequestMethod.POST)
	public ModelAndView acceptApplication(@ModelAttribute(value = "applicationform") Application application) {
		try {
			Application a = apps.getApp().findById(application.getId());
			a.setAppManagerComment(application.getAppManagerComment());
			a.setAppStatus(ApplicationVerification.ACCEPTED.name());
			a.setAppAcceptedDate(createDate());
			a.setAppAcceptedManager((int)session.getAttribute("employeeId"));
			
			apps.getApp().update(a);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:a/application");
	}
}