package com.metacube.parkingSystem.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.metacube.parkingSystem.employeeCredential.EmployeeCredential;
import com.metacube.parkingSystem.model.Employee;

@Controller
@PropertySource("classpath:application.yml")
public class HomeController {

	@Value("${home.message}")
	private  String message;


	public static boolean isSessionValid(HttpSession session, HttpServletResponse res) {
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("employee") == null) {
			return false;
		}
		return true;
	}


	@GetMapping({"/" , "/home"})
	public String home(Model model) {
		model.addAttribute("msg", message);
		System.out.println("home controller");
		return "Home";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("employee", new Employee());
		System.out.println("registration page");
		return "register";
	}

	@GetMapping("/login")
	public String getLoginPage(Model model) {
		model.addAttribute("employeeCredential", new EmployeeCredential());
		return "login";
	}

	@GetMapping("/display")
	public String getDisplayPage(HttpSession session, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			return "display";
		} else {
			return "redirect:login";
		}

	}
	
	
}
