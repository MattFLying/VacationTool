package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import db.operation.repository.EmployeeRepository;

/**
 * Main controller allow to use basic pages and operations in the web
 * application.
 * 
 * @author Mateusz Mucha
 *
 */
@Controller
public class MainController {
	@Autowired
	EmployeeRepository employeeRepository;
	
	

	@GetMapping("/")
	public String home(Model model) {
		String fullName = employeeRepository.findFullNameById(1);
		
		
		
		System.out.println(":: Full name: " + fullName);
		

		model.addAttribute("fullName", fullName);
		
		
		
		
		return "index";
	}

}