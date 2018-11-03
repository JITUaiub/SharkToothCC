package org.sharktooth.gms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.sharktooth.gms.helper.UserAccessControl;
import org.sharktooth.gms.model.User;
import org.sharktooth.gms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	private User activeUser;
	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView loginPage(Model dataModel, HttpServletRequest request) {
		ModelAndView model = new ModelAndView(UserAccessControl.viewSelectorSession(request, "users/dashboard"));
		dataModel.addAttribute("user", new User());

		return model;
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView viewProfile(Model dataModel, HttpServletRequest request) {
		ModelAndView model = new ModelAndView(UserAccessControl.viewSelectorSession(request, "users/profile"));
		dataModel.addAttribute("user", (User) request.getSession().getAttribute("loggedUser"));

		return model;
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
	public ModelAndView editProfile(Model dataModel, HttpServletRequest request) {
		ModelAndView model = new ModelAndView(UserAccessControl.viewSelectorSession(request, "users/editProfile"));

		return model;
	}

	@RequestMapping(value = "/profile/edit/action", method = RequestMethod.POST)
	public ModelAndView editProfileSubmit(@Valid @ModelAttribute("user") User user, HttpServletRequest request,
			BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();

		return model;
	}

	@RequestMapping(value = "/profile/changePassword", method = RequestMethod.GET)
	public ModelAndView changePassword(Model dataModel, HttpServletRequest request) {
		ModelAndView model = new ModelAndView(UserAccessControl.viewSelectorSession(request, "users/changePassword"));
		activeUser = (User) request.getSession().getAttribute("loggedUser");
		model.addObject("user", activeUser);
		return model;
	}

	@RequestMapping(value = "/profile/changePassword/action", method = RequestMethod.GET)
	public ModelAndView changePasswordSubmit(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView("users/changePassword");
		if (bindingResult.hasErrors()) {
			return model;
		}
		for(User userDetails : getUserService().getUserList()) {
			if (userDetails.getEmail().equals(activeUser.getEmail())) {
				System.out.println("Logged User Email: " + userDetails.getEmail());
				System.out.println("Logged User Password: " + userDetails.getPassword());
				userDetails.setPassword(user.getPassword());
				System.out.println("Logged User New Password: " + userDetails.getPassword());
				user = userDetails;
				System.out.println(user.getEmail() + " -- "  + user.getPassword());
				break;
			}
		}
		getUserService().updateUser(user);
		model.addObject("successMessage", "Password changed successfully.");
		return model;
	}
}
