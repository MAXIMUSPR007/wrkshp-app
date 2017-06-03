package com.darthmaximus.wrkshp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.darthmaximus.wrkshp.models.AlertsModel;
import com.darthmaximus.wrkshp.models.CustomerModel;
import com.darthmaximus.wrkshp.models.CustomerSearch;
import com.darthmaximus.wrkshp.services.CustomerService;

@Controller
@Secured(value={"ROLE_ADMIN", "ROLE_USER"})
@RequestMapping("/web/customers")
@SessionAttributes("customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(path={"","/"}, method={RequestMethod.GET})
	public String index(Model model, CustomerSearch search, Pageable pageable) {
		model.addAttribute("search", search);
		model.addAttribute("page", customerService.search(pageable, search));
		return "customers/index";
	}

	@RequestMapping(path={"", "/"}, method={RequestMethod.POST})
	public String search(Model model, CustomerSearch search, Pageable pageable) {
		model.addAttribute("search", search);
		model.addAttribute("page", customerService.search(pageable, search));
		return "redirect:/web/customers";
	}
	
	@RequestMapping(path={"/{id}", "/{id}/"}, method={RequestMethod.GET})
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("customer", id > 0 ? customerService.retrieve(id) : new CustomerModel());
		return "customers/view";
	}
	
	@RequestMapping(value={"/{id}", "/{id}/"}, method={RequestMethod.POST})
	public String save(@PathVariable Long id, CustomerModel customer, Model model, RedirectAttributes redirectAttributes) {
		CustomerModel result = customerService.save(customer);
		if (result != null) {
			redirectAttributes.addFlashAttribute("alerts", new AlertsModel("success", "Successfully created customer " + result.getBuildName() + "!"));
			return "redirect:/web/customers/" + result.getId();
		}
		redirectAttributes.addFlashAttribute("alerts", new AlertsModel("danger", "An error occurred while saving customer!"));
		return "redirect:/web/customers";
	}
	
	@RequestMapping(value={"/{id}", "/{id}/"}, method={RequestMethod.POST}, params="delete")
	public String delete(@PathVariable Long id, CustomerModel customer, Model model, RedirectAttributes redirectAttributes) {
		if (customerService.delete(id)) {
			redirectAttributes.addFlashAttribute("alert", new AlertsModel("warning", "Customer " + customer.getBuildName() + " deleted."));
			return "redirect:/web/customers";
		}
		redirectAttributes.addFlashAttribute("alert", new AlertsModel("danger", "An error occurred while deleting customer!"));
		return "redirect:/web/customers";
	}
}
