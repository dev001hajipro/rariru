package com.github.dev001hajipro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/")
public class MainController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(path = "/")
	public @ResponseBody String index() {
		String message = "こんにちはSpringプロジェクト";
		return message;
	}
	
	@GetMapping(path="/count")
	public @ResponseBody long getCount() {
		return userRepository.count();
	}
}
