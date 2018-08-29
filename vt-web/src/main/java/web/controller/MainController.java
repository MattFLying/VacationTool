package web.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import db.operation.repository.hib.EmployeeDao;
import db.operation.repository.sd.EmployeeRepository;

/**
 * Main controller allow to use basic pages and operations in the web
 * application.
 * 
 * @author Mateusz Mucha
 *
 */
@Controller
public class MainController {
	
	

	@GetMapping("/")
	public String home(Model model) {
		
		
		
		
		
		return "index";
	}

}