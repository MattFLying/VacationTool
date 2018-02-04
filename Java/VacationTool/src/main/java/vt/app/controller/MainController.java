package vt.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController implements ErrorController {
	private static final String ERROR_PAGE = "failure";
	
	@RequestMapping(value = { "/", "index" })
	public String home() {
		return "index";
	}
	@RequestMapping(value = { "/login" })
	public String login() {
		return "login";
	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}
	@RequestMapping(value = "/failure")
	public String failure() {
		return ERROR_PAGE;
	}
	@RequestMapping(value = "/error")
    public String error() {
        return ERROR_PAGE;
    }
	@Override
	public String getErrorPath() {
		return ERROR_PAGE;
	}
}