package vt.app.controller;

import javax.servlet.http.HttpSession;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vt.app.controller.base.BaseController;

@Controller
@Secured("ROLE_MANAGER")
public class ManagerController extends BaseController {
	
	
	
	
	
	@RequestMapping(value = "/m/index", method = RequestMethod.GET)
	public String adminIndex(HttpSession session, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		buildMainPanel(session, model, username);
		
		return "m/index";
	}
	
	
	
	
	
	
	
}