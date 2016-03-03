package controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import impl.*;

@Controller
public class UserController {
	@Autowired
	IUtilService service;
	@Autowired
	IServiceTest serviceTest;

	@RequestMapping(value = "/welcome")
	public String welcomeUsere() {
		return "welcome";
	}
	@RequestMapping(value = "/Error")
	public String pageError() {
		return "Error";
	}
	@RequestMapping(value = "/")
	public String defaultPage() {
		return "welcome";
	}
	@RequestMapping(value = "login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	@RequestMapping(value = "/access_denied")
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "access-denied";
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
}
