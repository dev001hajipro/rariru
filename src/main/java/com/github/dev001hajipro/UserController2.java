package com.github.dev001hajipro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/user2")
public class UserController2 {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(path = "/")
	public ModelAndView index(ModelAndView mav) {
		String message = "こんにちはSpringプロジェクト";
		mav.addObject("message", message);
		Iterable<User> users = userRepository.findAll();
		mav.addObject("users", users);
		mav.setViewName("user");
		return mav;
	}

	@GetMapping(path="/count")
	public @ResponseBody long getCount() {
		return userRepository.count();
	}
	
	@RequestMapping(path ="/add", method= {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody String add(@RequestParam String name,
			@RequestParam String email) {
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		userRepository.save(user);
		
		return "Saved";
		
	}
}
