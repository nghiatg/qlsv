package com.example.demo.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}
	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.setViewName("signup");
		return model;
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
	public ModelAndView createUser(@RequestParam String firstname, @RequestParam String lastname,
			@RequestParam String email, @RequestParam String password) {
		ModelAndView model = new ModelAndView();
		User userExists = userService.findUserByEmail(email);
		if (userExists != null) {
		}
		User user = new User(email, firstname, lastname, password);
		userService.saveUser(user);
		model.addObject("msg", "User has been registered successfully!");
		model.addObject("user", new User());
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = { "/access_denied" }, method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		ModelAndView model = new ModelAndView();
		model.setViewName("access_denied");
		return model;
	}
}
