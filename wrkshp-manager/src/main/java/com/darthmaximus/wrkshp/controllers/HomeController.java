package com.darthmaximus.wrkshp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/web")
public class HomeController {
	@RequestMapping(path={"","/"}, method={RequestMethod.GET})
	public String index() {
		return "index";
	}
}
