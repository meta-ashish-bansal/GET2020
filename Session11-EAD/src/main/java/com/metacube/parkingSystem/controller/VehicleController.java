package com.metacube.parkingSystem.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.parkingSystem.model.Employee;
import com.metacube.parkingSystem.model.Pass;
import com.metacube.parkingSystem.model.Vehicle;
import com.metacube.parkingSystem.service.EmployeeService;
import com.metacube.parkingSystem.service.VehicleService;

@Controller
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private EmployeeService employeeService;


	public static boolean isSessionValid(HttpSession session, HttpServletResponse res) {
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("employee") == null) {
			return false;
		}
		return true;
	}

	@PostMapping("/registerVehicle")
	public String doRegister(@Validated @ModelAttribute("vehicle") Vehicle vehicle,@RequestParam("employeeId") int employeeId,  BindingResult bindingResult, Model model) {
		int vehicleId;

		if(bindingResult.hasErrors()) {

			return "vehicle";
		}
		else {

			Employee employee = employeeService.getEmployee(employeeId);
			vehicle.setEmployee(employee);
			vehicleId = vehicleService.addVehicle(vehicle);
			String vehicleType = vehicle.getVehicleType();
			model.addAttribute("pass" , new Pass());
			model.addAttribute("vehicleId", vehicleId);
			model.addAttribute("vehicleType",vehicleType);
			return "pass";
		}

	}


	@GetMapping("/getVehicleDetails")
	public String getVehicleById(HttpSession session, Model model, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			Employee employee = (Employee) session.getAttribute("employee");
			Vehicle vehicle = vehicleService.getVehicle(employee.getEmployeeId());
			model.addAttribute("employee", employee);
			model.addAttribute("vehicle", vehicle);
			return "showVehicleDetails";
		} else {
			return "redirect:login";
		}

	}


	@PostMapping("/editVehicle")
	public String updateVehicleDetails(@Valid @ModelAttribute("vehicle") Vehicle vehicle, Errors errors,
			HttpSession session) {
		if (errors.hasErrors()) {
			System.out.println(errors.toString());
			return "showVehicleDetails";
		}
		else {
			Employee employee = (Employee) session.getAttribute("employee");
			Vehicle vehicleUpdate = vehicleService.getVehicle(employee.getEmployeeId());
			vehicle.setVehicleId(vehicleUpdate.getVehicleId());
			vehicle.setEmployee(employee);
			vehicleService.updateVehicle(vehicle);
			return "redirect:getPassDetails";
		}

	}

}
