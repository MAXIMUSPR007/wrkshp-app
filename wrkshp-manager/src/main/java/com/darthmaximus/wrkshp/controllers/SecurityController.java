package com.darthmaximus.wrkshp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.darthmaximus.wrkshp.models.AlertsModel;

@Controller
@RequestMapping("/")
public class SecurityController {
	@RequestMapping(value={"/login", "/login/"}, method=RequestMethod.GET)
	public String loginPage(String message, Model model) {
		if (message != null) {
			model.addAttribute("alerts", AlertsModel.Code.valueOf(message.toUpperCase()).getAlert());
		}
		return "login";
	}
	
	@RequestMapping(value={"/accessDenied", "/accessDenied/"}, method=RequestMethod.GET)
	public String accessDenied(Model model) {
		model.addAttribute("alerts", AlertsModel.Code.ACCESS.getAlert());
		return "accessDenied";
	}
}
