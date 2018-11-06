package main.java.org.sharktooth.gms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import main.java.org.sharktooth.gms.helper.EmailSender;
import main.java.org.sharktooth.gms.helper.UserAccessControl;
import main.java.org.sharktooth.gms.model.User;
import main.java.org.sharktooth.gms.model.UserLogin;
import main.java.org.sharktooth.gms.service.UserService;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(Model dataModel, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("login");
		dataModel.addAttribute("userLogin", new UserLogin());
		if (UserAccessControl.checkSessionStatus(request, "loggedUser")) {
			model.setViewName("redirect:/user/dashboard");
		}
		return model;
	}

	@RequestMapping(value = "/login/action", method = RequestMethod.POST)
	public ModelAndView loginSuccessPage(@Valid @ModelAttribute("userLogin") UserLogin userLogin,
			BindingResult bindingResult, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("login");
		}

		ModelAndView model = new ModelAndView("redirect:/user/dashboard");
		User user = getUserService().validateUserCredential(userLogin.getEmail(), userLogin.getPassword());
		if (user != null) {
			if (userLogin.getEmail().equals("") || userLogin.getPassword().equals("")) {
				model.setViewName("login");
				model = new ModelAndView("login");
				model.addObject("loginErrorMsg", "Email or Password Cannot be Empty.");
				return model;
			}
			UserAccessControl.setSessionAttribute(request, "loggedUser", user);
			model.addObject("user", user);
			return model;
		} else {
			model.setViewName("login");
			model = new ModelAndView("login");
			model.addObject("loginErrorMsg", "Wrong email or password. Please try again.");
		}
		return model;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registrationPage(Model dataModel) {
		ModelAndView model = new ModelAndView("registration");
		dataModel.addAttribute("user", new User());
		return model;
	}

	@RequestMapping(value = "/registration/action", method = RequestMethod.POST)
	public ModelAndView registrationSuccessPage(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
			HttpServletRequest request) {
		ModelAndView model = new ModelAndView("registration");

		if (bindingResult.hasErrors()) {
			return model;
		}
		List<User> userList = getUserService().getUserList();

			if (userList.stream().filter(o -> o.getUsername().equals(user.getUsername())).findFirst()
					.isPresent() == true) {
				model.addObject("regSuccessMsg1", "Username is already taken.");
			} else if (userList.stream().filter(o -> o.getEmail().equals(user.getEmail())).findFirst()
					.isPresent() == true) {
				model.addObject("regSuccessMsg1", "Email is already taken.");
			} else {
				getUserService().registerUser(user);
				model.addObject("user", user);
				model.addObject("regSuccessMsg1",
						"<b class='subtitle is-smaall' style='color: RED'>Registration Successfull.</b> <a href='/SharkToothCC/account/login'>Login now</a>");
			}

		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logOut(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("redirect:/account/login");

		UserAccessControl.removeSessionAttribute(request, "loggedUser");
		return model;
	}
	
	@RequestMapping(value = "/recoverPassword", method = RequestMethod.GET)
	public ModelAndView recoverPassword(Model dataModel) {
		ModelAndView model = new ModelAndView("recoverPassword");
		
		return model;
	}
	
	@RequestMapping(value = "/recoverPassword/action", method = RequestMethod.POST)
	public ModelAndView recoverPasswordSuccess(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView("recoverPassword");
		if (bindingResult.hasErrors()) {
			return model;
		}
		if (getUserService().getUserList().stream().filter(o -> o.getEmail().equals(user.getEmail())).findFirst().isPresent()) {
			for(User userDetails : getUserService().getUserList()) {
				if (userDetails.getEmail().equals(user.getEmail())) {
					String message = "Username: " + userDetails.getUsername() + "\nEmail: " + userDetails.getEmail() + "\nPassword: " + userDetails.getPassword();
					EmailSender.sendEmail(userDetails.getEmail(), "Password Reset - Sharktooth Castle Clash", message);
					break;
				}
			}
		}
		model.addObject("successMessage", "Please check your Email inbox.");
		return model;
	}
}
