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

import com.metacube.parkingSystem.model.Employee;
import com.metacube.parkingSystem.model.Pass;
import com.metacube.parkingSystem.model.Vehicle;
import com.metacube.parkingSystem.service.VehicleService;

@Controller
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;


	public static boolean isSessionValid(HttpSession session, HttpServletResponse res) {
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("employee") == null) {
			return false;
		}
		return true;
	}

	@PostMapping("/registerVehicle")
	public String doRegister(@Validated @ModelAttribute("vehicle") Vehicle vehicle, BindingResult bindingResult, Model model) {
		int vehicleId;

		if(bindingResult.hasErrors()) {

			return "vehicle";
		}
		else {

			vehicleId = vehicleService.addVehicle(vehicle);
			String vehicleType = vehicle.getVehicleType();
			System.out.println("vehicle reg" + vehicleType);
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
			return "showVehicleDetails";
		}
		else {
			Employee employee = (Employee) session.getAttribute("employee");
			Vehicle vehicleUpdate = vehicleService.getVehicle(employee.getEmployeeId());

			vehicleService.updateVehicle(vehicleUpdate.getVehicleId(), vehicle);
			return "redirect:getPassDetails";
		}

	}

}
