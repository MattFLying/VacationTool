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
import vt.db.model.entity.Employee;
import vt.db.model.entity.Vacation;

@Controller
@Secured("ROLE_EMPLOYEE")
public class EmployeeController extends BaseController {
	@RequestMapping(value = "/e/index", method = RequestMethod.GET)
	public String adminIndex(HttpSession session, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		buildMainPanel(session, model, username);
		model.addAttribute("emp", new Employee());
		
		return "e/index";
	}
	@RequestMapping(value = "/eupload", method = RequestMethod.POST)
	public ModelAndView uploadImage(@RequestParam("file") MultipartFile file, @ModelAttribute(value = "emp") Employee employee) {
		return uploadAvatar(file, employee, "e");
	}
	@RequestMapping(value = "/changepasswordEmployee", method = RequestMethod.POST)
	public ModelAndView changePasswordEmployee(@ModelAttribute(value = "pwdForm") Employee employeePWD) {
		return changePassword(employeePWD, "e");
	}
	
	
	@RequestMapping(value = "/e/myapplications", method = RequestMethod.GET)
	public ModelAndView myaAplicationsEmployee(HttpSession session, Model model) {
		List<Application> applications = apps.findAllSortedByStatusByEmployeeId((int)session.getAttribute("employeeId"));
		model.addAttribute("applications", applications);
		model.addAttribute("emp", emp);
		model.addAttribute("dept", dept);
		model.addAttribute("pos", pos);
		model.addAttribute("vacType", vacType);
		model.addAttribute("vacations", vacations);
		model.addAttribute("apps", apps);
		model.addAttribute("applicationform", new Application());
		
		return new ModelAndView("e/myapplications");
	}
	@RequestMapping(value = "/create_application_emp", method = RequestMethod.POST)
	public ModelAndView createApplicationEmployee(@ModelAttribute(value = "applicationform") Application application) {
		try {
			application.setAppCreatedDate(createDate());
			application.setAppStatus(ApplicationVerification.WAIT.name());
			application.setAppEmployeeId((int)session.getAttribute("employeeId"));
			application.setAppManagerId((int)session.getAttribute("appManagerId"));
			application.setAppModifiedDate(createModifiedDate());
			
			apps.getApp().save(application);
			
			Vacation vacation = vacations.getfindVacationByEmployeeIdAndVacationType((int)session.getAttribute("employeeId"), application.getAppType());
			int currentDays = vacation.getVacDaysLeft();
			
			vacation.setVacDaysLeft(currentDays - application.getAppDays());
			vacations.getVac().update(vacation);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:e/myapplications");
	}
}