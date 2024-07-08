package co.wfd2.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.wfd2.controller.entity.user.User;
import co.wfd2.service.user.UserService;
import lombok.extern.slf4j.Slf4j;

//@Slf4j
@Controller
@RequestMapping(path = "/")
public class HomeController {

	static Logger logger = LogManager.getLogger(SNTEController.class.getName());

	private final UserService userService;

	@Autowired
	public HomeController(UserService userService){
		this.userService = userService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		User user = User.map(userService.getByUsername(auth.getName()));
		modelAndView.addObject("userName", user.getUserName());
		modelAndView.addObject("name", user.getName());
		modelAndView.addObject("surname", user.getLastName());
		modelAndView.addObject("email", user.getEmail());

		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");

		modelAndView.setViewName("home");
		return modelAndView;
	}
}
