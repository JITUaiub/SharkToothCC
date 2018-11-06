package main.java.org.sharktooth.gms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import main.java.org.sharktooth.gms.model.User;
import main.java.org.sharktooth.gms.model.UsersQuery;
import main.java.org.sharktooth.gms.service.GuildInfoService;
import main.java.org.sharktooth.gms.service.UsersQueryService;

@Controller
public class PublicController {
	
	@Autowired
	private UsersQueryService service;
	@Autowired
	private GuildInfoService guildInfoService;
	
	public GuildInfoService getGuildInfoService() {
		return guildInfoService;
	}

	public void setGuildInfoService(GuildInfoService guildInfoService) {
		this.guildInfoService = guildInfoService;
	}

	public UsersQueryService getService() {
		return service;
	}

	public void setService(UsersQueryService service) {
		this.service = service;
	}

	@RequestMapping(value = { "/", "/home", "/index" }, method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView model = new ModelAndView("home");

		return model;
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView aboutPage() {
		ModelAndView model = new ModelAndView("about");
		
		List<User> userList = getGuildInfoService().getUserList();
		model.addObject("totalMember", userList.size());
		int countNon = 0;
		if (userList.stream().filter(o -> o.getAccountType().equals("member onleave")).findFirst().isPresent()) {
			countNon++;
		}
		model.addObject("activeMember", userList.size() - countNon);
		model.addObject("vacancy", 75 - (userList.size() - countNon));
		return model;
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contactPage(Model dataModel) {
		ModelAndView model = new ModelAndView("contact");
		dataModel.addAttribute("usersQuery", new UsersQuery());
		return model;
	}

	@RequestMapping(value = "/contact/action", method = RequestMethod.POST)
	public ModelAndView contactSuccessPage(@Valid @ModelAttribute("usersQuery") UsersQuery usersQuery,
			BindingResult bindingResult) {
		ModelAndView model = new ModelAndView("contact");

		if (bindingResult.hasErrors()) {
			return model;
		}
		getService().saveUsersQuery(usersQuery);
		model.addObject("contactSuccess", "Thank you for your response. We'll contact you as soon as possible.");
		return model;
	}
}
