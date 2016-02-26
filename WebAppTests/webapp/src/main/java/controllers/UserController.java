package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import services.UtilService;
import services.ServiceTest;

@Controller
public class UserController {
	@Autowired
	UtilService service;
	@Autowired
	ServiceTest serviceTest;

	@RequestMapping(value = "/validate")
	public String validateUser(String name, String password, ModelMap model) {
		int accessLevel = 0;
		accessLevel = service.validateUser(name, password);
		model.put("resultTest", 0);
		if (accessLevel == 1) {
			if (serviceTest.getAllTests().size() > 0)
				model.put("tests", serviceTest.getAllTests());
			return "viewtests";
		}
		if (accessLevel == 2)
			return "inputTest";
		if (accessLevel == 0) {
			model.put("incorrect", "Can't find user  "+name);
		}
		return "login";
	}
}
