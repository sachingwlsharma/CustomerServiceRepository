package com.cg.PersonService.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.cg.PersonService.model.Person;
import com.cg.PersonService.service.IPersonService;

/**
 * 
 * @author sharsaca
 * 
 *
 */

@Controller
public class PersonController {

	@Autowired
	IPersonService personservice;

	@GetMapping({ "/", "/signup" })
	public String showSignUpForm(Person person) {

		return "add-user";
	}

	@PostMapping("/adduser")
	public String addUser(@Valid Person person, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "add-user";
		}

		try {
			personservice.save(person);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("persons", personservice.findAll());
		return "showUser";
	}

}
