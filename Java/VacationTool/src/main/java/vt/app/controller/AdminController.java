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
import vt.db.model.entity.Employee;

@Controller
@Secured("ROLE_ADMIN")
public class AdminController extends BaseController {
	
	
	
	
	
	@RequestMapping(value = { "/a/", "/a/index" }, method = RequestMethod.GET)
	public String adminIndex(HttpSession session, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		buildMainPanel(session, model, username);
		
		return "a/index";
	}
	
	
	@RequestMapping(value = "/a/employee", method = RequestMethod.GET)
	public String employee(HttpSession session, Model model) {
		List<Employee> employees = emp.getEmp().findAll(Employee.class);
		model.addAttribute("employees", employees);
		model.addAttribute("employeeform", new Employee());
		model.addAttribute("dept", dept);
		model.addAttribute("pos", pos);
		model.addAttribute("emp", emp);
		
		return "a/employee";
	}
	
	
	
	@RequestMapping(value = "/modifyemployee", method = RequestMethod.POST)
	public String modifyEmployee(@ModelAttribute(value = "employeeform") Employee employee) {
		
		
		
		
		return "a/employee";
	}
	
	
	
	
	
	
	
	
	
	
	
}