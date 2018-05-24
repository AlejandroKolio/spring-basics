package com.udemy.spring.controller;

import com.udemy.spring.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author alexander.shakhov on 24.05.2018 19:06
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private UserDetailsManager userDetailsManager;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	private Logger logger = Logger.getLogger(getClass().getName());

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/showRegistrationForm")
	public String showMyLoginPage(Model theModel) {
		theModel.addAttribute("crmUser", new Account());

		return "registration-form";
	}

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("user") Account account, BindingResult theBindingResult, Model theModel) {

		String userName = account.getUserName();

		logger.info("Processing registration form for: " + userName);

		// form validation
		if (theBindingResult.hasErrors()) {
			theModel.addAttribute("crmUser", new Account());
			theModel.addAttribute("registrationError", "Account name/password can not be empty.");

			logger.warning("Account name/password can not be empty.");

			return "registration-form";
		}

		// check the database if account already exists
		boolean userExists = doesUserExist(userName);

		if (userExists) {
			theModel.addAttribute("crmUser", new Account());
			theModel.addAttribute("registrationError", "Account name already exists.");

			logger.warning("Account name already exists.");

			return "registration-form";
		}

		//
		// whew ... we passed all of the validation checks!
		// let's get down to business!!!
		//

		// encrypt the password
		String encodedPassword = passwordEncoder.encode(account.getPassword());

		// prepend the encoding algorithm id
		encodedPassword = "{bcrypt}" + encodedPassword;

		// give account default role of "employee"
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");

		// create account object (from Spring Security framework)
		User user = new User(userName, encodedPassword, authorities);

		// save account in the database
		userDetailsManager.createUser(user);

		logger.info("Successfully created account: " + userName);

		return "registration-confirmation";
	}

	private boolean doesUserExist(String userName) {
		logger.info("Checking if user exists: " + userName);
		// check the database if the user already exists
		boolean exists = userDetailsManager.userExists(userName);
		logger.info("Account: " + userName + ", exists: " + exists);

		return exists;
	}
}
