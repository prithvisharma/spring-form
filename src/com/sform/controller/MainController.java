package com.sform.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sform.databse.Database;
import com.sform.model.User;

@Controller
public class MainController {
	
	@Autowired
	Database database;

	@RequestMapping("/")
	public String showHome(Model model) {
		model.addAttribute("list", database.fetchUsers());
		return "home";
	}
	
	@RequestMapping("/sign-up")
	public String showForm() {
		return "form";
	}
	
	@RequestMapping("/spring-sign-up")
	public String showSForm(Model model) {
		model.addAttribute("user", new User());			// we send user object to spring form to that values are stored in it directly there
		return "sform";
	}
	
	@RequestMapping("/process-sign-up")
	public String processForm(HttpServletRequest request) { //httpservlet will get all the values from jsp to the controller 
		String fname = request.getParameter("fname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//create user object and add these values to the object
		User user = new User();
		user.setName(fname);
		user.setUsername(username);
		user.setPassword(password);
		
		// simple java validations can be done here
		//after performing validation send to db
		//System.out.println(user);
		return "redirect:login-page";
	}
	
	@RequestMapping("/process-spring-sign-up")
	public String processSpringForm(@Valid User user , BindingResult result) {			
		// here no manual processing is done for storing user details
		//@Valid will tell spring that the data within user needs to go through validation
		//@Valid must be used after validations are given to the variable
		//because this can cause errors will testing
		
		//if there is something which is not satisfying the validation spring will stop and gives error in console
		//binding result will see if there is a error then we can ask it to do some action and we ask it to return 
		//back to the spring form
		if(result.hasErrors()) {
			return "sform";
		}
		//System.out.println(user);
		int status = database.insertUser(user);
		return "redirect:login-page";
	}
	
	@RequestMapping("/login-page")
	public String showLogin() {
		return "login";
	}
}
