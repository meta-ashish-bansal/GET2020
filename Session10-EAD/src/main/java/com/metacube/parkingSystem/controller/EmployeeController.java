package com.metacube.parkingSystem.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.metacube.parkingSystem.employeeCredential.EmployeeCredential;
import com.metacube.parkingSystem.model.Employee;
import com.metacube.parkingSystem.model.Vehicle;
import com.metacube.parkingSystem.service.EmployeeService;
import com.metacube.parkingSystem.serviceImpl.ImageService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ImageService imageService;


	public static boolean isSessionValid(HttpSession session, HttpServletResponse res) {
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("employee") == null) {
			return false;
		}
		return true;
	}

	public String searchImage(int employeeId) {
		File folder = new File("C:\\Users\\Jitendra\\Documents\\workspace-spring-tool-suite-4-4.5.1.RELEASE\\MetacubeParkingSystem\\src\\main\\resources\\static\\images\\");
		String imagePath = "http://localhost:8080/images/user.png";
		for (File f: folder.listFiles()) {
			if ((employeeId + ".png").equals(f.getName())) {
				imagePath = "http://localhost:8080/images/" + f.getName();
			}
		}
		return imagePath;
	}

	@PostMapping("/uploadImage")
	public String uploadImage(@RequestParam("image") MultipartFile imageFile, HttpSession session) {
		try {
			Employee employee = (Employee) session.getAttribute("employee");
			int employeeId = employee.getEmployeeId();
			if (!imageFile.getOriginalFilename().contains(".png")) {
				return "redirect:display";
			}
			imageService.saveImage(imageFile, employeeId);
			session.setAttribute("imagePath", "http://localhost:8080/images/" + employeeId + ".png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:display";
	}




	@PostMapping("/registerEmployee")
	public String doRegister(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model) {
		int employeeId;

		if(bindingResult.hasErrors()) {

			return "register";
		}
		else {
			employeeId = employeeService.addEmployee(employee);
			if(employeeId == 0) {
				return "redirect:login";
			}
			else if(employeeId == -1) {
				return "register";
			}
			else {
				Vehicle vehicle = new Vehicle();
				vehicle.setEmployeeId(employeeId);
				model.addAttribute("vehicle" , vehicle );
				model.addAttribute("employeeId", employeeId);
				return "vehicle";
			}
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
				session.setAttribute("employee", employee);
				session.setAttribute("imagePath", searchImage(employee.getEmployeeId()));
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
			System.out.println(errors.toString());
			return "showEmployeeDetails";
		}
		else {
			Employee employee_session = (Employee) session.getAttribute("employee");

			employeeService.updateEmployee(employee_session.getEmployeeId(), employee);
			System.out.println("edit");
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









