package com.metacube.parkingSystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.parkingSystem.employeeCredential.EmployeeCredential;
import com.metacube.parkingSystem.model.Employee;
import com.metacube.parkingSystem.model.Vehicle;
import com.metacube.parkingSystem.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;


	public static boolean isSessionValid(HttpSession session, HttpServletResponse res) {
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("employee") == null) {
			return false;
		}
		return true;
	}


	@PostMapping("/registerEmployee")
	public String doRegister(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model) {
		int employeeId;

		if(bindingResult.hasErrors()) {

			return "register";
		}
		else {
			employeeId = employeeService.addEmployee(employee);
			Vehicle vehicle = new Vehicle();
			vehicle.setEmployeeId(employeeId);
			model.addAttribute("vehicle" , vehicle );
			model.addAttribute("employeeId", employeeId);
			return "vehicle";
		}

	}



	@PostMapping("/loginEmployee")
	public String loginEmployee(@Valid @ModelAttribute("employeeCredential") EmployeeCredential employeeCredential, Errors errors,
			HttpSession session) {
		if (errors.hasErrors()) {
			return "login";
		} else {
			String emailId = employeeCredential.getEmailId();
			String password = employeeCredential.getPassword();
			Employee employee = employeeService.checkLogin(emailId, password);
			if (employee == null) {
				return "redirect:login";
			} 
			else {
				System.out.print(employee.getFullName());
				session.setAttribute("employee", employee);
				return "redirect:display";
			} 
		}
	}


	@GetMapping("/getEmployeeDetails")
	public String getEmployeeById(HttpSession session, Model model, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			model.addAttribute("employee", session.getAttribute("employee"));
			return "showEmployeeDetails";
		} else {
			return "redirect:login";
		}

	}


	@PostMapping("/editEmployee")
	public String updateEmployeeDetails(@Valid @ModelAttribute("employee") Employee employee, Errors errors,
			HttpSession session) {
		if (errors.hasErrors()) {
			return "showEmployeeDetails";
		}
		else {
			Employee employee_session = (Employee) session.getAttribute("employee");
			employeeService.updateEmployee(employee_session.getEmployeeId(), employee);
			employee.setEmployeeId(employee_session.getEmployeeId());
			session.setAttribute("employee", employee);
			return "redirect:display";
		}

	}



	@GetMapping("/getFriends")
	public String getFriends(Model model, HttpSession session, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			Employee employee = (Employee) session.getAttribute("employee");
			List<Employee> friends = employeeService.getFriends(employee.getOrganizationName(), employee.getEmployeeId());
			model.addAttribute("friends", friends);
			return "showFriends";
		} else {
			return "redirect:login";
		}
	}

	@GetMapping("getFriend/{employeeId}")
	public String getFriend(@PathVariable("employeeId") int employeeId, Model model, HttpSession session,
			HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			Employee friend = employeeService.getEmployee(employeeId);
			model.addAttribute("friend", friend);
			return "showFriendProfile";
		} else {
			return "redirect:login";
		}
	}

	@GetMapping("/logout")
	public String logoutSession(HttpSession session) {
		session.removeAttribute("employee");
		session.invalidate();
		return "redirect:login";
	}
}









