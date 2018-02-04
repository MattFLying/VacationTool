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
@Secured("ROLE_MANAGER")
public class ManagerController extends BaseController {
	@RequestMapping(value = "/m/index", method = RequestMethod.GET)
	public String adminIndex(HttpSession session, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		buildMainPanel(session, model, username);
		model.addAttribute("emp", new Employee());
		
		return "m/index";
	}
	@RequestMapping(value = "/mupload", method = RequestMethod.POST)
	public ModelAndView uploadImage(@RequestParam("file") MultipartFile file, @ModelAttribute(value = "emp") Employee employee) {
		return uploadAvatar(file, employee, "m");
	}
	@RequestMapping(value = "/changepasswordManager", method = RequestMethod.POST)
	public ModelAndView changePasswordManager(@ModelAttribute(value = "pwdForm") Employee employeePWD) {
		return changePassword(employeePWD, "m");
	}
	
	
	@RequestMapping(value = "/m/application", method = RequestMethod.GET)
	public ModelAndView applicationManager(HttpSession session, Model model) {
		List<Application> applications = apps.findAllForManagerSortedByStatus((int)session.getAttribute("employeeId"));
		model.addAttribute("applications", applications);
		model.addAttribute("emp", emp);
		model.addAttribute("dept", dept);
		model.addAttribute("pos", pos);
		model.addAttribute("vacType", vacType);
		model.addAttribute("vacations", vacations);
		model.addAttribute("apps", apps);
		model.addAttribute("applicationform", new Application());
		
		return new ModelAndView("m/application");
	}
	@RequestMapping(value = "/deleteapplicationmanager", method = RequestMethod.POST)
	public ModelAndView deleteApplicationManager(@ModelAttribute(value = "applicationform") Application application) {
		try {
			apps.getApp().delete(application);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:m/application");
	}
	@RequestMapping(value = "/declineapplicationmanager", method = RequestMethod.POST)
	public ModelAndView declineApplicationManager(@ModelAttribute(value = "applicationform") Application application) {
		try {
			Application a = apps.getApp().findById(application.getId());
			a.setAppManagerComment(application.getAppManagerComment());
			a.setAppStatus(ApplicationVerification.DECLINED.name());
			a.setAppAcceptedDate(createDate());
			a.setAppAcceptedManager((int)session.getAttribute("employeeId"));
			
			apps.getApp().update(a);
			
			Vacation vacation = vacations.getfindVacationByEmployeeIdAndVacationType(a.getAppEmployeeId(), a.getAppType());
			int currentDays = vacation.getVacDaysLeft();
			
			vacation.setVacDaysLeft(currentDays + a.getAppDays());
			vacations.getVac().update(vacation);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:m/application");
	}
	@RequestMapping(value = "/acceptapplicationmanager", method = RequestMethod.POST)
	public ModelAndView acceptApplicationManager(@ModelAttribute(value = "applicationform") Application application) {
		try {
			boolean daysLeftShouldBeChanged = false;
			
			Application a = apps.getApp().findById(application.getId());
			if(a.getAppStatus().equals(ApplicationVerification.DECLINED.name())) {
				daysLeftShouldBeChanged = true;
			}
			
			a.setAppManagerComment(application.getAppManagerComment());
			a.setAppStatus(ApplicationVerification.ACCEPTED.name());
			a.setAppAcceptedDate(createDate());
			a.setAppAcceptedManager((int)session.getAttribute("employeeId"));
			
			apps.getApp().update(a);
			
			if(daysLeftShouldBeChanged) {
				Vacation vacation = vacations.getfindVacationByEmployeeIdAndVacationType(a.getAppEmployeeId(), a.getAppType());
				int currentDays = vacation.getVacDaysLeft();
				
				vacation.setVacDaysLeft(currentDays - a.getAppDays());
				vacations.getVac().update(vacation);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:m/application");
	}
	@RequestMapping(value = "/m/myapplications", method = RequestMethod.GET)
	public ModelAndView myaAplicationsManager(HttpSession session, Model model) {
		List<Application> applications = apps.findAllSortedByStatusByEmployeeId((int)session.getAttribute("employeeId"));
		model.addAttribute("applications", applications);
		model.addAttribute("emp", emp);
		model.addAttribute("dept", dept);
		model.addAttribute("pos", pos);
		model.addAttribute("vacType", vacType);
		model.addAttribute("vacations", vacations);
		model.addAttribute("apps", apps);
		model.addAttribute("applicationform", new Application());
		
		return new ModelAndView("m/myapplications");
	}
	@RequestMapping(value = "/create_application", method = RequestMethod.POST)
	public ModelAndView createApplication(@ModelAttribute(value = "applicationform") Application application) {
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
		return new ModelAndView("redirect:m/myapplications");
	}
}