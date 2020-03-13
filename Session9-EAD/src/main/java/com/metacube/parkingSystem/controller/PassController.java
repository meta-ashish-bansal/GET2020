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
import com.metacube.parkingSystem.service.PassService;
import com.metacube.parkingSystem.service.VehicleService;

@Controller
public class PassController {

	@Autowired
	private PassService passService;

	@Autowired
	private VehicleService vehicleService;

	public static boolean isSessionValid(HttpSession session, HttpServletResponse res) {
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("employee") == null) {
			return false;
		}
		return true;
	}



	@PostMapping("/registerPass")
	public String doRegister(@Validated @ModelAttribute("pass") Pass  pass, BindingResult bindingResult, Model model) {
		int passId;
		if(bindingResult.hasErrors()) {

			return "pass";
		}
		else {
			
			System.out.println(pass.getVehicleId());
			System.out.println("type controller" + pass.getPassType());
			System.out.println("value controller" + pass.getPassValue());
			
			passId = passService.addPass(pass);
			return "redirect:login";
		}
	}


	@GetMapping("/getPassDetails")
	public String getVehicleById(HttpSession session, Model model, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			Employee employee = (Employee) session.getAttribute("employee");
			Vehicle vehicle = vehicleService.getVehicle(employee.getEmployeeId());
			Pass pass = passService.getPass(vehicle.getVehicleId()); 
			model.addAttribute("pass", pass);
			model.addAttribute("vehicleId", vehicle.getVehicleId());
			model.addAttribute("vehicleType", vehicle.getVehicleType());
			return "showPassDetails";
		} else {
			return "redirect:login";
		}

	}


	@PostMapping("/editPass")
	public String updatePassDetails(@Valid @ModelAttribute("pass") Pass pass, Errors errors,
			HttpSession session) {
		if (errors.hasErrors()) {
			return "showPassDetails";
		}
		else {
			Employee employee = (Employee) session.getAttribute("employee");
			Vehicle vehicleUpdate = vehicleService.getVehicle(employee.getEmployeeId());
			System.out.println(vehicleUpdate.getVehicleId());
			Pass passUpdate = passService.getPass(vehicleUpdate.getVehicleId());
			

			System.out.println("type controller" + pass.getPassType());
			System.out.println("value controller" + pass.getPassValue());
			
			passService.updatePass(passUpdate.getPassId(), pass);
			return "redirect:display";
		}

	}



}
